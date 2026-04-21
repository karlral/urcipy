package com.sistema.urcipy.servicios;



import com.sistema.urcipy.entidades.Rol;

import java.util.Set;


public interface RolService {

    public Rol guardarRol(Rol rol);

    public Set<Rol> obtenerRoles();

    public Rol obtenerRol(Integer idrol);

    public void eliminarRol(Integer idrol);

}
