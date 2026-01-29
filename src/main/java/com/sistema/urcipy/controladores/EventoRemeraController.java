package com.sistema.urcipy.controladores;

import com.sistema.urcipy.entidades.EventoRemera;
import com.sistema.urcipy.servicios.EventoRemeraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eventoremera")
@CrossOrigin("*")
public class EventoRemeraController {
    @Autowired
    private EventoRemeraService eventoRemeraService;


    @PostMapping("/")
    public ResponseEntity<EventoRemera> guardarEventoRemera(@RequestBody EventoRemera eventoRemera){
        EventoRemera eventoRemeraGuardada = eventoRemeraService.guardarEventoRemera(eventoRemera);
        return ResponseEntity.ok(eventoRemeraGuardada);
    }
    @GetMapping("/{ideventoRemera}")
    public EventoRemera obtenerEventoRemeraPorId(@PathVariable("ideventoRemera") Integer ideventoRemera){
        return eventoRemeraService.obtenerEventoRemera(ideventoRemera);
    }

    @GetMapping("/")
    public ResponseEntity<?> listarEventoRemeraes(){
        return ResponseEntity.ok(eventoRemeraService.obtenerEventoRemeraes());
    }
    @PutMapping("/")
    public EventoRemera actualizarEventoRemera(@RequestBody EventoRemera eventoRemera){
        return eventoRemeraService.guardarEventoRemera(eventoRemera);
    }
    @DeleteMapping("/{ideventoRemera}")
    public void eliminarEventoRemera(@PathVariable("ideventoRemera") Integer ideventoRemera){
        eventoRemeraService.eliminarEventoRemera(ideventoRemera);
    }
}
