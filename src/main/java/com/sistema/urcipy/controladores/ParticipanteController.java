package com.sistema.urcipy.controladores;

import com.sistema.urcipy.entidades.Corredor;
import com.sistema.urcipy.entidades.Dorsal;
import com.sistema.urcipy.entidades.Participante;
import com.sistema.urcipy.entidades.Resultimio;
import com.sistema.urcipy.entidades.custom.Inscriptos;
import com.sistema.urcipy.servicios.DorsalService;
import com.sistema.urcipy.servicios.EventoService;
import com.sistema.urcipy.servicios.ParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/participante")
@CrossOrigin("*")
public class ParticipanteController {
    @Autowired
    private ParticipanteService participanteService;
    @Autowired
    private EventoService eventoService;
    @Autowired
    private DorsalService dorsalService;

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
    @GetMapping("/activo/{activo}/{idregional}")
    public ResponseEntity<?> listarParticipantesEvento(@PathVariable("activo") Integer activo,@PathVariable("idregional") Integer idregional){
        return ResponseEntity.ok(participanteService.obtenerLisParticipantesByEventoActivoReg(activo,idregional));
    }
    @GetMapping("/pago/{activo}")
    public ResponseEntity<?> listarPagParticipantesEvento(@PathVariable("activo") Integer activo){
        Integer idevento;
        idevento=eventoService.obtenerEventoActivo(activo).getIdevento();
        return ResponseEntity.ok(participanteService.obtenerLisPagParticipantesByEvento(idevento));
    }
    @PutMapping("/dorsal")
    public void actuaParticiDorsal(@RequestBody Resultimio resultimio){
        participanteService.actuaPartiDorsal(resultimio.getId(),resultimio.getDorsal());
    }
    @PutMapping("/pagos")
    public void actuaParticiPagos(@RequestBody Resultimio resultimio){
        participanteService.actuaPartiPagos(resultimio.getId(),resultimio.getNrogiro(),resultimio.getPagado(),resultimio.getAcobrar(),resultimio.getKit(),resultimio.getTamano());
    }
    @GetMapping("/asigdorsal/{activo}/{idregional}")
    public ResponseEntity<?> asignarTodosParticipantesEvento(@PathVariable("activo") Integer activo,@PathVariable("idregional") Integer idregional){
        Integer idevento;
        idevento=eventoService.obtenerEventoActivoRegional(activo,idregional).getIdevento();
        String palabra = "Naranjado";

        List<Dorsal> dorsalesNaranja=dorsalService.obtenerDorsalesActivosColor(palabra);
        System.out.println("Cantidad Naranja: "+dorsalesNaranja.size());
        palabra = "Amarillo";
        List<Dorsal> dorsalesAmarillo=dorsalService.obtenerDorsalesActivosColor(palabra);
        System.out.println("Cantidad Amarillo: "+dorsalesAmarillo.size());
        List<Participante> participantes=participanteService.obtenerLisParticipantesByEvento(idevento);
        Integer i=0, j=0,iddorsal;
        for (Participante participante : participantes){
            if(participante.getCategoria().getTrayecto().getIdtrayecto()==1 ){
                iddorsal=dorsalesNaranja.get(i).getIddorsal();
                i=i+1;
            }else{
                iddorsal=dorsalesAmarillo.get(j).getIddorsal();
                j=j+1;
            }
            participante.setDorsal(iddorsal);
            participanteService.guardarParticipante(participante);

        }
        return ResponseEntity.ok(participanteService.obtenerLisParticipantesByEventoActivoReg(activo,idregional));
    }
}
