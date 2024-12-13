package com.sistema.urcipy.controladores;

import com.sistema.urcipy.entidades.Corredor;
import com.sistema.urcipy.servicios.CorredorService;
import com.sistema.urcipy.servicios.EventoService;
import com.sistema.urcipy.servicios.ParticipanteService;
import com.sistema.urcipy.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/men/{buscado}")
    public ResponseEntity<?> obtenerCorredorPorCiNomApeClub(@PathVariable("buscado") String buscado){
        String variable;
        variable="%"+buscado+"%";
        return ResponseEntity.ok(corredorService.obtenerCorredoresmenCiNomApeClub(variable));
    }

    @GetMapping("/bus/{buscado}")
    public ResponseEntity<?> obtenerCorredorPorCiNomApeClubDatos(@PathVariable("buscado") String buscado){
        String variable;
        variable="%"+buscado+"%";
        return ResponseEntity.ok(corredorService.obtenerCorredoresbusCiNomApeClubDato(variable));
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
}
