package com.sistema.urcipy.controladores;

import com.sistema.urcipy.entidades.Categoria;
import com.sistema.urcipy.entidades.Corredor;

import com.sistema.urcipy.entidades.Evento;
import com.sistema.urcipy.entidades.Persona;
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

    @PostMapping("/")
    public ResponseEntity<Corredor> guardarCorredor(@RequestBody Corredor corredor){
        Corredor corredorGuardada;
        corredorGuardada=corredorService.obtenerCorredorCi(corredor.getPersona().getCi(),corredor.getRegional().getIdregional());
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
            corredorGuardada = this.corredorService.guardarCorredor(corredor);
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
        Persona personaActual= personaService.guardarPersona(corredor.getPersona());
        Corredor corredor1=corredorService.guardarCorredor(corredor);
        if (corredor1==null){
            return  null;
        }else {
            Evento evento=eventoService.obtenerEventoActivo(1);
            participanteService.actualizarClubCat(evento.getIdevento(),corredor.getPersona().getCi(),evento.getClub().getIdclub(),corredor.getCategoria().getIdcategoria());

            corredorService.catAlianza(corredor1.getIdcorredor(),corredor1.getCategoria().getIdcategoria(),corredor1.getClub().getIdclub());
        }

        return corredor1;
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
