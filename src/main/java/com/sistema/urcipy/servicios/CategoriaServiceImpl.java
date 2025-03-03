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
    public Set<Categoria> obtenerCategoriasActivos() {
        return new LinkedHashSet<>(categoriaRepository.findByActivoIsTrueOrderByTandaAscOrdenAsc());
    }

    @Override
    public Set<Categoria> obtenerCategoriasActivosNino() {
        return new LinkedHashSet<>(categoriaRepository.findByActivoIsTrueAndTrayecto_IdtrayectoOrderByTandaAscOrdenAsc(1));
    }

    @Override
    public Categoria obtenerCategoria(Integer idcategoria) {
        return categoriaRepository.findByIdcategoria(idcategoria);
    }

    @Override
    public void eliminarCategoria(Integer idcategoria) {
        Categoria categoria= new Categoria();
        categoria.setIdcategoria(idcategoria);
        categoriaRepository.delete(categoria);
    }

    @Override
    public Categoria buscarCategoria(Byte sexo, Byte edad,Byte tipo ) {
        return categoriaRepository.findBySexoAndEdadinicioIsLessThanEqualAndEdadfinIsGreaterThanEqualAndTipoAndActivo(sexo,edad,edad,tipo,true);
    }


}
