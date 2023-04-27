package com.sistema.urcipy.controladores;

import com.sistema.urcipy.entidades.Categoria;
import com.sistema.urcipy.servicios.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categoria")
@CrossOrigin("*")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;


    @PostMapping("/")
    public ResponseEntity<Categoria> guardarCategoria(@RequestBody Categoria categoria){
        Categoria categoriaGuardada = categoriaService.guardarCategoria(categoria);
        return ResponseEntity.ok(categoriaGuardada);
    }
    @GetMapping("/{idcategoria}")
    public Categoria obtenerCategoriaPorId(@PathVariable("idcategoria") Integer idcategoria){
        return categoriaService.obtenerCategoria(idcategoria);
    }

    @GetMapping("/")
    public ResponseEntity<?> listarCategoriaes(){
        return ResponseEntity.ok(categoriaService.obtenerCategoriaes());
    }
    @PutMapping("/")
    public Categoria actualizarCategoria(@RequestBody Categoria categoria){
        return categoriaService.guardarCategoria(categoria);
    }
    @DeleteMapping("/{idcategoria}")
    public void eliminarCategoria(@PathVariable("idcategoria") Integer idcategoria){
        categoriaService.eliminarCategoria(idcategoria);
    }
}
