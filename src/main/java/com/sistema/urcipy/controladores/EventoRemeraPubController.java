package com.sistema.urcipy.controladores;

import com.sistema.urcipy.servicios.EventoRemeraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eventoremerapub")
@CrossOrigin("*")
public class EventoRemeraPubController {
    @Autowired
    private EventoRemeraService eventoRemeraService;

    @GetMapping("/")
    public ResponseEntity<?> listarEventoRemeraes(){
        return ResponseEntity.ok(eventoRemeraService.obtenerEventoRemeraes());
    }

    @GetMapping("/{idevento}")
    public ResponseEntity<?> listarRemeraEvento(@PathVariable("idevento") Integer idevento){
        return ResponseEntity.ok(eventoRemeraService.obtenerRemerasEvento(idevento));
    }

}
