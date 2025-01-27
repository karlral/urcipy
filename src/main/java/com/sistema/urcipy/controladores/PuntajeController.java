package com.sistema.urcipy.controladores;

import com.sistema.urcipy.entidades.Puntaje;

import com.sistema.urcipy.servicios.PuntajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/puntaje")
@CrossOrigin("*")
public class PuntajeController {

    @Autowired
    private PuntajeService puntajeService;


    @PostMapping("/")
    public ResponseEntity<Puntaje> guardarPuntaje(@RequestBody Puntaje puntaje){
        Puntaje puntajeGuardada = puntajeService.guardarPuntaje(puntaje);
        return ResponseEntity.ok(puntajeGuardada);
    }
    @GetMapping("/{idpuntaje}")
    public Puntaje obtenerPuntajePorId(@PathVariable("idpuntaje") Integer idpuntaje){
        return puntajeService.obtenerPuntaje(idpuntaje);
    }

    @GetMapping("/")
    public ResponseEntity<?> listarPuntajees(){
        return ResponseEntity.ok(puntajeService.obtenerPuntajees());
    }
    @PutMapping("/")
    public Puntaje actualizarPuntaje(@RequestBody Puntaje puntaje){
        return puntajeService.guardarPuntaje(puntaje);
    }
    @DeleteMapping("/{idpuntaje}")
    public void eliminarPuntaje(@PathVariable("idpuntaje") Integer idpuntaje){
        puntajeService.eliminarPuntaje(idpuntaje);
    }
}