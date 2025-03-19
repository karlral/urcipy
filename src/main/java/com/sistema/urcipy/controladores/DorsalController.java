package com.sistema.urcipy.controladores;

import com.sistema.urcipy.entidades.Dorsal;
import com.sistema.urcipy.servicios.DorsalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dorsal")
@CrossOrigin("*")
public class DorsalController {
    @Autowired
    private DorsalService dorsalService;


    @PostMapping("/")
    public ResponseEntity<Dorsal> guardarDorsal(@RequestBody Dorsal dorsal){
        Dorsal dorsalGuardada = dorsalService.guardarDorsal(dorsal);
        return ResponseEntity.ok(dorsalGuardada);
    }
    @GetMapping("/{iddorsal}")
    public Dorsal obtenerDorsalPorId(@PathVariable("iddorsal") Integer iddorsal){
        return dorsalService.obtenerDorsal(iddorsal);
    }

    @GetMapping("/")
    public ResponseEntity<?> listarDorsales(){
        return ResponseEntity.ok(dorsalService.obtenerDorsales());
    }
    @GetMapping("/activos")
    public ResponseEntity<?> listarDorsalesActivos(){
        return ResponseEntity.ok(dorsalService.obtenerDorsales());
    }
    @PutMapping("/")
    public Dorsal actualizarDorsal(@RequestBody Dorsal dorsal){
        return dorsalService.guardarDorsal(dorsal);
    }
    @DeleteMapping("/{iddorsal}")
    public void eliminarDorsal(@PathVariable("iddorsal") Integer iddorsal){
        dorsalService.eliminarDorsal(iddorsal);
    }
}
