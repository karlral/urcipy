package com.sistema.urcipy.controladores;

import com.sistema.urcipy.entidades.Tipopuntos;
import com.sistema.urcipy.servicios.TipopuntosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tipopuntos")
@CrossOrigin("*")
public class TipopuntosController {
    @Autowired
    private TipopuntosService tipopuntosService;


    @PostMapping("/")
    public ResponseEntity<Tipopuntos> guardarTipopuntos(@RequestBody Tipopuntos tipopuntos){
        Tipopuntos tipopuntosGuardada = tipopuntosService.guardarTipopuntos(tipopuntos);
        return ResponseEntity.ok(tipopuntosGuardada);
    }
    @GetMapping("/{idtipopuntos}")
    public Tipopuntos obtenerTipopuntosPorId(@PathVariable("idtipopuntos") Integer idtipopuntos){
        return tipopuntosService.obtenerTipopuntos(idtipopuntos);
    }

    @GetMapping("/")
    public ResponseEntity<?> listarTipopuntoses(){
        return ResponseEntity.ok(tipopuntosService.obtenerTipopuntoses());
    }
    @PutMapping("/")
    public Tipopuntos actualizarTipopuntos(@RequestBody Tipopuntos tipopuntos){
        return tipopuntosService.guardarTipopuntos(tipopuntos);
    }
    @DeleteMapping("/{idtipopuntos}")
    public void eliminarTipopuntos(@PathVariable("idtipopuntos") Integer idtipopuntos){
        tipopuntosService.eliminarTipopuntos(idtipopuntos);
    }
}
