package com.sistema.urcipy.servicios;

import com.sistema.urcipy.entidades.*;
import com.sistema.urcipy.entidades.custom.*;
import com.sistema.urcipy.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class ParticipanteServiceImpl implements ParticipanteService{

    @Autowired
    private ParticipanteRepository participanteRepository;
    @Autowired
    private CorredorRepository corredorRepository;
    @Autowired
    private EventoRepository eventoRepository;
    @Autowired
    private CorredorService corredorService;
    @Autowired
    private ClubRepository clubRepository;
    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public Participante guardarParticipante(Participante participante){
        return participanteRepository.save(participante);
    }
    @Override
    @Transactional
    public int actualizarPuntajes(Resultimio resultimio){
        int rows=participanteRepository.setPuntajePosicion(resultimio.getTiempo(),resultimio.getPoscategoria(),
                resultimio.getPoscategoria(),resultimio.getDorsal(),resultimio.getPuntaje(),
                resultimio.getPuntajeaux(),resultimio.getCompleto(),resultimio.getEvento().getIdevento(),
                resultimio.getCi(),resultimio.getPuntajeclub(),resultimio.getPuntua());
        return rows;
    }
    @Override
    public Set<Participante> obtenerParticipantees() {
        return new LinkedHashSet<>(participanteRepository.findAll());
    }
    @Override
    public Set<Participante> obtenerParticipantesProceso(Integer anho)
    {
        return new LinkedHashSet<>(participanteRepository.findParticipantesporAnho(anho));
    }
    @Override
    public Set<Inscripcion> obtenerParticipantesActivo(Integer activo,Integer idregional) {
        return new LinkedHashSet<>(participanteRepository.buscarParticipantesByEventoActivo(activo,idregional));
    }
    @Override
    public Set<Inscripcion> obtenerParticipantesActivoPagos(Integer activo,Integer idregional) {
        return new LinkedHashSet<>(participanteRepository.buscarParticipantesByEventoActivoPagos(activo,idregional));
    }
    @Override
    public Set<Inscripcion> obtenerParticipantesActivoNino(Integer activo,Integer idregional) {
        return new LinkedHashSet<>(participanteRepository.buscarParticipantesByEventoActivoNino(activo,idregional));
    }
    @Override
    public Set<Sendtimio> busParticipantesActivo(Integer activo) {
        return new LinkedHashSet<>(participanteRepository.busTimioParticipantesByEventoActivo(activo));
    }
    @Override
    public Set<Sendtimio> busParticipantesByEvento(Integer idevento){
        return new LinkedHashSet<>(participanteRepository.busTimioParticipantesByEvento(idevento));
    }
    @Override
    @Transactional
    public void eliminarParticipantesEvento(Integer idevento) {
        participanteRepository.deletePartEvento(idevento);
    }
    @Override
    @Transactional
    public void eliminarParticipantesEventoNotCompleto(Integer idevento) {
        participanteRepository.deletePartEventoNotCompleto(idevento);
    }
    @Override
    public Set<Resultado> obtenerParticipantesByEvento(Integer idevento){
        return new LinkedHashSet<>(participanteRepository.buscarParticipantesByEventoIdeventoOrderByPuestocat(idevento));
    }
    @Override
    public Set<Inscripto> obtenerLisParticipantesByEventoActivoReg(Integer activo, Integer idregional){
        return new LinkedHashSet<>(participanteRepository.buscarParticipantesByEventoActivoReg(activo,idregional));
    }
    @Override
    public Set<Participuntaje> obtenerLisParticipantesByEventoActivoPuntaje(Integer activo, Integer idregional){
        return new LinkedHashSet<>(participanteRepository.buscarParticipantesByEventoActivoPuntaje(activo,idregional));
    }
    @Override
    public List<Participante> obtenerLisParticipantesByEvento(Integer idevento){
        return participanteRepository.findParticipantesByEventoIdeventoOrderByCategoria_Nomcorto(idevento);
    }
    @Override
    public Set<Inscripagos> obtenerLisPagParticipantesByEvento(Integer idevento){
        return new LinkedHashSet<>(participanteRepository.buscarpagParticipantesByEventoIdevento(idevento));
    }
    public Participante obtenerParticipantesByEventoCi(Integer idevento,String ci){
        return participanteRepository.findParticipanteByEventoIdeventoAndCorredorPersonaCi(idevento,ci);

    }
    @Override
    public Participante obtenerParticipante(Integer idparticipante) {
        return participanteRepository.findById(idparticipante).get();
    }
    @Override
    public void eliminarParticipante(Integer idparticipante) {
        Participante participante= new Participante();
        participante.setIdparticipante(idparticipante);
        participanteRepository.delete(participante);
    }

    @Override
    public Set<Puncorredor> obtenerParticiPuntaje(Integer anho,Integer idregional) {
        return new LinkedHashSet<>(participanteRepository.puntajeByParticiNative(anho,idregional));
    }
    @Override
    public Set<Puntoscorredor> obtenerParticiByIdPuntajes(Integer anho, Integer idcorredor,Integer idregional){
        return new LinkedHashSet<>(participanteRepository.listaPuntajesByParticiNative(anho,idcorredor,idregional));
    }
    @Override
    public Set<Punclub> obtenerPuntajesInClub(Integer anho, Integer tipoone, Integer tipotwo,Integer idregional){
        return new LinkedHashSet<>(participanteRepository.listaPuntajesInClubNative(anho,tipoone,tipotwo,idregional));
    }

    @Override
    public Set<Punclub> obtenerPuntajesXClubTwo(Integer anho, Integer tipoone, Integer tipotwo,Integer idregional){
        return new LinkedHashSet<>(participanteRepository.listaPuntajesXClubTwoNative(anho,tipoone,tipotwo,idregional));
    }

    @Override
    public Set<Punclub> obtenerPuntajesXClubAll(Integer anho, Integer idregional){
        return new LinkedHashSet<>(participanteRepository.listaPuntajesXClubAllNative(anho,idregional));

    }

    @Override
    public Set<Punclubpartici> obtenerPuntajesByClubAllPartici(Integer anho, Integer idregional,Integer idclub){
        return new LinkedHashSet<>(participanteRepository.listaPuntajesByClubAllParticiNative(anho,idregional,idclub));


    }

    @Override
    public Set<Punclubpartici> obtenerPuntajesByClubPartici(Integer anho, Integer tipoone, Integer tipotwo, Integer idclub,Integer idregional){
        return new LinkedHashSet<>(participanteRepository.listaPuntajesByClubParticiNative(anho,tipoone,tipotwo,idclub,idregional));
    }

    @Override
    public Set<Punclubpartici> obtenerPuntajesByClubTwoPartici(Integer anho, Integer tipoone, Integer tipotwo, Integer idclub,Integer idregional){
        return new LinkedHashSet<>(participanteRepository.listaPuntajesByClubTwoParticiNative(anho,tipoone,tipotwo,idclub,idregional));
    }

    @Override
    @Transactional
    public void activarPuntaje(Integer idcorredor) {
            participanteRepository.activarPuntajeId(idcorredor);
    }

    @Override
    @Transactional
    public void desactivarPuntaje(Integer idcorredor) {
        participanteRepository.desactivarPuntajeId(idcorredor);
    }

    @Override
    @Transactional
    public void actualizarPromedio(Integer idevento) {
        participanteRepository.updatePromedio(idevento);
    }
    @Override
    @Transactional
    public void actualizarClubCat(Integer idevento,Integer idcorredor){
        participanteRepository.updateParticipanteClubCat(idevento,idcorredor);
    }
    @Override
    @Transactional
    public void actualizarClubCatTamElige(Partici partici){
        participanteRepository.updateParticipanteClubCatTamElige(partici.getIdparticipante(),partici.getIdclub(),partici.getIdcategoria(),partici.getTamano());
    }
    @Override
    @Transactional
    public void actualizarPartiClubCatTam(Integer idcorredor,Integer idclub,Integer idcategoria,Integer tamano,Integer idevento){
        participanteRepository.updateParticipanteClubCatTam(idcorredor,idclub,idcategoria,tamano,idevento);
    }
    @Override
    @Transactional
    public void actuaPartiDorsal(Integer idparticipante,Integer iddorsal){
        participanteRepository.actuaDorsalId(idparticipante,iddorsal);
    }
    @Override
    @Transactional
    public void actuaPartiPagos(Integer idparticipante,String nrogiro, Integer pagado,Integer acobrar,Integer kit,Integer tamano){
        participanteRepository.actuaPagosId(idparticipante,nrogiro,pagado,acobrar,kit,tamano);
    }
    @Override
    @Transactional
    public void actualizarPuntaje(EventoAsignacion eventoAsignacion) {
        Integer puntaje=0,puntajeaux=0,puntajeclub=0;
        Participante participante= participanteRepository.getById(eventoAsignacion.getIdparticipante());
        if(eventoAsignacion.getAsignacion().getTipoAsignacion()==0){
            puntaje = participante.getPuntaje()-eventoAsignacion.getPuntaje();
            puntajeaux=participante.getPuntajeaux()-eventoAsignacion.getPuntaje();
            puntajeclub=participante.getPuntajeclub();
        } else if (eventoAsignacion.getAsignacion().getTipoAsignacion()==1){
            puntaje = participante.getPuntaje()+eventoAsignacion.getPuntaje();
            puntajeaux=participante.getPuntajeaux()+eventoAsignacion.getPuntaje();
            puntajeclub=participante.getPuntajeclub();
        }else if (eventoAsignacion.getAsignacion().getTipoAsignacion()==2){
            puntaje = participante.getPuntaje()*2;
            puntajeaux=participante.getPuntajeaux()*2;
            puntajeclub=participante.getPuntajeclub()*2;
        }
        if(participante.getPuntua()==1){
            puntaje = 0;
        }
        participanteRepository.updatePuntaje(eventoAsignacion.getIdparticipante(),puntaje,puntajeaux,puntajeclub);
    }

    @Override
    public Partici obtenerPartici(Integer idparticipante) {
        Participa participa= participanteRepository.buscarPartici(idparticipante);
        Partici partici= new Partici();
        partici.setIdparticipante(participa.getIdparticipante());
        partici.setIdevento(participa.getIdevento());
        partici.setIdcorredor(participa.getIdcorredor());
        partici.setIdcategoria(participa.getIdcategoria());
        partici.setIdclub(participa.getIdclub());
        partici.setCi(participa.getCi());
        partici.setTamano(participa.getTamano());
        partici.setTelefono(participa.getTelefono());
        partici.setIdregional(participa.getIdregional());
        if (participa.getModificar()==null){
            partici.setModificar(false);
        }else{ partici.setModificar(participa.getModificar()==1);}

        partici.setTipocat(participa.getTipocat());
        partici.setCorredor(participa.getCorredor());
        partici.setNombre(participa.getNombre());
        partici.setApellido(participa.getApellido());
        partici.setFecnac(participa.getFecnac());
        partici.setSexo(participa.getSexo());
        partici.setNacionalidad(participa.getNacionalidad());

        return partici;
    }

    @Override
    @Transactional
    public Inscripto inscribirPartici(Partici partici){

        if(partici.getIdregional()==3 && partici.getRegcorredor()){
           Corredor corredor = this.registrarcorredor(partici);

        }

        Participante participanteaux=participanteRepository.findParticipanteByEventoIdeventoAndCorredorPersonaCi(partici.getIdevento(),partici.getCi());
                //participanteService.obtenerParticipantesByEventoCi(partici.getIdevento(),partici.getCi());
        if(participanteaux==null) {
            //System.out.println(idevento);
            Evento eventoold = eventoRepository.findByIdevento(partici.getIdevento());
                  //  eventoService.obtenerEvento(partici.getIdevento());
            //System.out.println(idevento);
            Integer alianza=eventoold.getAlianza();
            //System.out.println(alianza);
            partici.setModificar(false);
            if(alianza==1){
                // guardamos las inscripciones de cada Regional con su club y con su categoria
                List<Evento> eventos=eventoRepository.findByActivoAndAlianzaOrderByFecha(1,alianza);
                      //  eventoService.obtenerEventoActivosAlianza(1,alianza);
                for(Evento evento:eventos){
                    //      System.out.println(evento);
                    Corredor corredor = corredorRepository.findByPersonaCiAndRegionalIdregional(partici.getCi(),evento.getRegional().getIdregional());
                            //corredorService.obtenerCorredorCi(partici.getCi(),evento.getRegional().getIdregional());
                    if (corredor == null) {
                        throw new ResponseStatusException(
                                HttpStatus.BAD_REQUEST,
                                "Corredor no encontrado"
                        );
                       // return ResponseEntity.badRequest().body("Corredor no existe");
                    }else{
                        if (corredor.getModificar() == null){
                            corredor.setModificar(false);
                        }

                        if ( corredor.getModificar()){
                            modificarcorredor(partici);
                            corredor = corredorRepository.findByPersonaCiAndRegionalIdregional(partici.getCi(),evento.getRegional().getIdregional());
                        }
                        guardarparticipante(corredor,evento,evento.getRegional(),partici.getTamano(),corredor.getClub().getIdclub());
                    }
                }
                participanteaux=participanteRepository.findParticipanteByEventoIdeventoAndCorredorPersonaCi(partici.getIdevento(),partici.getCi());
                        //participanteService.obtenerParticipantesByEventoCi(partici.getIdevento(),partici.getCi());
            }else {
                Corredor corredor;
                if(eventoold.getModalidad().getIdmodalidad()==2){ //Running
                    corredor =corredorRepository.findByPersonaCiAndRegionalIdregional(partici.getCi(),4); //Running
                            //corredorService.obtenerCorredorCi(partici.getCi(),4); // Running
                    corredor.setClub(eventoold.getClub());

                }else{
                    corredor = corredorRepository.findByPersonaCiAndRegionalIdregional(partici.getCi(),eventoold.getRegional().getIdregional());
                          //  corredorService.obtenerCorredorCi(partici.getCi(),eventoold.getRegional().getIdregional());
                }

                if (corredor == null) {
                    throw new ResponseStatusException(
                            HttpStatus.BAD_REQUEST,
                            "Corredor no encontrado"
                    );
                    //return ResponseEntity.badRequest().body("Corredor no existe");
                }else{
                    if (corredor.getModificar() == null){
                        corredor.setModificar(false);
                    }
                    if (corredor.getModificar()){
                        modificarcorredor(partici);
                        corredor = corredorRepository.findByPersonaCiAndRegionalIdregional(partici.getCi(),eventoold.getRegional().getIdregional());
                    }

                    participanteaux =guardarparticipante(corredor,eventoold,eventoold.getRegional(),partici.getTamano(),partici.getIdclub());
                }
            }
        }else{


            if (participanteaux.getEvento().getModalidad().getIdmodalidad()==1 && participanteaux.getCorredor().getModificar()){


                    modificarcorredor(partici);
                    participanteRepository.updateParticipanteClubCat(participanteaux.getEvento().getIdevento(),participanteaux.getCorredor().getIdcorredor());

            }



        }


        Inscripto inscripto = participanteRepository.buscarParticipante(participanteaux.getIdparticipante());
        return inscripto;
    }

    @Override
    public Inscripto searchParticipante(Integer idparticipante){
        Inscripto inscripto = participanteRepository.buscarParticipante(idparticipante);
        return inscripto;
    }

    @Override
    @Transactional
    public Inscripto actualizaPartici(Partici partici){
        Participante participanteaux=participanteRepository.findById(partici.getIdparticipante()).get();

        Categoria categoria = new Categoria();
        categoria.setIdcategoria(partici.getIdcategoria());
        participanteaux.setCategoria(categoria);

        Club club = new Club();
        club.setIdclub(partici.getIdclub());
        participanteaux.setClub(club);

        participanteRepository.saveAndFlush(participanteaux);

        Corredor corredor = participanteaux.getCorredor();

        corredor.setCategoria(categoria);
        corredor.setClub(participanteaux.getClub());
        corredor.setTipocat(partici.getTipocat());

        corredorRepository.saveAndFlush(corredor);

        Persona persona = corredor.getPersona();
        persona.setNombre(partici.getNombre());
        persona.setApellido(partici.getApellido());
        persona.setTelefono(partici.getTelefono());
        persona.setFecnac(partici.getFecnac());
        persona.setSexo(partici.getSexo());
        persona.setNacionalidad(partici.getNacionalidad());

        personaRepository.saveAndFlush(persona);

        return participanteRepository.buscarParticipante(participanteaux.getIdparticipante());
    }

    private Corredor registrarcorredor(Partici partici) {
        Persona persona =new Persona();
        persona.setCi(partici.getCi());
        persona.setNombre(partici.getNombre());
        persona.setApellido(partici.getApellido());
        persona.setTelefono(partici.getTelefono());
        persona.setTamano(partici.getTamano());
        Ciudad ciudad=new Ciudad();
        ciudad.setIdciudad(1);
        Pais pais=new Pais();
        pais.setIdpais(1);
        ciudad.setPais(pais);
        persona.setCiudad(ciudad);
        persona.setFecnac(partici.getFecnac());
        persona.setSexo(partici.getSexo());
        persona.setNacionalidad(partici.getNacionalidad());

        Corredor corredor = new Corredor();
        corredor.setPersona(persona);
        corredor.setTipocat(partici.getTipocat());
        Categoria categoria = new Categoria();
        categoria.setIdcategoria(partici.getIdcategoria());
        corredor.setCategoria(categoria);
        Club club = new Club();
        club.setIdclub(partici.getIdclub());
        corredor.setClub(club);
        corredor.setModificar(true);
        corredor.setLicencia(partici.getLicencia());
        corredor.setCatalianza(true);
        Regional regional = new Regional();
        regional.setIdregional(partici.getIdregional());
        corredor.setRegional(regional);
        Usuario usuario = new Usuario();
        usuario.setIdusuario(91);
        corredor.setUsuario(usuario);
        return corredorService.guardarCorredorInscripcion(corredor);
    }

    private void modificarcorredor(Partici partici) {
        corredorRepository.updateCorredorTelremera(partici.getIdcorredor(),partici.getTelefono(),partici.getTamano());
        corredorRepository.updateCorredorClubCatElige(partici.getIdcorredor(),partici.getIdclub(),partici.getIdcategoria(),partici.getTipocat(),partici.getModificar(), partici.getLicencia());
    }


    private Participante guardarparticipante(Corredor corredor, Evento evento, Regional regional,Integer tamano,Integer idclub) {
        Participante participante,participanteauxiliar;

        participante= new Participante();
        participante.setCorredor(corredor);
        participante.setTamano(corredor.getPersona().getTamano());

        Club club = new Club();
        club.setIdclub(idclub);
        participante.setClub(club);
        participante.setCategoria(corredor.getCategoria());

        Region region;
        region=clubRepository.findById(idclub).get().getRegion();

        participante.setRegion(region);

        Date fecha = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        participante.setFecha(fecha);

        participante.setEvento(evento);

        participante.setRegional(regional);

        participante.setCosto(evento.getMontopric());
        participante.setTamano(tamano);


        participanteauxiliar = participanteRepository.save(participante);
         //       participanteService.guardarParticipante(participante);
        return  participanteauxiliar;
    }

}
