package com.sistema.urcipy.controladores;

import com.sistema.urcipy.entidades.Pais;
import com.sistema.urcipy.servicios.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paispub")
@CrossOrigin("*")
public class PaisPubController {
    @Autowired
    private PaisService paisService;



    @GetMapping("/")
    public ResponseEntity<?> listarPaises(){
        return ResponseEntity.ok(paisService.obtenerPaises());
    }
   }
