package com.sistema.urcipy.controladores;

import com.sistema.urcipy.entidades.Corredor;
import com.sistema.urcipy.servicios.CorredorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/corredor")
@CrossOrigin("*")
public class CorredorController {
    @Autowired
    private CorredorService corredorService;


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
}
