package com.sistema.urcipy.controladores;

import com.sistema.urcipy.entidades.*;
import com.sistema.urcipy.entidades.custom.Inscripto;
import com.sistema.urcipy.entidades.custom.Partici;
import com.sistema.urcipy.entidades.custom.Punclub;
import com.sistema.urcipy.entidades.custom.Punclubpartici;
import com.sistema.urcipy.servicios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
    @Autowired
    private RegionalService regionalService;


    @GetMapping("/inscrip/{idevento}/{ci}")
    public ResponseEntity<?> inscribirPartiCi(@PathVariable("idevento") Integer idevento,@PathVariable("ci") String ci){

        Participante participanteaux=participanteService.obtenerParticipantesByEventoCi(idevento,ci);
        if(participanteaux==null) {
            //System.out.println(idevento);
            Evento eventoold = eventoService.obtenerEvento(idevento);
            //System.out.println(idevento);
            Integer alianza=eventoold.getAlianza();
            //System.out.println(alianza);
            if(alianza==1){
                // guardamos las inscripciones de cada Regional con su club y con su categoria
                List<Evento> eventos=eventoService.obtenerEventoActivosAlianza(1,alianza);
                for(Evento evento:eventos){
              //      System.out.println(evento);
                    Corredor corredor = corredorService.obtenerCorredorCi(ci,evento.getRegional().getIdregional());
                    if (corredor == null) {
                        return ResponseEntity.badRequest().body("Corredor no existe");
                    }else{
                        guardarparticipante(corredor,evento,evento.getRegional());
                    }
                }
                participanteaux=participanteService.obtenerParticipantesByEventoCi(idevento,ci);
            }else {
                Corredor corredor;
                if(eventoold.getModalidad().getIdmodalidad()==2){ //Running
                    corredor = corredorService.obtenerCorredorCi(ci,4); // Running
                    corredor.setClub(eventoold.getClub());

                }else{
                    corredor = corredorService.obtenerCorredorCi(ci,eventoold.getRegional().getIdregional());
                }

                if (corredor == null) {
                    return ResponseEntity.badRequest().body("Corredor no existe");
                }else{
                    participanteaux =guardarparticipante(corredor,eventoold,eventoold.getRegional());
                }
            }
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

    @GetMapping("/activo/{activo}/{idregional}")
    @ResponseBody
    public ResponseEntity<?>  listarParticipantesActivos(@PathVariable("activo") Integer activo,@PathVariable("idregional") Integer idregional){
        return ResponseEntity.ok(participanteService
                .obtenerParticipantesActivo(activo,idregional));
    }
    @GetMapping("/activopagos/{activo}/{idregional}")
    @ResponseBody
    public ResponseEntity<?>  listarParticipantesActivosPagos(@PathVariable("activo") Integer activo,@PathVariable("idregional") Integer idregional){
        return ResponseEntity.ok(participanteService
                .obtenerParticipantesActivoPagos(activo,idregional));
    }

    @GetMapping("/activonino/{activo}/{idregional}")
    @ResponseBody
    public ResponseEntity<?>  listarParticipantesActivosNino(@PathVariable("activo") Integer activo,@PathVariable("idregional") Integer idregional){
        return ResponseEntity.ok(participanteService
                .obtenerParticipantesActivoNino(activo,idregional));
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

    @GetMapping("/puntajes/{idregional}")
    @ResponseBody
    public ResponseEntity<?>  listarCorredorPuntaje(@PathVariable("idregional") Integer idregional){
        Integer anho;
        Regional regional = regionalService.obtenerRegional(idregional);
        anho=regional.getAno();
        return ResponseEntity.ok(participanteService.obtenerParticiPuntaje(anho,idregional));
    }
    @GetMapping("/puntaje/{idcorredor}/{idregional}")
    @ResponseBody
    public ResponseEntity<?>  listarPuntajesByCorredor(@PathVariable("idcorredor") Integer idcorredor,@PathVariable("idregional") Integer idregional){
        Integer anho;
        Regional regional = regionalService.obtenerRegional(idregional);
        anho=regional.getAno();
        return ResponseEntity.ok(participanteService.obtenerParticiByIdPuntajes(anho,idcorredor,idregional));
    }
    @GetMapping("/punclub/{tipo}/{idregional}")
    @ResponseBody
    public ResponseEntity<?>  listarPuntajesInClub(@PathVariable("tipo") String tipo,@PathVariable("idregional") Integer idregional){
        Integer anho,tipoone,tipotwo;
        Regional regional = regionalService.obtenerRegional(idregional);
        Set<Punclub> punclubs=new LinkedHashSet<>();
        anho=regional.getAno();

        if (tipo.equals("principal")){
            tipoone=1;
            tipotwo=2;
        }else { //promocional
            tipoone=3;
            tipotwo=4;
        }

        if (idregional==1){
           punclubs= participanteService.obtenerPuntajesInClub(anho,tipoone,tipotwo,idregional);
        }else{
            if (idregional==2) {
                punclubs = participanteService.obtenerPuntajesXClubAll(anho,idregional);
            }
        }
        return ResponseEntity.ok(punclubs);
    }

    @GetMapping("/punclubreg/{tipo}/{idclub}/{idregional}")
    @ResponseBody
    public ResponseEntity<?>  listarPuntajesByClubPartici(@PathVariable("tipo") String tipo,@PathVariable("idclub") Integer idclub,@PathVariable("idregional") Integer idregional){
        Integer anho,tipoone,tipotwo;
        Regional regional = regionalService.obtenerRegional(idregional);
        anho=regional.getAno();
        Set<Punclubpartici> punclubparticis=new LinkedHashSet<>();

        if (tipo.equals("principal")){
            tipoone=1;
            tipotwo=2;
        }else { //promocional
            tipoone=3;
            tipotwo=4;
        }

        if (idregional==1){
            punclubparticis= participanteService.obtenerPuntajesByClubPartici(anho,tipoone,tipotwo,idclub,idregional);
        }else{
            if (idregional==2) {
                punclubparticis = participanteService.obtenerPuntajesByClubAllPartici(anho,idregional,idclub);
            }
        }

        return ResponseEntity.ok(punclubparticis);
    }

    private Participante guardarparticipante(Corredor corredor,Evento evento,Regional regional){
        Participante participante,participanteauxiliar;

        participante= new Participante();
        participante.setCorredor(corredor);
        participante.setTamano(corredor.getPersona().getTamano());

        participante.setClub(corredor.getClub());
        participante.setCategoria(corredor.getCategoria());

        Region region;
        region = corredor.getClub().getRegion();
        participante.setRegion(region);

        Date fecha = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        participante.setFecha(fecha);

        participante.setEvento(evento);

        participante.setRegional(regional);

        participante.setCosto(evento.getMontopric());


        participanteauxiliar = participanteService.guardarParticipante(participante);
        return  participanteauxiliar;
    }

    @PutMapping("/catclub")
    public void actuaParticiCatClub(@RequestBody Partici partici){
        participanteService.actualizarClubCatTamElige(partici);

    }

    @PostMapping("/inscrip")
    public ResponseEntity<?> inscriPartici(@RequestBody Partici partici){

        Inscripto inscriptoparticipante=participanteService.inscribirPartici(partici);

        return ResponseEntity.ok(inscriptoparticipante);
    }

}
