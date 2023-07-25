package com.sistema.urcipy.controladores;

import com.sistema.urcipy.entidades.Campeones;
import com.sistema.urcipy.servicios.CampeonesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campeonespub")
@CrossOrigin("*")
public class CampeonesPubController {
    @Autowired
    private CampeonesService campeonesService;

    @GetMapping("/")
    public ResponseEntity<?> listarCategoriaAnhoCampeones(){
        return ResponseEntity.ok(campeonesService.obtenerCategoriahInAnho());
    }

    @GetMapping("/{idcategoriah}")
    public ResponseEntity<?>  listarCampeonesAnhoAndIdcategoriah(@PathVariable("idcategoriah") Integer idcategoriah){
        return  ResponseEntity.ok(campeonesService.obtenerCampeonesByAnhoAndIdcat(idcategoriah));
    }

}