package com.sistema.urcipy.servicios;



import com.sistema.urcipy.entidades.Concepto;

import java.util.Set;


public interface ConceptoService {

    public Concepto guardarConcepto(Concepto concepto);

    public Set<Concepto> obtenerConceptoes(Integer idregional);

    public Concepto obtenerConcepto(Integer idconcepto);

    public void eliminarConcepto(Integer idconcepto);

}
