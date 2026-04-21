package com.sistema.urcipy.controladores;

import com.sistema.urcipy.entidades.Rol;
import com.sistema.urcipy.servicios.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rol")
@CrossOrigin("*")
public class RolController {
    @Autowired
    private RolService rolService;


    @PostMapping("/")
    public ResponseEntity<Rol> guardarRol(@RequestBody Rol rol){
        Rol rolGuardada = rolService.guardarRol(rol);
        return ResponseEntity.ok(rolGuardada);
    }
    @GetMapping("/{idrol}")
    public Rol obtenerRolPorId(@PathVariable("idrol") Integer idrol){
        return rolService.obtenerRol(idrol);
    }

    @GetMapping("/")
    public ResponseEntity<?> listarRoles(){
        return ResponseEntity.ok(rolService.obtenerRoles());
    }
    @PutMapping("/")
    public Rol actualizarRol(@RequestBody Rol rol){
        return rolService.guardarRol(rol);
    }
    @DeleteMapping("/{idrol}")
    public void eliminarRol(@PathVariable("idrol") Integer idrol){
        rolService.eliminarRol(idrol);
    }
}
