package com.sistema.urcipy.servicios;

import com.sistema.urcipy.entidades.Rol;
import com.sistema.urcipy.entidades.Usuario;
import com.sistema.urcipy.entidades.UsuarioRol;
import com.sistema.urcipy.entidades.Tipo;
import com.sistema.urcipy.repositorios.UsuarioRepository;
import com.sistema.urcipy.repositorios.UsuarioRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UsuarioRolServiceImpl implements UsuarioRolService{

    @Autowired
    private UsuarioRolRepository usuarioRolRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public UsuarioRol guardarUsuarioRol(UsuarioRol usuarioRol){
        return usuarioRolRepository.save(usuarioRol);
    }
    @Override
    public UsuarioRol actualizarUsuarioRol(UsuarioRol usuarioRol){
        Usuario usuario = usuarioRepository.findByUsername(usuarioRol.getUsuario().getUsername());
        usuario.setEnabled(usuarioRol.getUsuario().isEnabled());
        usuarioRepository.saveAndFlush(usuario);
        return usuarioRolRepository.saveAndFlush(usuarioRol);
    }

    @Override
    public Set<UsuarioRol> obtenerUsuarioRoles() {
        return new LinkedHashSet<>(usuarioRolRepository.findAll());
    }
    @Override
    public Set<Rol> obtenerRolUsuarios(Integer idrol){
        Set<UsuarioRol> usuarioRols=usuarioRolRepository.findAllByRol_idrol(idrol);
        return new LinkedHashSet<>(usuarioRols.stream().map(UsuarioRol::getRol).collect(Collectors.toSet()));

    }

    @Override
    public UsuarioRol obtenerUsuarioRol(Integer idusuarioRol) {
        return usuarioRolRepository.findById(idusuarioRol).get();
    }

    @Override
    public void eliminarUsuarioRol(Integer idusuarioRol) {
        UsuarioRol usuarioRol= new UsuarioRol();
        usuarioRol.setIdusuarioRol(idusuarioRol);
        usuarioRolRepository.delete(usuarioRol);
    }
}
