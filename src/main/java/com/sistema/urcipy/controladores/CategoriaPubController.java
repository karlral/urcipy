package com.sistema.urcipy.controladores;

import com.sistema.urcipy.entidades.Categoria;
import com.sistema.urcipy.servicios.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categoriapub")
@CrossOrigin("*")
public class CategoriaPubController {
    @Autowired
    private CategoriaService categoriaService;



    @GetMapping("/{idcategoria}")
    public Categoria obtenerCategoriaPorId(@PathVariable("idcategoria") Integer idcategoria){
        return categoriaService.obtenerCategoria(idcategoria);
    }

    @GetMapping("/")
    public ResponseEntity<?> listarCategoriaes(){
        return ResponseEntity.ok(categoriaService.obtenerCategoriasActivos());
    }

    @GetMapping("/nino")
    public ResponseEntity<?> listarCategoriasNino(){
        return ResponseEntity.ok(categoriaService.obtenerCategoriasActivosNino());
    }

}
