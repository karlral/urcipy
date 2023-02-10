package com.sistema.urcipy.servicios;


import com.sistema.urcipy.entidades.Usuario;
import com.sistema.urcipy.entidades.UsuarioRol;
import com.sistema.urcipy.excepciones.UsuarioFoundException;
import com.sistema.urcipy.repositorios.RolRepository;
import com.sistema.urcipy.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Override
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {
        Usuario usuarioLocal = usuarioRepository.findByUsername(usuario.getUsername());
        if(usuarioLocal != null){
            System.out.println("El usuario ya existe");
            throw new UsuarioFoundException("El usuario ya esta presente");
        }else{
            for(UsuarioRol usuarioRol:usuarioRoles){
                rolRepository.save(usuarioRol.getRol());
            }
            usuario.getUsuarioRols().addAll(usuarioRoles);
            usuarioLocal=usuarioRepository.save(usuario);
        }
        return usuarioLocal;
    }

    @Override
    public Usuario obtenerUsuario(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public void eliminarUsuario(Integer idusuario) {
        usuarioRepository.deleteById(idusuario);

    }

    @Override
    public void actualizarPassword(Usuario usuario) throws Exception {
        usuarioRepository.save(usuario) ;
    }
}
