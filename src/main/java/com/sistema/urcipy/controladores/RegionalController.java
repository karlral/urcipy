package com.sistema.urcipy.controladores;

import com.sistema.urcipy.entidades.Regional;
import com.sistema.urcipy.servicios.RegionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/regional")
@CrossOrigin("*")
public class RegionalController {
    @Autowired
    private RegionalService regionalService;


    @PostMapping("/")
    public ResponseEntity<Regional> guardarRegional(@RequestBody Regional regional){
        Regional regionalGuardada = regionalService.guardarRegional(regional);
        return ResponseEntity.ok(regionalGuardada);
    }
    @GetMapping("/{idregional}")
    public Regional obtenerRegionalPorId(@PathVariable("idregional") Integer idregional){
        return regionalService.obtenerRegional(idregional);
    }

    @GetMapping("/")
    public ResponseEntity<?> listarRegionales(){
        return ResponseEntity.ok(regionalService.obtenerRegionales());
    }
    @PutMapping("/")
    public Regional actualizarRegional(@RequestBody Regional regional){
        return regionalService.guardarRegional(regional);
    }
    @DeleteMapping("/{idregional}")
    public void eliminarRegional(@PathVariable("idregional") Integer idregional){
        regionalService.eliminarRegional(idregional);
    }
}
