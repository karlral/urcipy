package com.sistema.urcipy.servicios;

import com.sistema.urcipy.entidades.Rol;
import com.sistema.urcipy.repositorios.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class RolServiceImpl implements RolService{

    @Autowired
    private RolRepository rolRepository;

    @Override
    public Rol guardarRol(Rol rol){
        return rolRepository.save(rol);
    }

    @Override
    public Set<Rol> obtenerRoles() {
        return new LinkedHashSet<>(rolRepository.findAll());
    }

    @Override
    public Rol obtenerRol(Integer idrol) {
        return rolRepository.findById(idrol).get();
    }

    @Override
    public void eliminarRol(Integer idrol) {
        Rol rol= new Rol();
        rol.setIdrol(idrol);
        rolRepository.delete(rol);
    }
}
