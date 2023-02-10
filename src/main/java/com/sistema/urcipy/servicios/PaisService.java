package com.sistema.urcipy.servicios;



import com.sistema.urcipy.entidades.Pais;
import org.springframework.stereotype.Service;

import java.util.Set;


public interface PaisService {

    public Pais guardarPais(Pais pais);

    public Set<Pais> obtenerPaises();

    public Pais obtenerPais(Integer idpais);

    public void eliminarPais(Integer idpais);

}
