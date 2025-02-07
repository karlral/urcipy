package com.sistema.urcipy.controladores;

import com.sistema.urcipy.entidades.*;

import com.sistema.urcipy.servicios.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/corredor")
@CrossOrigin("*")
public class CorredorController {
    @Autowired
    private CorredorService corredorService;

    @Autowired
    private ParticipanteService participanteService;

    @Autowired
    private EventoService eventoService;

    @Autowired
    private CategoriaService categoriaService;
    @Autowired
    private PersonaService personaService;
    @Autowired
    private RegionalService regionalService;

    @PostMapping("/")
    public ResponseEntity<Corredor> guardarCorredor(@RequestBody Corredor corredor){
        Corredor corredorGuardada;
        List<Corredor> corredores = new ArrayList<>();
        Regional regionalco=corredor.getRegional();
        System.out.println("guardar dos veces y quedarse con esta regional");
        System.out.println(regionalco.getIdregional());
        corredorGuardada=corredorService.obtenerCorredorCi(corredor.getPersona().getCi(),regionalco.getIdregional());
        if(corredorGuardada==null) { // vamos a crear el corredor con la regional
            Persona personaGuardada, personaAux;
            personaAux = personaService.obtenerPersonaCi(corredor.getPersona().getCi());
            if (personaAux == null) { //no hay persona en la regional y se crean
                personaAux = corredor.getPersona();
            }
            personaAux.setNombre(corredor.getPersona().getNombre().toUpperCase());
            personaAux.setApellido(corredor.getPersona().getApellido().toUpperCase());
            personaGuardada = personaService.guardarPersona(personaAux);
            corredor.setPersona(personaGuardada);

            Set<Regional> regionalss=regionalService.obtenerRegionales();
            List<Regional> regionales = new ArrayList<Regional>(regionalss);
            regionales.forEach(regional -> {
                corredor.setRegional(regional);
                corredores.add(corredor);
            });

            this.corredorService.guardarCorredores(corredores);

            corredorGuardada=corredorService.obtenerCorredorCi(corredor.getPersona().getCi(),regionalco.getIdregional());
        }
        return ResponseEntity.ok(corredorGuardada);
    }
    @GetMapping("/{idcorredor}")
    public Corredor obtenerCorredorPorId(@PathVariable("idcorredor") Integer idcorredor){
        return corredorService.obtenerCorredor(idcorredor);
    }

    @GetMapping("/ci/{ci}/{idregional}")
    public Corredor obtenerCorredorPorCi(@PathVariable("ci") String ci,@PathVariable("idregional") Integer idregional){
        return corredorService.obtenerCorredorCi(ci,idregional);
    }

    @GetMapping("/")
    public ResponseEntity<?> listarCorredores(){
        return ResponseEntity.ok(corredorService.obtenerCorredores());
    }
    @PutMapping("/")
    public Corredor actualizarCorredor(@RequestBody Corredor corredor){

        corredor.getPersona().setNombre(corredor.getPersona().getNombre().toUpperCase());
        corredor.getPersona().setApellido(corredor.getPersona().getApellido().toUpperCase());
        //System.out.println("Paso -2");
        Persona personaActual= personaService.guardarPersona(corredor.getPersona());
        //System.out.println("Paso -1");
        Corredor corredor1=corredorService.guardarCorredor(corredor);
        //System.out.println("Paso 0");
        if (corredor1==null){
            return  null;
        }else {
           // System.out.println(corredor1);
            Evento evento=eventoService.obtenerEventoActivoRegional(1,corredor1.getRegional().getIdregional());
            participanteService.actualizarClubCat(evento.getIdevento(),corredor1.getIdcorredor());
            //System.out.println("Paso 1");
            corredorService.catAlianza(corredor1.getPersona().getIdpersona(),corredor1.getCategoria().getIdcategoria(),corredor1.getClub().getIdclub());
            //System.out.println("Paso 2");
            return corredor1;
        }


    }
    @DeleteMapping("/{idcorredor}")
    public void eliminarCorredor(@PathVariable("idcorredor") Integer idcorredor){
        corredorService.eliminarCorredor(idcorredor);
    }

    @GetMapping("/men/{buscado}/{idregional}")
    public ResponseEntity<?> obtenerCorredorPorCiNomApeClub(@PathVariable("buscado") String buscado,@PathVariable("idregional") Integer idregional){
        String variable;
        variable="%"+buscado+"%";
        return ResponseEntity.ok(corredorService.obtenerCorredoresmenCiNomApeClub(variable,idregional));
    }

    @GetMapping("/bus/{buscado}/{idregional}")
    public ResponseEntity<?> obtenerCorredorPorCiNomApeClubDatos(@PathVariable("buscado") String buscado,@PathVariable("idregional") Integer idregional){
        String variable;
        variable="%"+buscado+"%";
        return ResponseEntity.ok(corredorService.obtenerCorredoresbusCiNomApeClubDato(variable,idregional));
    }

    @PutMapping("/puntua")
    public void actualizarPuntuaCorredor(@RequestBody Integer idcorredor){
        Corredor corredor=corredorService.obtenerCorredor(idcorredor);
        corredor.setPuntua(1);
        corredorService.guardarCorredor(corredor);

        participanteService.activarPuntaje(idcorredor);
    }

    @PutMapping("/despuntua")
    public void actualizarDespuntuaCorredor(@RequestBody Integer idcorredor){
        Corredor corredor=corredorService.obtenerCorredor(idcorredor);
        corredor.setPuntua(0);
        corredorService.guardarCorredor(corredor);

        participanteService.desactivarPuntaje(idcorredor);

    }
    @PutMapping("/updatecategoria")
    public ResponseEntity<?>  actualizarCategoriaCorredor(){
        List<Corredor> corredores = new ArrayList<>(corredorService.obtenerCorredores());
        List<Corredor> correProblems = new ArrayList<>();
        Categoria categoria;
        Byte sexo, edad,tipo;

        Calendar calendar = Calendar.getInstance();

        Integer ano = Calendar.getInstance().get(Calendar.YEAR);
        Integer anonac=0;
        Integer contador=0;
        for (Corredor corredor:corredores) {
            sexo = corredor.getPersona().getSexo();

            calendar.setTime(corredor.getPersona().getFecnac());
             anonac = calendar.get(Calendar.YEAR);
             edad = (byte) (ano -anonac);

            tipo = corredor.getTipocat();

            categoria=categoriaService.buscarCategoria(sexo, edad, tipo);


            if (categoria==null){
                correProblems.add(corredor);
            }else{
                corredor.setCategoria(categoria);
                corredorService.guardarCorredor(corredor);
                contador=contador+1;
            }


        }

        return ResponseEntity.ok(correProblems);
    }

}
