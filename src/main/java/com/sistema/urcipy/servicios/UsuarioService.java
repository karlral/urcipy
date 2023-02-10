package com.sistema.urcipy.servicios;



import com.sistema.urcipy.entidades.Usuario;
import com.sistema.urcipy.entidades.UsuarioRol;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface UsuarioService {
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles)  throws Exception;

    public Usuario obtenerUsuario(String username);

    public void eliminarUsuario(Integer idusuario);

    /** */
    public void actualizarPassword(Usuario usuario)  throws Exception;

}
