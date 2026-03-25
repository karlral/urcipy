package com.sistema.urcipy.controladores;

import com.sistema.urcipy.entidades.Asignacion;
import com.sistema.urcipy.servicios.AsignacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/asignacion")
@CrossOrigin("*")
public class AsignacionController {
    @Autowired
    private AsignacionService asignacionService;


    @PostMapping("/")
    public ResponseEntity<Asignacion> guardarAsignacion(@RequestBody Asignacion asignacion){
        Asignacion asignacionGuardada = asignacionService.guardarAsignacion(asignacion);
        return ResponseEntity.ok(asignacionGuardada);
    }
    @GetMapping("/{idasignacion}")
    public Asignacion obtenerAsignacionPorId(@PathVariable("idasignacion") Integer idasignacion){
        return asignacionService.obtenerAsignacion(idasignacion);
    }

    @GetMapping("/")
    public ResponseEntity<?> listarAsignaciones(){
        return ResponseEntity.ok(asignacionService.obtenerAsignaciones());
    }
    @PutMapping("/")
    public Asignacion actualizarAsignacion(@RequestBody Asignacion asignacion){
        return asignacionService.guardarAsignacion(asignacion);
    }
    @DeleteMapping("/{idasignacion}")
    public void eliminarAsignacion(@PathVariable("idasignacion") Integer idasignacion){
        asignacionService.eliminarAsignacion(idasignacion);
    }
}
