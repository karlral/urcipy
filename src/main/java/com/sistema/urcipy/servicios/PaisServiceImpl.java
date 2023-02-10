package com.sistema.urcipy.servicios;

import com.sistema.urcipy.entidades.Pais;
import com.sistema.urcipy.repositorios.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class PaisServiceImpl  implements PaisService{

    @Autowired
    private PaisRepository paisRepository;

    @Override
    public Pais guardarPais(Pais pais){
        return paisRepository.save(pais);
    }

    @Override
    public Set<Pais> obtenerPaises() {
        return new LinkedHashSet<>(paisRepository.findAll());
    }

    @Override
    public Pais obtenerPais(Integer idpais) {
        return paisRepository.findById(idpais).get();
    }

    @Override
    public void eliminarPais(Integer idpais) {
        Pais pais= new Pais();
        pais.setIdpais(idpais);
        paisRepository.delete(pais);
    }
}
