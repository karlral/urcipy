package com.sistema.urcipy.controladores;

import com.sistema.urcipy.entidades.Campeonato;
import com.sistema.urcipy.servicios.CampeonatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/campeonato")
@CrossOrigin("*")
public class CampeonatoController {

    @Autowired
    private CampeonatoService campeonatoService;


    @PostMapping("/")
    public ResponseEntity<Campeonato> guardarCampeonato(@RequestBody Campeonato campeonato){
        Campeonato campeonatoGuardada = campeonatoService.guardarCampeonato(campeonato);
        return ResponseEntity.ok(campeonatoGuardada);
    }
    @GetMapping("/{idcampeonato}")
    public Campeonato obtenerCampeonatoPorId(@PathVariable("idcampeonato") Integer idcampeonato){
        return campeonatoService.obtenerCampeonato(idcampeonato);
    }

    @GetMapping("/system/{idregional}")
    public ResponseEntity<?> listarCampeonatoes(@PathVariable("idregional") Integer idregional){
        return ResponseEntity.ok(campeonatoService.obtenerCampeonatoes(idregional));
    }
    @PutMapping("/")
    public Campeonato actualizarCampeonato(@RequestBody Campeonato campeonato){
        return campeonatoService.guardarCampeonato(campeonato);
    }
    @DeleteMapping("/{idcampeonato}")
    public void eliminarCampeonato(@PathVariable("idcampeonato") Integer idcampeonato){
        campeonatoService.eliminarCampeonato(idcampeonato);
    }
}