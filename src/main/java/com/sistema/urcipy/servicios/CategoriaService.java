package com.sistema.urcipy.servicios;



import com.sistema.urcipy.entidades.Categoria;

import java.util.Set;


public interface CategoriaService {

    public Categoria guardarCategoria(Categoria categoria);

    public Set<Categoria> obtenerCategoriaes();

    public Categoria obtenerCategoria(Integer idcategoria);

    public void eliminarCategoria(Integer idcategoria);

}
