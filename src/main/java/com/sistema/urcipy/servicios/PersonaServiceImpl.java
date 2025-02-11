package com.sistema.urcipy.servicios;

import com.sistema.urcipy.entidades.Persona;
import com.sistema.urcipy.repositorios.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class PersonaServiceImpl implements PersonaService{

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public Persona guardarPersona(Persona persona){
        return personaRepository.save(persona);
    }
    @Override
    public Persona guardarPersonaFlush(Persona persona){
        return personaRepository.saveAndFlush(persona);
    }

    @Override
    public Set<Persona> obtenerPersonaes() {
        return new LinkedHashSet<>(personaRepository.findAll());
    }

    @Override
    public Persona obtenerPersona(Integer idpersona) {
        return personaRepository.findById(idpersona).get();
    }
    @Override
    public Persona obtenerPersonaCi(String ci) {
        return personaRepository.findPersonaByCi(ci);
    }

    @Override
    public void eliminarPersona(Integer idpersona) {
        Persona persona= new Persona();
        persona.setIdpersona(idpersona);
        personaRepository.delete(persona);
    }
}