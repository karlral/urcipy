package com.sistema.urcipy.servicios;



import com.sistema.urcipy.entidades.Categoria;

import java.util.Set;


public interface CategoriaService {

    public Categoria guardarCategoria(Categoria categoria);

    public Set<Categoria> obtenerCategoriaes();

    public Categoria obtenerCategoria(Integer idcategoria);
    public Set<Categoria> obtenerCategoriasActivos();
    public Set<Categoria> obtenerCategoriasActivosMod(Integer idmodalidad);
    public Set<Categoria> obtenerCategoriasActivosNino();
    public void eliminarCategoria(Integer idcategoria);
    Categoria buscarCategoria(Byte sexo,Byte edad, Byte tipo,Integer idmodalidad);

}
