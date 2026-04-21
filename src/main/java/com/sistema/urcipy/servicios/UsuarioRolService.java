package com.sistema.urcipy.servicios;



import com.sistema.urcipy.entidades.Rol;
import com.sistema.urcipy.entidades.UsuarioRol;

import java.util.Set;


public interface UsuarioRolService {

    public UsuarioRol guardarUsuarioRol(UsuarioRol usuarioRol);

    public Set<UsuarioRol> obtenerUsuarioRoles();
    public Set<Rol> obtenerRolUsuarios(Integer idrol);

    public UsuarioRol obtenerUsuarioRol(Integer idusuarioRol);

    public void eliminarUsuarioRol(Integer idusuarioRol);

}
