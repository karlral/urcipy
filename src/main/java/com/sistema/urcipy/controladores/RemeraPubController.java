package com.sistema.urcipy.controladores;

import com.sistema.urcipy.servicios.RemeraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/remerapub")
@CrossOrigin("*")
public class RemeraPubController {
    @Autowired
    private RemeraService remeraService;



    @GetMapping("/")
    public ResponseEntity<?> listarRemeraes(){
        return ResponseEntity.ok(remeraService.obtenerRemeraes());
    }
   }
