package com.sistema.urcipy.controladores;

import com.sistema.urcipy.entidades.Ciudad;
import com.sistema.urcipy.servicios.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ciudadpub")
@CrossOrigin("*")
public class CiudadPubController {
    @Autowired
    private CiudadService ciudadService;

    @GetMapping("/")
    public ResponseEntity<?> listarCiudades(){
        return ResponseEntity.ok(ciudadService.obtenerCiudades());
    }
    }
