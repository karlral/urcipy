package com.sistema.urcipy.controladores;

import com.sistema.urcipy.entidades.Participante;
import com.sistema.urcipy.servicios.ParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/participante")
@CrossOrigin("*")
public class ParticipanteController {
    @Autowired
    private ParticipanteService participanteService;


    @PostMapping("/")
    public ResponseEntity<Participante> guardarParticipante(@RequestBody Participante participante){
        Participante participanteGuardada = participanteService.guardarParticipante(participante);
        return ResponseEntity.ok(participanteGuardada);
    }
    @GetMapping("/{idparticipante}")
    public Participante obtenerParticipantePorId(@PathVariable("idparticipante") Integer idparticipante){
        return participanteService.obtenerParticipante(idparticipante);
    }

    @GetMapping("/")
    public ResponseEntity<?> listarParticipantees(){
        return ResponseEntity.ok(participanteService.obtenerParticipantees());
    }
    @PutMapping("/")
    public Participante actualizarParticipante(@RequestBody Participante participante){
        return participanteService.guardarParticipante(participante);
    }
    @DeleteMapping("/{idparticipante}")
    public void eliminarParticipante(@PathVariable("idparticipante") Integer idparticipante){
        participanteService.eliminarParticipante(idparticipante);
    }
}
