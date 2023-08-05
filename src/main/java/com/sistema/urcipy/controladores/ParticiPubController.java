package com.sistema.urcipy.controladores;

import com.sistema.urcipy.entidades.Corredor;
import com.sistema.urcipy.entidades.Evento;
import com.sistema.urcipy.entidades.Participante;
import com.sistema.urcipy.entidades.Regional;
import com.sistema.urcipy.servicios.CorredorService;
import com.sistema.urcipy.servicios.EntidadService;
import com.sistema.urcipy.servicios.EventoService;
import com.sistema.urcipy.servicios.ParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@RestController
@RequestMapping("/participub")
@CrossOrigin("*")
public class ParticiPubController {
    @Autowired
    private ParticipanteService participanteService;
    @Autowired
    private CorredorService corredorService;
    @Autowired
    private EventoService eventoService;

    @Autowired
    private EntidadService entidadService;

    @GetMapping("/inscrip/{idevento}/{ci}")
    public ResponseEntity<?> inscribirPartiCi(@PathVariable("idevento") Integer idevento,@PathVariable("ci") String ci){

        Participante participanteaux=participanteService.obtenerParticipantesByEventoCi(idevento,ci);
        if(participanteaux==null) {


            Corredor corredor = corredorService.obtenerCorredorCi(ci);
            if (corredor == null) {
                return ResponseEntity.badRequest().body("Corredor no existe");
            }

            Participante participante = new Participante();
            participante.setCorredor(corredor);
            participante.setClub(corredor.getClub());
            participante.setCategoria(corredor.getCategoria());

            Date fecha = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fecha);
            participante.setFecha(fecha);

            Evento evento = eventoService.obtenerEvento(idevento);
            participante.setEvento(evento);

            Regional regional = new Regional();
            regional.setIdregional(1);
            participante.setRegional(regional);

            participante.setCosto(evento.getMontopric());


            participanteaux = participanteService.guardarParticipante(participante);
        }

        return ResponseEntity.ok(participanteaux);
    }

    @GetMapping("/proceso")
    @ResponseBody
    public ResponseEntity<?>  listarParticipantesProceso(){
        Integer anho;
        anho=entidadService.obtenerEntidad(1).getAno();
        return ResponseEntity.ok(participanteService.obtenerParticipantesProceso(anho));
    }

    @GetMapping("/activo/{activo}")
    @ResponseBody
    public ResponseEntity<?>  listarParticipantesActivos(@PathVariable("activo") Integer activo){
        return ResponseEntity.ok(participanteService.obtenerParticipantesActivo(activo));
    }
    @GetMapping("/evento/{idevento}")
    @ResponseBody
    public ResponseEntity<?>  listarParticipantesByEvento(@PathVariable("idevento") Integer idevento){
        return ResponseEntity.ok(participanteService.obtenerParticipantesByEvento(idevento));
    }


    @GetMapping("/id/{idparticipante}")
    public Participante obtenerParticipantePorId(@PathVariable("idparticipante") Integer idparticipante){
        return participanteService.obtenerParticipante(idparticipante);
    }

    @GetMapping("/puntaje")
    @ResponseBody
    public ResponseEntity<?>  listarCorredorPuntaje(){
        Integer anho;
        anho=entidadService.obtenerEntidad(1).getAno();
        return ResponseEntity.ok(participanteService.obtenerParticiPuntaje(anho));
    }
    @GetMapping("/puntaje/{idcorredor}")
    @ResponseBody
    public ResponseEntity<?>  listarPuntajesByCorredor(@PathVariable("idcorredor") Integer idcorredor){
        Integer anho;
        anho=entidadService.obtenerEntidad(1).getAno();
        return ResponseEntity.ok(participanteService.obtenerParticiByIdPuntajes(anho,idcorredor));
    }
    @GetMapping("/punclub/{tipo}")
    @ResponseBody
    public ResponseEntity<?>  listarPuntajesInClub(@PathVariable("tipo") String tipo){
        Integer anho,tipoone,tipotwo;
        anho=entidadService.obtenerEntidad(1).getAno();

        if (tipo.equals("principal")){
            tipoone=1;
            tipotwo=2;
        }else { //promocional
            tipoone=3;
            tipotwo=4;
        }

        return ResponseEntity.ok(participanteService.obtenerPuntajesInClub(anho,tipoone,tipotwo));
    }
    @GetMapping("/punclub/{tipo}/{idclub}")
    @ResponseBody
    public ResponseEntity<?>  listarPuntajesByClubPartici(@PathVariable("tipo") String tipo,@PathVariable("idclub") Integer idclub){
        Integer anho,tipoone,tipotwo;
        anho=entidadService.obtenerEntidad(1).getAno();

        if (tipo.equals("principal")){
            tipoone=1;
            tipotwo=2;
        }else { //promocional
            tipoone=3;
            tipotwo=4;
        }
        return ResponseEntity.ok(participanteService.obtenerPuntajesByClubPartici(anho,tipoone,tipotwo,idclub));
    }
}
