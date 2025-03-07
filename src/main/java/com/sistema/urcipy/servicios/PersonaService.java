package com.sistema.urcipy.servicios;



import com.sistema.urcipy.entidades.Persona;

import java.util.Set;


public interface PersonaService {

    public Persona guardarPersona(Persona persona);
    public Persona guardarPersonaFlush(Persona persona);
    public Set<Persona> obtenerPersonaes();

    public Persona obtenerPersona(Integer idpersona);

    public Persona obtenerPersonaCi(String ci);

    public void eliminarPersona(Integer idpersona);

    public void updateTamano(Integer idpersona,Integer tamano);

}