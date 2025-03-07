package com.sistema.urcipy.controladores;

import com.sistema.urcipy.entidades.Persona;
import com.sistema.urcipy.servicios.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personapub")
@CrossOrigin("*")
public class PersonaPubController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/ci/{ci}")
    public Persona obtenerPersonaPorId(@PathVariable("ci") String ci){
        return personaService.obtenerPersonaCi(ci);
    }


}