package com.sistema.urcipy.controladores;

import com.sistema.urcipy.entidades.Historial;
import com.sistema.urcipy.servicios.HistorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/historial")
@CrossOrigin("*")
public class HistorialController {
    @Autowired
    private HistorialService historialService;


    @PostMapping("/")
    public ResponseEntity<Historial> guardarHistorial(@RequestBody Historial historial){
        Historial historialGuardada = historialService.guardarHistorial(historial);
        return ResponseEntity.ok(historialGuardada);
    }
    @GetMapping("/{idhistorial}")
    public Historial obtenerHistorialPorId(@PathVariable("idhistorial") Integer idhistorial){
        return historialService.obtenerHistorial(idhistorial);
    }

    @GetMapping("/")
    public ResponseEntity<?> listarHistoriales(){
        return ResponseEntity.ok(historialService.obtenerHistoriales());
    }
    @PutMapping("/")
    public Historial actualizarHistorial(@RequestBody Historial historial){
        return historialService.guardarHistorial(historial);
    }
    @DeleteMapping("/{idhistorial}")
    public void eliminarHistorial(@PathVariable("idhistorial") Integer idhistorial){
        historialService.eliminarHistorial(idhistorial);
    }
    @PostMapping("/send/{idevento}")
    public ResponseEntity<?> sendtoHistorial(@PathVariable("idevento") Integer idevento){
         historialService.cargarHistorial(idevento);
        return ResponseEntity.ok("ok");
    }
}
