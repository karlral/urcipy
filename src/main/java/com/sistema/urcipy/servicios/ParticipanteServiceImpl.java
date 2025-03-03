package com.sistema.urcipy.servicios;

import com.sistema.urcipy.entidades.Participante;
import com.sistema.urcipy.entidades.Resultimio;
import com.sistema.urcipy.entidades.custom.*;
import com.sistema.urcipy.repositorios.ParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class ParticipanteServiceImpl implements ParticipanteService{

    @Autowired
    private ParticipanteRepository participanteRepository;

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
    public Set<Inscriptos> obtenerLisParticipantesByEventoActivoReg(Integer activo,Integer idregional){
        return new LinkedHashSet<>(participanteRepository.buscarParticipantesByEventoActivoReg(activo,idregional));
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
}
