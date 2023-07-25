package com.sistema.urcipy.servicios;

import com.sistema.urcipy.entidades.Categoriah;
import com.sistema.urcipy.repositorios.CategoriahRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class CategoriahServiceImpl implements CategoriahService{

    @Autowired
    private CategoriahRepository categoriahRepository;

    @Override
    public Categoriah guardarCategoriah(Categoriah categoriah){
        return categoriahRepository.save(categoriah);
    }

    @Override
    public Set<Categoriah> obtenerCategoriahes() {
        return new LinkedHashSet<>(categoriahRepository.findAll());
    }

    @Override
    public Categoriah obtenerCategoriah(Integer idcategoriah) {
        return categoriahRepository.findById(idcategoriah).get();
    }

    @Override
    public void eliminarCategoriah(Integer idcategoriah) {
        Categoriah categoriah= new Categoriah();
        categoriah.setIdcategoriah(idcategoriah);
        categoriahRepository.delete(categoriah);
    }
}
