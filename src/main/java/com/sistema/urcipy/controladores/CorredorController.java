package com.sistema.urcipy.controladores;

import com.sistema.urcipy.entidades.Categoria;
import com.sistema.urcipy.entidades.Corredor;

import com.sistema.urcipy.entidades.Evento;
import com.sistema.urcipy.servicios.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
    private CorredorClubRegionalServiceImpl corredorClubRegionalService;


    @PostMapping("/")
    public ResponseEntity<Corredor> guardarCorredor(@RequestBody Corredor corredor){
        Corredor corredorGuardada;
        corredorGuardada=corredorService.obtenerCorredorCi(corredor.getCi());
        if(corredorGuardada==null){

            corredor.setNombre(corredor.getNombre().toUpperCase());
            corredor.setApellido(corredor.getApellido().toUpperCase());
            corredorGuardada = corredorService.guardarCorredor(corredor);
        }

        return ResponseEntity.ok(corredorGuardada);
    }
    @GetMapping("/{idcorredor}")
    public Corredor obtenerCorredorPorId(@PathVariable("idcorredor") Integer idcorredor){
        return corredorService.obtenerCorredor(idcorredor);
    }

    @GetMapping("/ci/{ci}")
    public Corredor obtenerCorredorPorCi(@PathVariable("ci") String ci){
        return corredorService.obtenerCorredorCi(ci);
    }

    @GetMapping("/")
    public ResponseEntity<?> listarCorredores(){
        return ResponseEntity.ok(corredorService.obtenerCorredores());
    }
    @PutMapping("/")
    public Corredor actualizarCorredor(@RequestBody Corredor corredor){
        Corredor corredor1=corredorService.guardarCorredor(corredor);
        if (corredor1==null){
            return  null;
        }else {
            Integer idevento=eventoService.obtenerEventoActivo(1).getIdevento();
            participanteService.actualizarClubCat(idevento,corredor.getCi(),corredor.getClub().getIdclub(),corredor.getCategoria().getIdcategoria());
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
            sexo = corredor.getSexo();

            calendar.setTime(corredor.getFecnac());
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
