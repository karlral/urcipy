package com.sistema.urcipy.controladores;

import com.sistema.urcipy.entidades.Concepto;
import com.sistema.urcipy.servicios.ConceptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/concepto")
@CrossOrigin("*")
public class ConceptoController {
    @Autowired
    private ConceptoService conceptoService;


    @PostMapping("/")
    public ResponseEntity<Concepto> guardarConcepto(@RequestBody Concepto concepto){
        Concepto conceptoGuardada = conceptoService.guardarConcepto(concepto);
        return ResponseEntity.ok(conceptoGuardada);
    }
    @GetMapping("/{idconcepto}")
    public Concepto obtenerConceptoPorId(@PathVariable("idconcepto") Integer idconcepto){
        return conceptoService.obtenerConcepto(idconcepto);
    }

    @GetMapping("/system/{idregional}")
    public ResponseEntity<?> listarConceptoes(@PathVariable("idregional") Integer idregional){
        return ResponseEntity.ok(conceptoService.obtenerConceptoes(idregional));
    }
    @PutMapping("/")
    public Concepto actualizarConcepto(@RequestBody Concepto concepto){
        return conceptoService.guardarConcepto(concepto);
    }
    @DeleteMapping("/{idconcepto}")
    public void eliminarConcepto(@PathVariable("idconcepto") Integer idconcepto){
        conceptoService.eliminarConcepto(idconcepto);
    }
}
