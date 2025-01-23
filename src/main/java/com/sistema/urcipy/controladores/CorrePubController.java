package com.sistema.urcipy.controladores;


import com.sistema.urcipy.entidades.custom.Corredormen;
import com.sistema.urcipy.servicios.CorredorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/correpub")
@CrossOrigin("*")
public class CorrePubController {
    @Autowired
    private CorredorService corredorService;



    @GetMapping("/{ci}/{idregional}")
    public Corredormen obtenerCorredorPorId(@PathVariable("ci") String ci,@PathVariable("idregional") Integer idregional){
        return corredorService.obtenerCorredormenCi(ci,idregional);
    }

}
