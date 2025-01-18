package com.sistema.urcipy.controladores;

import com.sistema.urcipy.entidades.Campeones;
import com.sistema.urcipy.servicios.CampeonesService;
import com.sistema.urcipy.servicios.EntidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/campeones")
@CrossOrigin("*")
public class CampeonesController {
    @Autowired
    private CampeonesService campeonesService;
    @Autowired
    private EntidadService entidadService;

    @PostMapping("/")
    public ResponseEntity<Campeones> guardarCampeones(@RequestBody Campeones campeones){
        Campeones campeonesGuardada = campeonesService.guardarCampeones(campeones);
        return ResponseEntity.ok(campeonesGuardada);
    }
    @GetMapping("/{idcampeones}")
    public Campeones obtenerCampeonesPorId(@PathVariable("idcampeones") Integer idcampeones){
        return campeonesService.obtenerCampeones(idcampeones);
    }

    @GetMapping("/")
    public ResponseEntity<?> listarCampeoneses(){
        return ResponseEntity.ok(campeonesService.obtenerCampeoneses());
    }
    @PutMapping("/")
    public Campeones actualizarCampeones(@RequestBody Campeones campeones){
        return campeonesService.guardarCampeones(campeones);
    }
    @DeleteMapping("/{idcampeones}")
    public void eliminarCampeones(@PathVariable("idcampeones") Integer idcampeones){
        campeonesService.eliminarCampeones(idcampeones);
    }
    @PostMapping("/procesar/") /*@Transactional*/
    public void procesarCampeones(){
        campeonesService.procesarCampeones();

    }
    @GetMapping("/anho")
    public ResponseEntity<?>  listarCampeonesAnho(){
        Integer anho;
        anho = entidadService.obtenerEntidad(1).getAno();
        return  ResponseEntity.ok(campeonesService.obtenerCampeonesByAnho(anho));
    }
}
