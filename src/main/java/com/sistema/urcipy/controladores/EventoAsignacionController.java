package com.sistema.urcipy.controladores;

import com.sistema.urcipy.entidades.EventoAsignacion;
import com.sistema.urcipy.entidades.custom.Participuntaje;
import com.sistema.urcipy.repositorios.ParticipanteRepository;
import com.sistema.urcipy.servicios.EventoAsignacionService;
import com.sistema.urcipy.servicios.ParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eventoasignacion")
@CrossOrigin("*")
public class EventoAsignacionController {
    @Autowired
    private EventoAsignacionService eventoAsignacionService;

    @Autowired
    private ParticipanteService participanteService;


    @PostMapping("/")
    public ResponseEntity<EventoAsignacion> guardarEventoAsignacion(@RequestBody EventoAsignacion eventoAsignacion){


        EventoAsignacion eventoAsignacionGuardada = eventoAsignacionService.guardarEventoAsignacion(eventoAsignacion);

        participanteService.actualizarPuntaje(eventoAsignacion);

        return ResponseEntity.ok(eventoAsignacionGuardada);
    }
    @GetMapping("/{ideventoAsignacion}")
    public EventoAsignacion obtenerEventoAsignacionPorId(@PathVariable("ideventoAsignacion") Integer ideventoAsignacion){
        return eventoAsignacionService.obtenerEventoAsignacion(ideventoAsignacion);
    }

    @GetMapping("/")
    public ResponseEntity<?> listarEventoAsignaciones(){
        return ResponseEntity.ok(eventoAsignacionService.obtenerEventoAsignaciones());
    }
    @PutMapping("/")
    public EventoAsignacion actualizarEventoAsignacion(@RequestBody EventoAsignacion eventoAsignacion){
        return eventoAsignacionService.guardarEventoAsignacion(eventoAsignacion);
    }
    @DeleteMapping("/{ideventoAsignacion}")
    public void eliminarEventoAsignacion(@PathVariable("ideventoAsignacion") Integer ideventoAsignacion){
        eventoAsignacionService.eliminarEventoAsignacion(ideventoAsignacion);
    }
}
