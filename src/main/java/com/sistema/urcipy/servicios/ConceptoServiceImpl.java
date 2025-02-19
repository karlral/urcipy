package com.sistema.urcipy.servicios;

import com.sistema.urcipy.entidades.Concepto;
import com.sistema.urcipy.repositorios.ConceptoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class ConceptoServiceImpl implements ConceptoService{

    @Autowired
    private ConceptoRepository conceptoRepository;

    @Override
    public Concepto guardarConcepto(Concepto concepto){
        return conceptoRepository.save(concepto);
    }

    @Override
    public Set<Concepto> obtenerConceptoes(Integer idregional) {
        return new LinkedHashSet<>(conceptoRepository.findByRegional_Idregional(idregional));
    }

    @Override
    public Concepto obtenerConcepto(Integer idconcepto) {
        return conceptoRepository.findById(idconcepto).get();
    }

    @Override
    public void eliminarConcepto(Integer idconcepto) {
        Concepto concepto= new Concepto();
        concepto.setIdconcepto(idconcepto);
        conceptoRepository.delete(concepto);
    }
}
