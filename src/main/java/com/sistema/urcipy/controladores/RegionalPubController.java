package com.sistema.urcipy.controladores;

import com.sistema.urcipy.entidades.Regional;
import com.sistema.urcipy.servicios.RegionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/regionalpub")
@CrossOrigin("*")
public class RegionalPubController {
    @Autowired
    private RegionalService regionalService;



    @GetMapping("/{idregional}")
    public Regional obtenerRegionalPorId(@PathVariable("idregional") Integer idregional){
        return regionalService.obtenerRegional(idregional);
    }


}
