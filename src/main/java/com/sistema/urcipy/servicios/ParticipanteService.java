package com.sistema.urcipy.servicios;



import com.sistema.urcipy.entidades.Participante;
import com.sistema.urcipy.entidades.Resultimio;
import com.sistema.urcipy.entidades.custom.*;

import java.util.List;
import java.util.Set;


public interface ParticipanteService {

    public Participante guardarParticipante(Participante participante);
    public int actualizarPuntajes(Resultimio resultimio);
    public Set<Participante> obtenerParticipantees();
    public Set<Participante> obtenerParticipantesProceso(Integer anho);

    public Set<Inscripcion> obtenerParticipantesActivo(Integer activo,Integer idregional);
    public Set<Inscripcion> obtenerParticipantesActivoNino(Integer activo,Integer idregional);
    public Set<Sendtimio> busParticipantesActivo(Integer activo);
    public Set<Sendtimio> busParticipantesByEvento(Integer idevento);
    public void eliminarParticipantesEvento(Integer idevento);
    public void eliminarParticipantesEventoNotCompleto(Integer idevento);
    public Set<Resultado> obtenerParticipantesByEvento(Integer idevento);
    public Set<Inscriptos> obtenerLisParticipantesByEventoActivoReg(Integer activo,Integer idregional);
    public List<Participante> obtenerLisParticipantesByEvento(Integer idevento);
    public Set<Inscripagos> obtenerLisPagParticipantesByEvento(Integer idevento);

    public Participante obtenerParticipantesByEventoCi(Integer idevento,String ci);
    public Participante obtenerParticipante(Integer idparticipante);

    public void eliminarParticipante(Integer idparticipante);

    public Set<Puncorredor> obtenerParticiPuntaje(Integer anho,Integer idregional);

    public Set<Puntoscorredor> obtenerParticiByIdPuntajes(Integer anho, Integer idcorredor,Integer idregional);

    public Set<Punclub> obtenerPuntajesInClub(Integer anho, Integer tipoone, Integer tipotwo, Integer idregional);
    public Set<Punclub> obtenerPuntajesXClubTwo(Integer anho, Integer tipoone, Integer tipotwo, Integer idregional);

    public Set<Punclubpartici> obtenerPuntajesByClubPartici(Integer anho, Integer tipoone, Integer tipotwo, Integer idclub,Integer idregional);
    public Set<Punclubpartici> obtenerPuntajesByClubTwoPartici(Integer anho, Integer tipoone, Integer tipotwo, Integer idclub,Integer idregional);

    public void activarPuntaje(Integer idcorredor);
    public void desactivarPuntaje(Integer idcorredor);
    public void actualizarPromedio(Integer idevento);
    public void actualizarClubCat(Integer idevento,Integer idcorredor);
    public void actualizarPartiTamano(Integer idcorredor,Integer tamano);
    public void actuaPartiDorsal(Integer idparticipante,Integer iddorsal);

}
