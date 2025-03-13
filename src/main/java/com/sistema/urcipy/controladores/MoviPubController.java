package com.sistema.urcipy.controladores;

import com.sistema.urcipy.servicios.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movipub")
@CrossOrigin("*")
public class MoviPubController {
    @Autowired
    private MovimientoService movimientoService;

    @GetMapping("/{ci}/{idregional}")
    public ResponseEntity<?> busMovimientoesrank(@PathVariable("ci") String ci,@PathVariable("idregional") Integer idregional){

        return ResponseEntity.ok(movimientoService.obtenerCiMovimientosRanking(ci,idregional));
    }

    @GetMapping("/ranking/{idregional}")
    public ResponseEntity<?> listarMovimientoesrank(@PathVariable("idregional") Integer idregional){

        return ResponseEntity.ok(movimientoService.obtenerMovimientosRanking(idregional));
    }

}
