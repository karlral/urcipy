package com.sistema.urcipy.controladores;

import com.sistema.urcipy.entidades.*;
import com.sistema.urcipy.entidades.custom.Sendtimio;
import com.sistema.urcipy.servicios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/resultimio")
@CrossOrigin("*")
public class ResultimioController {
    @Autowired
    private ResultimioService resultimioService;
    @Autowired
    private EventoService eventoService;
    @Autowired
    private ParticipanteService participanteService;
    @Autowired
    private CorredorService corredorService;
    @Autowired
    private PuntajeService puntajeService;

    @PostMapping("/")
    public ResponseEntity<Resultimio> guardarResultimio(@RequestBody Resultimio resultimio){
        Resultimio resultimioGuardada = resultimioService.guardarResultimio(resultimio);
        return ResponseEntity.ok(resultimioGuardada);
    }
    @PostMapping("/activoone")
    public ResponseEntity<?> guardarListaResultimio(@RequestBody List<Resultimio> resultimios){

        Integer idevento=eventoService.obtenerEventoActivo(1).getIdevento();
        Evento evento=eventoService.obtenerEvento(idevento);
        Integer idregional=evento.getRegional().getIdregional();

        resultimioService.eliminarSendtimioEvento(idevento);
        Corredor corredor;
        int hora, min, seg, puntaje;
        for (Resultimio resultimio:resultimios) {

            resultimio.setEvento(evento);

            corredor= corredorService.obtenerCorredorCi(resultimio.getCi(),idregional);
            if (corredor == null) {
                return ResponseEntity.badRequest().body("Corredor no existe CI: "+resultimio.getCi()
                        +" Corredor: "+resultimio.getNomparticipante());
            }


            System.out.println("Encontro: "+resultimio.getNomparticipante()+resultimio.getPoscategoria()+resultimio.getTiempos());
            resultimio.setPuntua(corredor.getPuntua());

            hora=Integer.parseInt(resultimio.getTiempos().substring(0, 2));
            min=Integer.parseInt(resultimio.getTiempos().substring(3, 5));
            seg=Integer.parseInt(resultimio.getTiempos().substring(6, 8));
            System.out.println("h:"+hora+"m:"+min+"s:"+seg);

            Calendar calendar= Calendar.getInstance();
            calendar.set(Calendar.YEAR,Calendar.MONTH,Calendar.DAY_OF_MONTH, hora, min, seg);
            System.out.println("Paso 2");

            resultimio.setTiempo(calendar.getTime());
            System.out.println("Paso 3");

            /**/
            if(resultimio.getPoscategoria()<=10){
                puntaje = puntajeService.obtenerPunto(resultimio.getPoscategoria(),idregional);
            }else{
                puntaje = 2;
            }

            /*switch (resultimio.getPoscategoria()){
                case 1:
                    puntaje=19;
                    break;
                case 2:
                    puntaje=16;
                    break;
                case 3:
                    puntaje=14;
                    break;
                case 4:
                    puntaje=12;
                    break;
                case 5:
                    puntaje=10;
                    break;
                case 6:
                    puntaje=8;
                    break;
                case 7:
                    puntaje=6;
                    break;
                case 8:
                    puntaje=4;
                    break;
                default:
                    puntaje=2;
            }*/


            /* FALTA LOS QUE PUNTUAN SI..*/
            resultimio.setPuntajeaux(puntaje);
            if(resultimio.getPuntua()==0){
                puntaje=0;
            }
            resultimio.setPuntaje(puntaje);

            Byte uno =1;
            resultimio.setProceso(uno);
            resultimio.setCompleto(1);
            resultimio.setPuntajeclub(2);

            Resultimio resultimioGuardada = resultimioService.guardarResultimio(resultimio);

           int rows= participanteService.actualizarPuntajes(resultimio);
            if (rows == 0){
                System.out.println(resultimio.getNomparticipante()+" NO ACTUALIZO EL PUNTAJE ");
            }
        }
        participanteService.actualizarPromedio(idevento);

        return ResponseEntity.ok(resultimios);
    }

    @PostMapping("/inscripgroup")
    public ResponseEntity<?> inscripListaResultimio(@RequestBody List<Resultimio> resultimios){
        Evento evento;
        evento = eventoService.obtenerEventoActivo(1);

        Integer idevento=evento.getIdevento();
        participanteService.eliminarParticipantesEvento(idevento);

        Participante participante;
        Corredor corredor;
        Regional regional = evento.getRegional();
        Integer idregional = regional.getIdregional();
        Date fecha = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);

        for (Resultimio resultimio:resultimios) {

             corredor= corredorService.obtenerCorredorCi(resultimio.getCi(),idregional);
            if (corredor == null) {
                return ResponseEntity.badRequest().body(resultimio);
            }
            participante = new Participante();
            participante.setCorredor(corredor);

            participante.setClub(corredor.getClub());

            participante.setRegion(corredor.getClub().getRegion());

            participante.setCategoria(corredor.getCategoria());
            participante.setFecha(fecha);
            participante.setEvento(evento);
            participante.setRegional(regional);
            participante.setCosto(evento.getMontopric());

            participante.setKm(resultimio.getDistancia());
            participante.setPuesto(resultimio.getPoscategoria());
            participante.setPuestocat(resultimio.getPoscategoria());
            participante.setTiempos(resultimio.getTiempos());
            participante.setDorsal(resultimio.getDorsal());
            participante.setPuntua(corredor.getPuntua());

            //participante.setRegional(corredor.getUsuario().getRegional());


            participanteService.guardarParticipante(participante);

        }

        return ResponseEntity.ok(participanteService.busParticipantesActivo(1));
    }

    @PostMapping("/activarpuntos")
    public ResponseEntity<?> activarListaResultimio(@RequestBody List<Resultimio> resultimios){
        Integer idregional =1;
        Corredor corredor;
        int cantidad=0;
        for (Resultimio resultimio:resultimios) {

            corredor= corredorService.obtenerCorredorCi(resultimio.getCi(),idregional);
            if (corredor == null) {

            }else{
                cantidad=cantidad+1;

                corredor.setPuntua(1);
                corredorService.guardarCorredor(corredor);
            }


        }

        return ResponseEntity.ok("ok-Cantidad procesado: "+cantidad);
    }

    @GetMapping("/{idresultimio}")
    public Resultimio obtenerResultimioPorId(@PathVariable("idresultimio") Integer idresultimio){
        return resultimioService.obtenerResultimio(idresultimio);
    }

    @GetMapping("/")
    public ResponseEntity<?> listarResultimioes(){
        return ResponseEntity.ok(resultimioService.obtenerResultimioes());
    }
    @PutMapping("/")
    public Resultimio actualizarResultimio(@RequestBody Resultimio resultimio){
        return resultimioService.guardarResultimio(resultimio);
    }
    @DeleteMapping("/{idresultimio}")
    public void eliminarResultimio(@PathVariable("idresultimio") Integer idresultimio){
        resultimioService.eliminarResultimio(idresultimio);
    }
}
