package com.sistema.urcipy.controladores;

import com.sistema.urcipy.entidades.Regional;
import com.sistema.urcipy.entidades.Rol;
import com.sistema.urcipy.entidades.Usuario;
import com.sistema.urcipy.entidades.UsuarioRol;
import com.sistema.urcipy.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/")
    public Usuario guardarUsuario(@RequestBody Usuario usuario) throws Exception{
        usuario.setPerfil("default.png");
     //   usuario.setPassword("12345");
        usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));

        Regional regional= new Regional();
        regional.setIdregional(1);
        usuario.setRegional(regional);

        Set<UsuarioRol> roles = new HashSet<>();
        Rol rol = new Rol();
        rol.setIdroles(2);
        rol.setNombre("NORMAL");

        UsuarioRol usuaroRol= new UsuarioRol();
        usuaroRol.setUsuario(usuario);
        usuaroRol.setRol(rol);
        roles.add(usuaroRol);

        return usuarioService.guardarUsuario(usuario,roles);
    }

    @GetMapping("/{username}")
    public Usuario obtenerUsuario(@PathVariable("username") String username){
        return usuarioService.obtenerUsuario(username);
    }
    @DeleteMapping("/{idusuario}")
    public void eliminarUsuario(@PathVariable("idusuario") Integer idusuario){
        usuarioService.eliminarUsuario(idusuario);
    }
    /***/
    @PostMapping("/actua/")
    public void actualizarPassword(@RequestBody Usuario usuario) throws Exception{
        usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
   //     usuario.setPassword(usuario.getPassword());
        usuarioService.actualizarPassword(usuario);
    }
}
