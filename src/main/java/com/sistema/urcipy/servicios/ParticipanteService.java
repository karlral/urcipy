package com.sistema.urcipy.servicios;



import com.sistema.urcipy.entidades.Participante;
import com.sistema.urcipy.entidades.custom.Punclub;
import com.sistema.urcipy.entidades.custom.Punclubpartici;
import com.sistema.urcipy.entidades.custom.Puncorredor;
import com.sistema.urcipy.entidades.custom.Puntoscorredor;

import java.util.Set;


public interface ParticipanteService {

    public Participante guardarParticipante(Participante participante);

    public Set<Participante> obtenerParticipantees();
    public Set<Participante> obtenerParticipantesProceso(Integer anho);

    public Set<Participante> obtenerParticipantesActivo(Integer activo);
    public Set<Participante> obtenerParticipantesByEvento(Integer idevento);
    public Participante obtenerParticipante(Integer idparticipante);

    public void eliminarParticipante(Integer idparticipante);

    public Set<Puncorredor> obtenerParticiPuntaje(Integer anho);

    public Set<Puntoscorredor> obtenerParticiByIdPuntajes(Integer anho, Integer idcorredor);
    public Set<Punclub> obtenerPuntajesInClub(Integer anho, Integer tipoone, Integer tipotwo);
    public Set<Punclubpartici> obtenerPuntajesByClubPartici(Integer anho, Integer tipoone, Integer tipotwo, Integer idclub);

}
