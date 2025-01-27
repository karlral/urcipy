package com.sistema.urcipy.controladores;

import com.sistema.urcipy.entidades.Persona;
import com.sistema.urcipy.servicios.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
@CrossOrigin("*")
public class PersonaController {

    @Autowired
    private PersonaService personaService;


    @PostMapping("/")
    public ResponseEntity<Persona> guardarPersona(@RequestBody Persona persona){
        Persona personaGuardada = personaService.guardarPersona(persona);
        return ResponseEntity.ok(personaGuardada);
    }
    @GetMapping("/{idpersona}")
    public Persona obtenerPersonaPorId(@PathVariable("idpersona") Integer idpersona){
        return personaService.obtenerPersona(idpersona);
    }
    @GetMapping("/ci/{ci}")
    public Persona obtenerPersonaPorId(@PathVariable("ci") String ci){
        return personaService.obtenerPersonaCi(ci);
    }

    @GetMapping("/")
    public ResponseEntity<?> listarPersonaes(){
        return ResponseEntity.ok(personaService.obtenerPersonaes());
    }
    @PutMapping("/")
    public Persona actualizarPersona(@RequestBody Persona persona){
        return personaService.guardarPersona(persona);
    }
    @DeleteMapping("/{idpersona}")
    public void eliminarPersona(@PathVariable("idpersona") Integer idpersona){
        personaService.eliminarPersona(idpersona);
    }
}