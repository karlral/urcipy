package com.sistema.urcipy.controladores;

import com.sistema.urcipy.entidades.Remera;
import com.sistema.urcipy.servicios.RemeraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/remera")
@CrossOrigin("*")
public class RemeraController {
    @Autowired
    private RemeraService remeraService;


    @PostMapping("/")
    public ResponseEntity<Remera> guardarRemera(@RequestBody Remera remera){
        Remera remeraGuardada = remeraService.guardarRemera(remera);
        return ResponseEntity.ok(remeraGuardada);
    }
    @GetMapping("/{idremera}")
    public Remera obtenerRemeraPorId(@PathVariable("idremera") Integer idremera){
        return remeraService.obtenerRemera(idremera);
    }

    @GetMapping("/")
    public ResponseEntity<?> listarRemeraes(){
        return ResponseEntity.ok(remeraService.obtenerRemeraes());
    }
    @PutMapping("/")
    public Remera actualizarRemera(@RequestBody Remera remera){
        return remeraService.guardarRemera(remera);
    }
    @DeleteMapping("/{idremera}")
    public void eliminarRemera(@PathVariable("idremera") Integer idremera){
        remeraService.eliminarRemera(idremera);
    }
}
