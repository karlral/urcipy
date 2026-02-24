package com.sistema.urcipy.servicios;

import com.sistema.urcipy.entidades.*;
import com.sistema.urcipy.entidades.custom.*;
import com.sistema.urcipy.repositorios.CorredorRepository;
import com.sistema.urcipy.repositorios.EventoRepository;
import com.sistema.urcipy.repositorios.ParticipanteRepository;
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
                resultimio.getCi(),resultimio.getPuntajeclub());
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
    public void actualizarPartiTamCat(Integer idcorredor,Integer tamano,Integer idcategoria,Integer activo){
        participanteRepository.updateParticipanteTamCat(idcorredor,tamano,idcategoria,activo);
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
    public Inscripto inscribirPartici(Partici partici){

        Participante participanteaux=participanteRepository.findParticipanteByEventoIdeventoAndCorredorPersonaCi(partici.getIdevento(),partici.getCi());
                //participanteService.obtenerParticipantesByEventoCi(partici.getIdevento(),partici.getCi());
        if(participanteaux==null) {
            //System.out.println(idevento);
            Evento eventoold = eventoRepository.findByIdevento(partici.getIdevento());
                  //  eventoService.obtenerEvento(partici.getIdevento());
            //System.out.println(idevento);
            Integer alianza=eventoold.getAlianza();
            //System.out.println(alianza);
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
                        if (corredor.getModificar()){
                            modificarcorredor(partici);
                            corredor = corredorRepository.findByPersonaCiAndRegionalIdregional(partici.getCi(),evento.getRegional().getIdregional());
                        }
                        guardarparticipante(corredor,evento,evento.getRegional(),partici.getTamano());
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
                    if (corredor.getModificar()){
                        modificarcorredor(partici);
                        corredor = corredorRepository.findByPersonaCiAndRegionalIdregional(partici.getCi(),eventoold.getRegional().getIdregional());
                    }

                    participanteaux =guardarparticipante(corredor,eventoold,eventoold.getRegional(),partici.getTamano());
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

    private void modificarcorredor(Partici partici) {
        corredorRepository.updateCorredorTelremera(partici.getIdcorredor(),partici.getTelefono(),partici.getTamano());
        corredorRepository.updateCorredorClubCatElige(partici.getIdcorredor(),partici.getIdclub(),partici.getIdcategoria());
    }


    private Participante guardarparticipante(Corredor corredor, Evento evento, Regional regional,Integer tamano) {
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
        participante.setTamano(tamano);


        participanteauxiliar = participanteRepository.save(participante);
         //       participanteService.guardarParticipante(participante);
        return  participanteauxiliar;
    }

}
