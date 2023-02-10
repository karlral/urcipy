package com.sistema.urcipy.controladores;

import com.sistema.urcipy.entidades.Pais;
import com.sistema.urcipy.servicios.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pais")
@CrossOrigin("*")
public class PaisController {
    @Autowired
    private PaisService paisService;


    @PostMapping("/")
    public ResponseEntity<Pais> guardarPais(@RequestBody Pais pais){
        Pais paisGuardada = paisService.guardarPais(pais);
        return ResponseEntity.ok(paisGuardada);
    }
    @GetMapping("/{idpais}")
    public Pais obtenerPaisPorId(@PathVariable("idpais") Integer idpais){
        return paisService.obtenerPais(idpais);
    }

    @GetMapping("/")
    public ResponseEntity<?> listarPaises(){
        return ResponseEntity.ok(paisService.obtenerPaises());
    }
    @PutMapping("/")
    public Pais actualizarPais(@RequestBody Pais pais){
        return paisService.guardarPais(pais);
    }
    @DeleteMapping("/{idpais}")
    public void eliminarPais(@PathVariable("idpais") Integer idpais){
        paisService.eliminarPais(idpais);
    }
}
