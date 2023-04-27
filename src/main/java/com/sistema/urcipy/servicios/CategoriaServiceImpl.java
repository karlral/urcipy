package com.sistema.urcipy.servicios;

import com.sistema.urcipy.entidades.Categoria;
import com.sistema.urcipy.repositorios.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class CategoriaServiceImpl implements CategoriaService{

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public Categoria guardarCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    @Override
    public Set<Categoria> obtenerCategoriaes() {
        return new LinkedHashSet<>(categoriaRepository.findAll());
    }

    @Override
    public Categoria obtenerCategoria(Integer idcategoria) {
        return categoriaRepository.findById(idcategoria).get();
    }

    @Override
    public void eliminarCategoria(Integer idcategoria) {
        Categoria categoria= new Categoria();
        categoria.setIdcategoria(idcategoria);
        categoriaRepository.delete(categoria);
    }
}
