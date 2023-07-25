package com.sistema.urcipy.servicios;



import com.sistema.urcipy.entidades.Categoriah;

import java.util.Set;


public interface CategoriahService {

    public Categoriah guardarCategoriah(Categoriah categoriah);

    public Set<Categoriah> obtenerCategoriahes();

    public Categoriah obtenerCategoriah(Integer idcategoriah);

    public void eliminarCategoriah(Integer idcategoriah);

}
