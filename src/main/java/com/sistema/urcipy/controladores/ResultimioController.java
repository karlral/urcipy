package com.sistema.urcipy.controladores;

import com.sistema.urcipy.entidades.*;
import com.sistema.urcipy.entidades.custom.Corregroup;
import com.sistema.urcipy.entidades.custom.Sendtimio;
import com.sistema.urcipy.servicios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
    @Autowired
    private PersonaService personaService;
    @Autowired
    private RegionalService regionalService;
    @Autowired
    private CategoriaService categoriaService;

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
        String resultado;
        Integer idevento = resultimios.get(0).getIdevento();

        resultado=this.inscribirtodos(resultimios,idevento);
        if (resultado.equals("ok")){

        }else{
            return ResponseEntity.badRequest().body(resultado);
        }

        Set<Sendtimio> sendtimios=participanteService.busParticipantesByEvento(idevento);
        //corredorespuntos
        return ResponseEntity.ok(sendtimios);
    }
    @PostMapping("/inscripcorregroup")
    public ResponseEntity<?> inscripListaCorregroup(@RequestBody List<Corregroup> corregroups){
        String resultado;
        Integer idevento = corregroups.get(0).getIdevento();

        resultado=this.inscribirTodosCorre(corregroups,idevento);
        if (resultado.equals("ok")){

        }else{
            return ResponseEntity.badRequest().body(resultado);
        }

        Set<Sendtimio> sendtimios=participanteService.busParticipantesByEvento(idevento);
        //corredorespuntos
        return ResponseEntity.ok(sendtimios);
    }
    @PostMapping("/activotwo")
    public ResponseEntity<?> guardarListaResulado(@RequestBody List<Resultimio> resultimios){
        String resultado;
        Integer idevento = resultimios.get(0).getIdevento();

        resultado=this.inscribirtodos(resultimios,idevento);
        if (resultado.equals("ok")){

        }else{
            return ResponseEntity.badRequest().body(resultado);
        }

        resultado=this.cargarpuntaje(resultimios,idevento);
        if (resultado.equals("ok")){

        }else{
            return ResponseEntity.badRequest().body(resultado);
        }

        Set<Sendtimio> sendtimios=participanteService.busParticipantesByEvento(idevento);
        //corredorespuntos
        return ResponseEntity.ok(sendtimios);
    }


        @PostMapping("/activarpuntos")
    public ResponseEntity<?> activarListaResultimio(@RequestBody List<Resultimio> resultimios){
            Integer idevento = resultimios.get(0).getIdevento();
            Evento evento;
            evento = eventoService.obtenerEvento(idevento);

            Regional regional = evento.getRegional();
            Integer idregional = regional.getIdregional();
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

    private String inscribirtodos(List<Resultimio> resultimios,Integer idevento){
        Evento evento;
        evento = eventoService.obtenerEvento(idevento);


        Participante participante;
        Corredor corredor;
        Regional regional = evento.getRegional();
        Integer idregional = regional.getIdregional();
        Date fecha = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);

        resultimioService.eliminarSendtimioEvento(idevento);

        for (Resultimio resultimio:resultimios) {

            participante = participanteService.obtenerParticipantesByEventoCi(idevento, resultimio.getCi());
            if (participante == null) {
                participante = new Participante();
            }
            corredor = corredorService.obtenerCorredorCi(resultimio.getCi(), idregional);
            if (corredor == null) {
                return "Falta: " + resultimio.getCi();
            }

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
            participante.setCompleto(0);

            participanteService.guardarParticipante(participante);
        }
        return "ok";
    }


    private String cargarpuntaje(List<Resultimio> resultimios,Integer idevento){

        Evento evento=eventoService.obtenerEvento(idevento);
        Integer idregional=evento.getRegional().getIdregional();

        resultimioService.eliminarSendtimioEvento(idevento);
        Corredor corredor;
        int hora, min, seg, puntaje;
        for (Resultimio resultimio:resultimios) {

            resultimio.setEvento(evento);

            corredor= corredorService.obtenerCorredorCi(resultimio.getCi(),idregional);
            if (corredor == null) {
                return "Corredor no existe CI: "+resultimio.getCi()
                        +" Corredor: "+resultimio.getNomparticipante();
            }


            System.out.println("Encontro: "+resultimio.getNomparticipante()+resultimio.getPoscategoria()+resultimio.getTiempos()+resultimio.getClub());
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
        participanteService.eliminarParticipantesEventoNotCompleto(idevento);
        participanteService.actualizarPromedio(idevento);

        return "ok";
    }

    private String inscribirTodosCorre(List<Corregroup> corregroups,Integer idevento){
        Evento evento;
        evento = eventoService.obtenerEvento(idevento);


        Participante participante;
        Corredor corredor;
        Regional regional = evento.getRegional();
        Integer idregional = regional.getIdregional();
        Date fecha = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);

        resultimioService.eliminarSendtimioEvento(idevento);

        for (Corregroup corregroup:corregroups) {

            participante = participanteService.obtenerParticipantesByEventoCi(idevento, corregroup.getCi());
            if (participante == null) {
                participante = new Participante();
            }
            corredor = corredorService.obtenerCorredorCi(corregroup.getCi(), idregional);
            if (corredor == null) {
                Persona persona = new Persona();
                persona.setCi(corregroup.getCi());
                persona.setNombre(corregroup.getNombre());
                persona.setApellido(corregroup.getApellido());
                persona.setEmail(corregroup.getEmail());
                persona.setTelefono(corregroup.getTelefono());
                Byte sexo =1;
                if (corregroup.getSexo().equals("F")){
                    sexo=0;
                }
                persona.setSexo(sexo);
                persona.setFecnac(corregroup.getFecnac());

                Ciudad ciudad= new Ciudad();
                ciudad.setIdciudad(1);
                persona.setCiudad(ciudad);

                corredor = new Corredor();

                corredor.setPersona(persona);

                corredor.setRegional(regional);

                Club club = new Club();
                club.setIdclub(1);
                corredor.setClub(club);

                Byte tipo = 0;
                if(corregroup.getCategoria().contains("OPEN") || corregroup.getCategoria().contains("PROMOCIONAL")){
                    tipo=3;
                    if(corregroup.getCategoria().contains("OPEN PRO")){
                        tipo=1;
                    }
                }else if(corregroup.getCategoria().contains("100k")){
                    tipo=4;
                }else if(corregroup.getCategoria().contains("ELITE")){
                    tipo=2;
                }else {
                    tipo=1;
                }
                Integer ano = Calendar.getInstance().get(Calendar.YEAR);
                calendar.setTime(corredor.getPersona().getFecnac());
                Integer anonac = calendar.get(Calendar.YEAR);
                Byte edad = (byte) (ano -anonac);
                System.out.println(persona.toString()+" Edad:"+edad+" Tipo:"+tipo);

                Categoria categoria=categoriaService.buscarCategoria(sexo, edad, tipo,1);
                corredor.setCategoria(categoria);
                corredor.setPuntua(0);

                Usuario usuario = new Usuario();
                usuario.setIdusuario(1);
                corredor.setUsuario(usuario);

                corredor = this.guardarCorredor(corredor);

               // return "Falta: " + corregroup.getCi();
            }

            participante.setCorredor(corredor);

            participante.setClub(corredor.getClub());

            Region region = new Region();
            region.setIdregion(1);
            participante.setRegion(region);

            participante.setCategoria(corredor.getCategoria());
            participante.setFecha(fecha);
            participante.setEvento(evento);
            participante.setRegional(regional);
            participante.setCosto(evento.getMontopric());
            participante.setPuntua(corredor.getPuntua());

            participante.setKm(corregroup.getDistancia());
            participante.setPuntua(corredor.getPuntua());
            participante.setCompleto(0);

            participanteService.guardarParticipante(participante);
        }
        return "ok";
    }


    private Corredor guardarCorredor(Corredor corredor) {
        Corredor corredorGuardada;

        List<Corredor> corredores = new ArrayList<>();

        Regional regionalco=corredor.getRegional();
        System.out.println("guardar dos veces y quedarse con esta regional");
        System.out.println(regionalco.getIdregional());
        corredorGuardada=corredorService.obtenerCorredorCi(corredor.getPersona().getCi(),regionalco.getIdregional());
        if(corredorGuardada==null) { // vamos a crear el corredor con la regional
            Persona personaGuardada, personaAux;
            personaAux = personaService.obtenerPersonaCi(corredor.getPersona().getCi());
            if (personaAux == null) { //no hay persona en la regional y se crean
                personaAux = corredor.getPersona();
            }
            personaAux.setNombre(corredor.getPersona().getNombre().toUpperCase());
            personaAux.setApellido(corredor.getPersona().getApellido().toUpperCase());
            personaGuardada = personaService.guardarPersonaFlush(personaAux);

            Set<Regional> regionalss=regionalService.obtenerRegionales();
            List<Regional> regionales = new ArrayList<Regional>(regionalss);
            Corredor corredorVar=corredor;
            for (Regional regional : regionales) {
                if(regional.getIdregional()==4){//runnig- guardamos de otra forma
                    break;
                }
                corredorVar=new Corredor();
                corredorVar.setPersona(personaGuardada);
                corredorVar.setRegional(regional);

                corredorVar.setPuntua(corredor.getPuntua());
                corredorVar.setCarnet(corredor.getCarnet());
                corredorVar.setCategoria(corredor.getCategoria());
                corredorVar.setClub(corredor.getClub());
                corredorVar.setCarnetatras(corredor.getCarnetatras());
                corredorVar.setCatalianza(corredor.getCatalianza());
                corredorVar.setFecmodi(corredor.getFecmodi());
                corredorVar.setLicencia(corredor.getLicencia());
                corredorVar.setModificar(corredor.getModificar());
                corredorVar.setMontopuntua(corredor.getMontopuntua());
                corredorVar.setTipocat(corredor.getTipocat());
                corredorVar.setUsuario(corredor.getUsuario());
                corredorVar.setVerificar(corredor.getVerificar());
                corredores.add(corredorVar);

                System.out.println("->"+corredorVar.getRegional().getIdregional() + " " + corredorVar.getRegional().getNomregional());
            }
            corredores.forEach(corredor1 -> {
                System.out.println(corredor1.getRegional().getIdregional()+" "+corredor1.getRegional().getNomregional());
            });

            this.corredorService.guardarCorredores(corredores);

            corredorGuardada=corredorService.obtenerCorredorCi(corredor.getPersona().getCi(),regionalco.getIdregional());
        }
        return corredorGuardada;
    }

}
