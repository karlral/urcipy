package com.sistema.urcipy.controladores;

import com.sistema.urcipy.servicios.EventoCategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eventocategoriapub")
@CrossOrigin("*")
public class EventoCategoriaPubController {
    @Autowired
    private EventoCategoriaService eventoCategoriaService;



    @GetMapping("/")
    public ResponseEntity<?> listarEventoCategoriaes(){
        return ResponseEntity.ok(eventoCategoriaService.obtenerEventoCategoriaes());
    }

    @GetMapping("/{idevento}")
    public ResponseEntity<?> listarCategoriasEvento(@PathVariable("idevento") Integer idevento){
        return ResponseEntity.ok(eventoCategoriaService.obtenerCategoriasEvento(idevento));
    }
}
