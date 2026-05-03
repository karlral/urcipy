package com.sistema.urcipy.controladores;

import com.sistema.urcipy.entidades.UsuarioRol;
import com.sistema.urcipy.servicios.UsuarioRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuariorol")
@CrossOrigin("*")
public class UsuarioRolController {
    @Autowired
    private UsuarioRolService usuarioRolService;


    @PostMapping("/")
    public ResponseEntity<UsuarioRol> guardarUsuarioRol(@RequestBody UsuarioRol usuarioRol){
        UsuarioRol usuarioRolGuardada = usuarioRolService.guardarUsuarioRol(usuarioRol);
        return ResponseEntity.ok(usuarioRolGuardada);
    }
    @GetMapping("/{idusuarioRol}")
    public UsuarioRol obtenerUsuarioRolPorId(@PathVariable("idusuarioRol") Integer idusuarioRol){
        return usuarioRolService.obtenerUsuarioRol(idusuarioRol);
    }

    @GetMapping("/")
    public ResponseEntity<?> listarUsuarioRoles(){
        return ResponseEntity.ok(usuarioRolService.obtenerUsuarioRoles());
    }
    @PutMapping("/")
    public UsuarioRol actualizarUsuarioRol(@RequestBody UsuarioRol usuarioRol){
        return usuarioRolService.actualizarUsuarioRol(usuarioRol);
    }
    @DeleteMapping("/{idusuarioRol}")
    public void eliminarUsuarioRol(@PathVariable("idusuarioRol") Integer idusuarioRol){
        usuarioRolService.eliminarUsuarioRol(idusuarioRol);
    }

    @GetMapping("/{idrol}")
    public ResponseEntity<?> listarRolUsuarios(@PathVariable("idrol") Integer idrol){
        return ResponseEntity.ok(usuarioRolService.obtenerRolUsuarios(idrol));
    }
}
