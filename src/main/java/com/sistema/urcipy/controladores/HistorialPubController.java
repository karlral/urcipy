package com.sistema.urcipy.controladores;

import com.sistema.urcipy.servicios.HistorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/historialpub")
@CrossOrigin("*")
public class HistorialPubController {
    @Autowired
    private HistorialService historialService;

    @GetMapping("/{ci}")
    public ResponseEntity<?> listarHistoriales(@PathVariable("ci") String ci){
        return ResponseEntity.ok(historialService.obtenerHistoriales(ci));
    }


}
