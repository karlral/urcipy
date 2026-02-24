package com.sistema.urcipy.controladores;

import com.sistema.urcipy.entidades.Movimiento;
import com.sistema.urcipy.servicios.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movimiento")
@CrossOrigin("*")
public class MovimientoController {
    @Autowired
    private MovimientoService movimientoService;


    @PostMapping("/")
    public ResponseEntity<Movimiento> guardarMovimiento(@RequestBody Movimiento movimiento){

        Movimiento movimientoGuardada;
        movimientoGuardada = movimientoService.guardarMovimiento(movimiento);

        return ResponseEntity.ok(movimientoGuardada);
    }
    @GetMapping("/{idmovimiento}")
    public Movimiento obtenerMovimientoPorId(@PathVariable("idmovimiento") Integer idmovimiento){
        return movimientoService.obtenerMovimiento(idmovimiento);
    }

    @GetMapping("/system/{idregional}")
    public ResponseEntity<?> listarMovimientoes(@PathVariable("idregional") Integer idregional){
        return ResponseEntity.ok(movimientoService.obtenerMovimientoes(idregional));
    }
    @GetMapping("/ranking/{idregional}")
    public ResponseEntity<?> listarMovimientoesrank(@PathVariable("idregional") Integer idregional){

        return ResponseEntity.ok(movimientoService.obtenerMovimientosRanking(idregional));
    }
    @PutMapping("/")
    public Movimiento actualizarMovimiento(@RequestBody Movimiento movimiento){
        return movimientoService.guardarMovimiento(movimiento);
    }
    @DeleteMapping("/{idmovimiento}")
    public void eliminarMovimiento(@PathVariable("idmovimiento") Integer idmovimiento){
        movimientoService.eliminarMovimiento(idmovimiento);
    }
    @DeleteMapping("/eli/{ci}/{idregional}")
    public void eliminarMovimiento(@PathVariable("ci") String ci,@PathVariable("idregional") Integer idregional){
        movimientoService.eliminarMoviRankin(ci,idregional);
    }
}
