package com.sistema.urcipy.controladores;


import com.sistema.urcipy.servicios.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tipopub")
@CrossOrigin("*")
public class TipoPubController {
    @Autowired
    private TipoService tipoService;

    @GetMapping("/")
    public ResponseEntity<?> listarTipoes(){
        return ResponseEntity.ok(tipoService.obtenerTipoes());
    }


}
