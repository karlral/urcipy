package com.sistema.urcipy.controladores;

import com.sistema.urcipy.entidades.Modalidad;
import com.sistema.urcipy.servicios.ModalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/modalidad")
@CrossOrigin("*")
public class ModalidadController {
    @Autowired
    private ModalidadService modalidadService;


    @PostMapping("/")
    public ResponseEntity<Modalidad> guardarModalidad(@RequestBody Modalidad modalidad){
        Modalidad modalidadGuardada = modalidadService.guardarModalidad(modalidad);
        return ResponseEntity.ok(modalidadGuardada);
    }
    @GetMapping("/{idmodalidad}")
    public Modalidad obtenerModalidadPorId(@PathVariable("idmodalidad") Integer idmodalidad){
        return modalidadService.obtenerModalidad(idmodalidad);
    }

    @GetMapping("/")
    public ResponseEntity<?> listarModalidades(){
        return ResponseEntity.ok(modalidadService.obtenerModalidades());
    }
    @PutMapping("/")
    public Modalidad actualizarModalidad(@RequestBody Modalidad modalidad){
        return modalidadService.guardarModalidad(modalidad);
    }
    @DeleteMapping("/{idmodalidad}")
    public void eliminarModalidad(@PathVariable("idmodalidad") Integer idmodalidad){
        modalidadService.eliminarModalidad(idmodalidad);
    }
}