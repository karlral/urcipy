package com.sistema.urcipy.controladores;

import com.sistema.urcipy.entidades.EventoTipo;
import com.sistema.urcipy.servicios.EventoTipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eventotipo")
@CrossOrigin("*")
public class EventoTipoController {
    @Autowired
    private EventoTipoService eventoTipoService;


    @PostMapping("/")
    public ResponseEntity<EventoTipo> guardarEventoTipo(@RequestBody EventoTipo eventoTipo){
        EventoTipo eventoTipoGuardada = eventoTipoService.guardarEventoTipo(eventoTipo);
        return ResponseEntity.ok(eventoTipoGuardada);
    }
    @GetMapping("/{ideventoTipo}")
    public EventoTipo obtenerEventoTipoPorId(@PathVariable("ideventoTipo") Integer ideventoTipo){
        return eventoTipoService.obtenerEventoTipo(ideventoTipo);
    }

    @GetMapping("/")
    public ResponseEntity<?> listarEventoTipoes(){
        return ResponseEntity.ok(eventoTipoService.obtenerEventoTipoes());
    }
    @PutMapping("/")
    public EventoTipo actualizarEventoTipo(@RequestBody EventoTipo eventoTipo){
        return eventoTipoService.guardarEventoTipo(eventoTipo);
    }
    @DeleteMapping("/{ideventoTipo}")
    public void eliminarEventoTipo(@PathVariable("ideventoTipo") Integer ideventoTipo){
        eventoTipoService.eliminarEventoTipo(ideventoTipo);
    }
}
