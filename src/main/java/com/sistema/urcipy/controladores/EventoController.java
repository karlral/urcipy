package com.sistema.urcipy.controladores;

import com.sistema.urcipy.entidades.Evento;
import com.sistema.urcipy.servicios.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/evento")
@CrossOrigin("*")
public class EventoController {
    @Autowired
    private EventoService eventoService;


    @PostMapping("/")
    public ResponseEntity<Evento> guardarEvento(@RequestBody Evento evento){
        Evento eventoGuardada = eventoService.guardarEvento(evento);
        return ResponseEntity.ok(eventoGuardada);
    }
    @GetMapping("/{idevento}")
    public Evento obtenerEventoPorId(@PathVariable("idevento") Integer idevento){
        return eventoService.obtenerEvento(idevento);
    }

    @GetMapping("/{idregional}")
    public ResponseEntity<?> listarEventoes(@PathVariable("idregional") Integer idregional){
        return ResponseEntity.ok(eventoService.obtenerEventoes(idregional));
    }


    @PutMapping("/")
    public Evento actualizarEvento(@RequestBody Evento evento){
        return eventoService.guardarEvento(evento);
    }
    @DeleteMapping("/{idevento}")
    public void eliminarEvento(@PathVariable("idevento") Integer idevento){
        eventoService.eliminarEvento(idevento);
    }
}
