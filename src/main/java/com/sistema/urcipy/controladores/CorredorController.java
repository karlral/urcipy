package com.sistema.urcipy.controladores;

import com.sistema.urcipy.entidades.Corredor;
import com.sistema.urcipy.servicios.CorredorService;
import com.sistema.urcipy.servicios.ParticipanteService;
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


    @PostMapping("/")
    public ResponseEntity<Corredor> guardarCorredor(@RequestBody Corredor corredor){
        Corredor corredorGuardada = corredorService.guardarCorredor(corredor);
        return ResponseEntity.ok(corredorGuardada);
    }
    @GetMapping("/{idcorredor}")
    public Corredor obtenerCorredorPorId(@PathVariable("idcorredor") Integer idcorredor){
        return corredorService.obtenerCorredor(idcorredor);
    }

    @GetMapping("/")
    public ResponseEntity<?> listarCorredores(){
        return ResponseEntity.ok(corredorService.obtenerCorredores());
    }
    @PutMapping("/")
    public Corredor actualizarCorredor(@RequestBody Corredor corredor){

        return corredorService.guardarCorredor(corredor);
    }
    @DeleteMapping("/{idcorredor}")
    public void eliminarCorredor(@PathVariable("idcorredor") Integer idcorredor){
        corredorService.eliminarCorredor(idcorredor);
    }

    @GetMapping("/bus/{buscado}")
    public ResponseEntity<?> obtenerCorredorPorCiNomApeClub(@PathVariable("buscado") String buscado){
        String variable;
        variable="%"+buscado+"%";
        return ResponseEntity.ok(corredorService.obtenerCorredoresmenCiNomApeClub(variable));
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
