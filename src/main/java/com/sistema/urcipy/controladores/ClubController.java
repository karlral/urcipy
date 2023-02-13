package com.sistema.urcipy.controladores;

import com.sistema.urcipy.entidades.Club;
import com.sistema.urcipy.servicios.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/club")
@CrossOrigin("*")
public class ClubController {
    @Autowired
    private ClubService clubService;


    @PostMapping("/")
    public ResponseEntity<Club> guardarClub(@RequestBody Club club){
        Club clubGuardada = clubService.guardarClub(club);
        return ResponseEntity.ok(clubGuardada);
    }
    @GetMapping("/{idclub}")
    public Club obtenerClubPorId(@PathVariable("idclub") Integer idclub){
        return clubService.obtenerClub(idclub);
    }

    @GetMapping("/")
    public ResponseEntity<?> listarClubes(){
        return ResponseEntity.ok(clubService.obtenerClubes());
    }
    @PutMapping("/")
    public Club actualizarClub(@RequestBody Club club){
        return clubService.guardarClub(club);
    }
    @DeleteMapping("/{idclub}")
    public void eliminarClub(@PathVariable("idclub") Integer idclub){
        clubService.eliminarClub(idclub);
    }
}
