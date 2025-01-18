package com.sistema.urcipy.controladores;

import com.sistema.urcipy.entidades.Evento;
import com.sistema.urcipy.servicios.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventopub")
@CrossOrigin("*")
public class EventoPubController {
    @Autowired
    private EventoService eventoService;

    @GetMapping("/{idevento}")
    public Evento obtenerEventoPorId(@PathVariable("idevento") Integer idevento){
        return eventoService.obtenerEvento(idevento);
    }

    @GetMapping("/modo/{modo}/{idregional}")
    public ResponseEntity<?> listarEventosModo(@PathVariable("modo") Integer modo, @PathVariable("idregional") Integer idregional){
        return ResponseEntity.ok(eventoService.obtenerEventosModo(modo,idregional));
    }
    @GetMapping("/modo/culminados/{idregional}")
    public ResponseEntity<?> listarEventosModo(@PathVariable("idregional" ) Integer idregional){
        return ResponseEntity.ok(eventoService.obtenerEventosCulminados(idregional));
    }

    @GetMapping("/activos/{idregional}")
    public List<Evento> listarEventosActivos(@PathVariable("idregional") Integer idregional){
        return eventoService.obtenerEventosActivos(idregional);
    }

    @GetMapping("/activo/{activo}")
    public Evento listarEventoActivo(@PathVariable("activo") Integer activo){
        return  eventoService.obtenerEventoActivo(activo);
    }

    @GetMapping("/system/{idregional}")
    public ResponseEntity<?> listarEventoes(@PathVariable("idregional") Integer idregional){
        return ResponseEntity.ok(eventoService.obtenerEventoes(idregional));
    }
    }
