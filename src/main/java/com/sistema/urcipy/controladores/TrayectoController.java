package com.sistema.urcipy.controladores;

import com.sistema.urcipy.entidades.Trayecto;
import com.sistema.urcipy.servicios.TrayectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trayecto")
@CrossOrigin("*")
public class TrayectoController {
    @Autowired
    private TrayectoService trayectoService;


    @PostMapping("/")
    public ResponseEntity<Trayecto> guardarTrayecto(@RequestBody Trayecto trayecto){
        Trayecto trayectoGuardada = trayectoService.guardarTrayecto(trayecto);
        return ResponseEntity.ok(trayectoGuardada);
    }
    @GetMapping("/{idtrayecto}")
    public Trayecto obtenerTrayectoPorId(@PathVariable("idtrayecto") Integer idtrayecto){
        return trayectoService.obtenerTrayecto(idtrayecto);
    }

    @GetMapping("/")
    public ResponseEntity<?> listarTrayectoes(){
        return ResponseEntity.ok(trayectoService.obtenerTrayectoes());
    }
    @PutMapping("/")
    public Trayecto actualizarTrayecto(@RequestBody Trayecto trayecto){
        return trayectoService.guardarTrayecto(trayecto);
    }
    @DeleteMapping("/{idtrayecto}")
    public void eliminarTrayecto(@PathVariable("idtrayecto") Integer idtrayecto){
        trayectoService.eliminarTrayecto(idtrayecto);
    }
}
