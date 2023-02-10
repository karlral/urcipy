package com.sistema.urcipy.controladores;

import com.sistema.urcipy.entidades.Ciudad;
import com.sistema.urcipy.servicios.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ciudad")
@CrossOrigin("*")
public class CiudadController {
    @Autowired
    private CiudadService ciudadService;


    @PostMapping("/")
    public ResponseEntity<Ciudad> guardarCiudad(@RequestBody Ciudad ciudad){
        Ciudad ciudadGuardada = ciudadService.guardarCiudad(ciudad);
        return ResponseEntity.ok(ciudadGuardada);
    }
    @GetMapping("/{idciudad}")
    public Ciudad obtenerCiudadPorId(@PathVariable("idciudad") Integer idciudad){
        return ciudadService.obtenerCiudad(idciudad);
    }

    @GetMapping("/")
    public ResponseEntity<?> listarCiudades(){
        return ResponseEntity.ok(ciudadService.obtenerCiudades());
    }
    @PutMapping("/")
    public Ciudad actualizarCiudad(@RequestBody Ciudad ciudad){
        return ciudadService.guardarCiudad(ciudad);
    }
    @DeleteMapping("/{idciudad}")
    public void eliminarCiudad(@PathVariable("idciudad") Integer idciudad){
        ciudadService.eliminarCiudad(idciudad);
    }
}
