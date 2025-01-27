package com.sistema.urcipy.controladores;

import com.sistema.urcipy.entidades.Region;
import com.sistema.urcipy.servicios.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/region")
@CrossOrigin("*")
public class RegionController {
    @Autowired
    private RegionService regionService;


    @PostMapping("/")
    public ResponseEntity<Region> guardarRegion(@RequestBody Region region){
        Region regionGuardada = regionService.guardarRegion(region);
        return ResponseEntity.ok(regionGuardada);
    }
    @GetMapping("/{idregion}")
    public Region obtenerRegionPorId(@PathVariable("idregion") Integer idregion){
        return regionService.obtenerRegion(idregion);
    }

    @GetMapping("/")
    public ResponseEntity<?> listarRegiones(){
        return ResponseEntity.ok(regionService.obtenerRegiones());
    }
    @PutMapping("/")
    public Region actualizarRegion(@RequestBody Region region){
        return regionService.guardarRegion(region);
    }
    @DeleteMapping("/{idregion}")
    public void eliminarRegion(@PathVariable("idregion") Integer idregion){
        regionService.eliminarRegion(idregion);
    }
}