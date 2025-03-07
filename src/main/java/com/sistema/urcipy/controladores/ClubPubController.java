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
    public ResponseEntity<?> listarClubes() {
        return ResponseEntity.ok(clubService.obtenerClubesRun());
    }
}
