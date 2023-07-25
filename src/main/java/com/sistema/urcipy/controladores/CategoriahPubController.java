package com.sistema.urcipy.controladores;

import com.sistema.urcipy.entidades.Categoriah;
import com.sistema.urcipy.servicios.CategoriahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categoriahpub")
@CrossOrigin("*")
public class CategoriahPubController {
    @Autowired
    private CategoriahService categoriahService;



    @GetMapping("/{idcategoriah}")
    public Categoriah obtenerCategoriahPorId(@PathVariable("idcategoriah") Integer idcategoriah){
        return categoriahService.obtenerCategoriah(idcategoriah);
    }

    @GetMapping("/")
    public ResponseEntity<?> listarCategoriahes(){
        return ResponseEntity.ok(categoriahService.obtenerCategoriahes());
    }

}
