package com.sistema.urcipy.controladores;

import com.sistema.urcipy.entidades.Club;
import com.sistema.urcipy.servicios.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clubpub")
@CrossOrigin("*")
public class ClubPubController {
    @Autowired
    private ClubService clubService;

    @GetMapping("/")
    public ResponseEntity<?> listarClubesRun() {
        final Integer idModalidad=2;
        return ResponseEntity.ok(clubService.obtenerClubes(idModalidad));
    }

    @GetMapping("/clubes/{idmodalidad}")
    public ResponseEntity<?> listarClubes(@PathVariable Integer idmodalidad) {
        return ResponseEntity.ok(clubService.obtenerClubes(idmodalidad));
    }
    @GetMapping("/clube/{idmodalidad}")
    public ResponseEntity<?> listarClube(@PathVariable Integer idmodalidad) {
        return ResponseEntity.ok(clubService.obtenerClube(idmodalidad));
    }
    @GetMapping("/{idclub}")
    public Club obtenerClubPorId(@PathVariable("idclub") Integer idclub){
        return clubService.obtenerClub(idclub);
    }

}
