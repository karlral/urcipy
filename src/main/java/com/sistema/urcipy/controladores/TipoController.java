package com.sistema.urcipy.controladores;

import com.sistema.urcipy.entidades.Tipo;
import com.sistema.urcipy.servicios.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tipo")
@CrossOrigin("*")
public class TipoController {
    @Autowired
    private TipoService tipoService;


    @PostMapping("/")
    public ResponseEntity<Tipo> guardarTipo(@RequestBody Tipo tipo){
        Tipo tipoGuardada = tipoService.guardarTipo(tipo);
        return ResponseEntity.ok(tipoGuardada);
    }
    @GetMapping("/{idtipo}")
    public Tipo obtenerTipoPorId(@PathVariable("idtipo") Integer idtipo){
        return tipoService.obtenerTipo(idtipo);
    }

    @GetMapping("/")
    public ResponseEntity<?> listarTipoes(){
        return ResponseEntity.ok(tipoService.obtenerTipoes());
    }
    @PutMapping("/")
    public Tipo actualizarTipo(@RequestBody Tipo tipo){
        return tipoService.guardarTipo(tipo);
    }
    @DeleteMapping("/{idtipo}")
    public void eliminarTipo(@PathVariable("idtipo") Integer idtipo){
        tipoService.eliminarTipo(idtipo);
    }
}
