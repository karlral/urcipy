package com.sistema.urcipy.controladores;

import com.sistema.urcipy.entidades.Club;
import com.sistema.urcipy.entidades.CorredorClubRegional;
import com.sistema.urcipy.servicios.CorredorClubRegionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/corredorclubregional")
@CrossOrigin("*")
public class CorredorClubRegionalController {
    @Autowired
    private CorredorClubRegionalService corredorClubRegionalService;


    @PostMapping("/")
    public ResponseEntity<CorredorClubRegional> guardarCorredorClubRegional(@RequestBody CorredorClubRegional corredorClubRegional){
        CorredorClubRegional corredorClubRegionalGuardada = corredorClubRegionalService.guardarCorredorClubRegional(corredorClubRegional);
        return ResponseEntity.ok(corredorClubRegionalGuardada);
    }
    @GetMapping("/reg/{idcorredorClubRegional}")
    public CorredorClubRegional obtenerCorredorClubRegionalPorId(@PathVariable("idcorredorClubRegional") Integer idcorredorClubRegional){
        return corredorClubRegionalService.obtenerCorredorClubRegional(idcorredorClubRegional);
    }
    @GetMapping("/{idcorredor}/{idregional}")
    public CorredorClubRegional obtenerCorreClubReg(@PathVariable("idcorredor") Integer idcorredor,@PathVariable("idregional") Integer idregional){
        return corredorClubRegionalService.obtenerCorreClubReg(idcorredor,idregional);
    }

    @GetMapping("/")
    public ResponseEntity<?> listarCorredorClubRegionales(){
        return ResponseEntity.ok(corredorClubRegionalService.obtenerCorredorClubRegionales());
    }
    @PutMapping("/")
    public CorredorClubRegional actualizarCorredorClubRegional(@RequestBody CorredorClubRegional corredorClubRegional){
        return corredorClubRegionalService.guardarCorredorClubRegional(corredorClubRegional);
    }
    @DeleteMapping("/{idcorredorClubRegional}")
    public void eliminarCorredorClubRegional(@PathVariable("idcorredorClubRegional") Integer idcorredorClubRegional){
        corredorClubRegionalService.eliminarCorredorClubRegional(idcorredorClubRegional);
    }
    @GetMapping("/club/{idcorredor}/{idregional}")
    public Club obtenerClub(@PathVariable("idcorredor") Integer idcorredor,@PathVariable("idregional") Integer idregional){
        return corredorClubRegionalService.obtenerClub(idcorredor,idregional);
    }


}
