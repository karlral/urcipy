package com.sistema.urcipy.controladores;

import com.sistema.urcipy.servicios.EventoTipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eventotipopub")
@CrossOrigin("*")
public class EventoTipoPubController {
    @Autowired
    private EventoTipoService eventoTipoService;




    @GetMapping("/")
    public ResponseEntity<?> listarEventoTipoes(){
        return ResponseEntity.ok(eventoTipoService.obtenerEventoTipoes());
    }

    @GetMapping("/{idevento}")
    public ResponseEntity<?> listarTiposEvento(@PathVariable("idevento") Integer idevento){
        return ResponseEntity.ok(eventoTipoService.obtenerTiposEvento(idevento));
    }
}
