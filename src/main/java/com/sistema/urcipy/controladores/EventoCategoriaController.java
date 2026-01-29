package com.sistema.urcipy.controladores;

import com.sistema.urcipy.entidades.EventoCategoria;
import com.sistema.urcipy.servicios.EventoCategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eventocategoria")
@CrossOrigin("*")
public class EventoCategoriaController {
    @Autowired
    private EventoCategoriaService eventoCategoriaService;


    @PostMapping("/")
    public ResponseEntity<EventoCategoria> guardarEventoCategoria(@RequestBody EventoCategoria eventoCategoria){
        EventoCategoria eventoCategoriaGuardada = eventoCategoriaService.guardarEventoCategoria(eventoCategoria);
        return ResponseEntity.ok(eventoCategoriaGuardada);
    }
    @GetMapping("/{ideventoCategoria}")
    public EventoCategoria obtenerEventoCategoriaPorId(@PathVariable("ideventoCategoria") Integer ideventoCategoria){
        return eventoCategoriaService.obtenerEventoCategoria(ideventoCategoria);
    }

    @GetMapping("/")
    public ResponseEntity<?> listarEventoCategoriaes(){
        return ResponseEntity.ok(eventoCategoriaService.obtenerEventoCategoriaes());
    }
    @PutMapping("/")
    public EventoCategoria actualizarEventoCategoria(@RequestBody EventoCategoria eventoCategoria){
        return eventoCategoriaService.guardarEventoCategoria(eventoCategoria);
    }
    @DeleteMapping("/{ideventoCategoria}")
    public void eliminarEventoCategoria(@PathVariable("ideventoCategoria") Integer ideventoCategoria){
        eventoCategoriaService.eliminarEventoCategoria(ideventoCategoria);
    }
}
