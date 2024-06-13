package com.sistema.urcipy.servicios;



import com.sistema.urcipy.entidades.Participante;
import com.sistema.urcipy.entidades.Resultimio;
import com.sistema.urcipy.entidades.custom.*;

import java.util.Set;


public interface ParticipanteService {

    public Participante guardarParticipante(Participante participante);
    public int actualizarPuntajes(Resultimio resultimio);
    public Set<Participante> obtenerParticipantees();
    public Set<Participante> obtenerParticipantesProceso(Integer anho);

    public Set<Inscripcion> obtenerParticipantesActivo(Integer activo);
    public Set<Sendtimio> busParticipantesActivo(Integer activo);
    public void eliminarParticipantesEvento(Integer idevento);
    public Set<Resultado> obtenerParticipantesByEvento(Integer idevento);
    public Set<Inscriptos> obtenerLisParticipantesByEvento(Integer idevento);
    public Set<Inscripagos> obtenerLisPagParticipantesByEvento(Integer idevento);

    public Participante obtenerParticipantesByEventoCi(Integer idevento,String ci);
    public Participante obtenerParticipante(Integer idparticipante);

    public void eliminarParticipante(Integer idparticipante);

    public Set<Puncorredor> obtenerParticiPuntaje(Integer anho);

    public Set<Puntoscorredor> obtenerParticiByIdPuntajes(Integer anho, Integer idcorredor);
    public Set<Punclub> obtenerPuntajesInClub(Integer anho, Integer tipoone, Integer tipotwo);
    public Set<Punclubpartici> obtenerPuntajesByClubPartici(Integer anho, Integer tipoone, Integer tipotwo, Integer idclub);

    public void activarPuntaje(Integer idcorredor);
    public void desactivarPuntaje(Integer idcorredor);
    public void actualizarPromedio(Integer idevento);
    public void actualizarClubCat(Integer idevento,String ci, Integer idclub, Integer idcategoria);
}
