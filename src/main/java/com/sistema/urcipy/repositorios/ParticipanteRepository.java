package com.sistema.urcipy.repositorios;



import com.sistema.urcipy.entidades.Participante;
import com.sistema.urcipy.entidades.custom.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface ParticipanteRepository extends JpaRepository<Participante,Integer> {

    @Query(value = "SELECT * \n" +
            "FROM participante p \n" +
            "where year(p.fecha)=:anho",nativeQuery = true)
    List<Participante> findParticipantesporAnho(
            @Param("anho") Integer anho
    );
    @Query(value = "SELECT c.nomcorto as categoria,concat(pe.nombre,' ',pe.apellido) as  corredor,p.puestocat, p.tiempo\n" +
            "FROM participante p \n" +
            "inner join corredor co on co.idcorredor=p.corredor_idcorredor\n" +
            "inner join persona pe on pe.idpersona=co.persona_idpersona\n" +
            "inner join categoria c on c.idcategoria=p.categoria_idcategoria\n" +
            "where p.evento_idevento=:idevento and p.completo=1 \n" +
            " order by 1,3",nativeQuery = true)
    List<Resultado> buscarParticipantesByEventoIdeventoOrderByPuestocat(
            @Param("idevento") Integer idevento);

    @Query(value = "SELECT p.idparticipante as id,p.fecha,pe.ci, concat(pe.nombre,' ',pe.apellido) as  corredor,pe.sexo,\n" +
            "pe.fecnac, pe.telefono,ci.nomciudad as ciudad, pa.nompais as pais,\n" +
            "cl.nomclub as club,c.nomcorto as categoria,c.codigo,\n" +
            "t.km as km,p.acobrar,p.pagado,p.dorsal,p.nrogiro,d.chip,\n" +
            "c.tanda,c.orden,c.horario,p.tamano \n" +
            "FROM participante p \n" +
            "inner join corredor co on co.idcorredor=p.corredor_idcorredor\n" +
            "inner join persona pe on pe.idpersona=co.persona_idpersona\n" +
            "inner join categoria c on c.idcategoria=p.categoria_idcategoria\n" +
            "inner join trayecto t on t.idtrayecto=c.trayecto_idtrayecto\n" +
            "inner join ciudad ci on ci.idciudad=pe.ciudad_idciudad\n" +
            "inner join pais pa on pa.idpais = ci.pais_idpais\n" +
            "inner join club cl on cl.idclub = p.club_idclub\n" +
            "inner join evento e on e.idevento=p.evento_idevento\n" +
            "left outer join dorsal d on d.iddorsal=p.dorsal\n" +
            "where e.activo=:activo and p.regional_idregional=:idregional order by p.fecha",nativeQuery = true)
    List<Inscriptos> buscarParticipantesByEventoActivoReg(
            @Param("activo") Integer activo,
            @Param("idregional")  Integer idregional
            );
    List<Participante> findParticipantesByEventoIdeventoOrderByCategoria_Nomcorto
            (Integer idevento);

    @Query(value = "SELECT  p.idparticipante as id,pe.ci, concat(pe.nombre,' ',pe.apellido) as  corredor,\n" +
            " pe.telefono,\n" +
            "cl.nomclub as club,c.nomcorto as categoria, p.acobrar,p.pagado,p.dorsal,p.nrogiro\n" +
            "FROM participante p \n" +
            "inner join corredor co on co.idcorredor=p.corredor_idcorredor\n" +
            "inner join persona pe on pe.idpersona=co.persona_idpersona\n" +
            "inner join categoria c on c.idcategoria=p.categoria_idcategoria\n" +
            "inner join club cl on cl.idclub = p.club_idclub\n" +
            "where p.evento_idevento=:idevento",nativeQuery = true)
    List<Inscripagos> buscarpagParticipantesByEventoIdevento(
            @Param("idevento") Integer idevento);

    Participante findParticipanteByEventoIdeventoAndCorredorPersonaCi(Integer idevento,String ci);

    @Query(value = "SELECT c.tanda,c.orden,c.horario,t.km,cl.ruta,cl.nomclub as club," +
            "c.nomcorto as categoria,c.nomalternativo as catalternativo,concat(pe.nombre,' ',pe.apellido) as  corredor,p.totalpuntos,p.dorsal \n" +
            "FROM participante p \n" +
            "inner join corredor co on co.idcorredor=p.corredor_idcorredor\n" +
            "inner join persona pe on pe.idpersona=co.persona_idpersona\n" +
            "inner join categoria c on c.idcategoria=p.categoria_idcategoria\n" +
            "inner join trayecto t on t.idtrayecto=c.trayecto_idtrayecto\n" +
            "inner join evento e on e.idevento=p.evento_idevento\n" +
            "inner join club cl on cl.idclub=p.club_idclub\n" +
            "where e.activo=:activo and p.regional_idregional=:idregional and t.idtrayecto <> 4 \n" +
            " order by c.tanda,c.orden,p.totalpuntos desc ",nativeQuery = true)
    List<Inscripcion> buscarParticipantesByEventoActivo(
            @Param("activo") Integer activo,
            @Param("idregional")  Integer idregional);

    @Query(value = "SELECT c.tanda,c.orden,c.horario,t.km,cl.ruta,cl.nomclub as club," +
            "c.nomcorto as categoria,concat(pe.nombre,' ',pe.apellido) as  corredor,p.totalpuntos,p.dorsal \n" +
            "FROM participante p \n" +
            "inner join corredor co on co.idcorredor=p.corredor_idcorredor\n" +
            "inner join persona pe on pe.idpersona=co.persona_idpersona\n" +
            "inner join categoria c on c.idcategoria=p.categoria_idcategoria\n" +
            "inner join trayecto t on t.idtrayecto=c.trayecto_idtrayecto\n" +
            "inner join evento e on e.idevento=p.evento_idevento\n" +
            "inner join club cl on cl.idclub=p.club_idclub\n" +
            "where e.activo=:activo and p.regional_idregional=:idregional and t.idtrayecto = 4 \n" +
            " order by c.tanda,c.orden,p.totalpuntos desc ",nativeQuery = true)
    List<Inscripcion> buscarParticipantesByEventoActivoNino(
            @Param("activo") Integer activo,
            @Param("idregional")  Integer idregional);

    @Query(value = "SELECT co.idcorredor,concat(pe.nombre,' ',pe.apellido) as corredor,c.nomcorto as categoria,sum(p.puntaje) as puntaje,p.orden \n" +
            "FROM participante p \n" +
            "inner join corredor co on co.idcorredor=p.corredor_idcorredor\n" +
            "inner join persona pe on pe.idpersona=co.persona_idpersona\n" +
            "inner join categoria c on c.idcategoria=p.categoria_idcategoria\n" +
            "where year(p.fecha)=:anho and completo=1 and p.regional_idregional=:idregional \n" +
            "group by co.idcorredor,concat(pe.nombre,' ',pe.apellido),c.nomcorto,orden\n" +
            "order by 3,4 desc, 5",nativeQuery = true)
    List<Puncorredor> puntajeByParticiNative(
            @Param("anho") Integer anho,
            @Param("idregional")  Integer idregional
            );

    @Query(value = "SELECT co.idcorredor,concat(pe.nombre,' ',pe.apellido) as corredor\n" +
            ",c.nomcorto as categoria,cl.ruta,cl.nomclub as club, e.nomevento as evento,p.puestocat,p.puntaje\n" +
            "FROM participante p \n" +
            "inner join corredor co on co.idcorredor=p.corredor_idcorredor\n" +
            "inner join persona pe on pe.idpersona=co.persona_idpersona\n" +
            "inner join categoria c on c.idcategoria=p.categoria_idcategoria\n" +
            "inner join club cl on cl.idclub=p.club_idclub\n" +
            "inner join evento e on e.idevento=p.evento_idevento\n" +
            "where year(p.fecha)=:anho and p.completo=1 and co.idcorredor=:idcorredor " +
            " and p.regional_idregional=:idregional",nativeQuery = true)
    List<Puntoscorredor> listaPuntajesByParticiNative(
            @Param("anho") Integer anho,
            @Param("idcorredor") Integer idcorredor,
            @Param("idregional")  Integer idregional
            );

    @Query(value = "SELECT cl.idclub,cl.ruta,cl.nomclub,sum(p.puntaje) as puntaje\n" +
            "FROM participante p \n" +
            "inner join categoria c on c.idcategoria=p.categoria_idcategoria\n" +
            "inner join club cl on cl.idclub=p.club_idclub\n" +
            "where year(p.fecha)=:anho and p.completo=1 " +
            "and (c.tipo=:tipoone or c.tipo=:tipotwo) and p.regional_idregional=:idregional \n" +
            " group by cl.idclub,cl.ruta,cl.nomclub order by 4 desc",nativeQuery = true)
    List<Punclub> listaPuntajesInClubNative(
            @Param("anho") Integer anho,@Param("tipoone") Integer tipoone,
            @Param("tipotwo") Integer tipotwo,@Param("idregional") Integer idregional);

    @Query(value = "SELECT cl.idclub,cl.ruta,cl.nomclub,sum(p.puntajeclub) as puntaje\n" +
            "FROM participante p \n" +
            "inner join categoria c on c.idcategoria=p.categoria_idcategoria\n" +
            "inner join club cl on cl.idclub=p.club_idclub\n" +
            "where year(p.fecha)=:anho and p.completo=1 " +
            "and (c.tipo=:tipoone or c.tipo=:tipotwo) and p.regional_idregional=:idregional " +
            "and p.puntua=1 \n" +
            " group by cl.idclub,cl.ruta,cl.nomclub order by 4 desc",nativeQuery = true)
    List<Punclub> listaPuntajesXClubTwoNative(
            @Param("anho") Integer anho,@Param("tipoone") Integer tipoone,
            @Param("tipotwo") Integer tipotwo,@Param("idregional") Integer idregional);

    @Query(value = "SELECT month(e.fecha) as mes,cl.rutagrande,e.nomevento,concat(pe.nombre,' ',pe.apellido) as partici,p.puntaje\n" +
            "FROM participante p \n" +
            "inner join corredor co on co.idcorredor=p.corredor_idcorredor\n" +
            "inner join persona pe on pe.idpersona=co.persona_idpersona\n" +
            "inner join categoria c on c.idcategoria=p.categoria_idcategoria\n" +
            "inner join evento e on e.idevento=p.evento_idevento\n" +
            "inner join club cl on cl.idclub=e.club_idclub\n" +
            "where year(p.fecha)=:anho and p.completo=1 and (c.tipo=:tipoone or c.tipo=:tipotwo) " +
            "and p.club_idclub=:idclub and p.regional_idregional=:idregional \n" +
            " order by e.fecha,p.puntaje desc",nativeQuery = true)
    List<Punclubpartici> listaPuntajesByClubParticiNative(
            @Param("anho") Integer anho,@Param("tipoone") Integer tipoone,
            @Param("tipotwo") Integer tipotwo,@Param("idclub") Integer idclub
            ,@Param("idregional") Integer idregional);

    @Query(value = "SELECT month(e.fecha) as mes,cl.rutagrande,e.nomevento,concat(pe.nombre,' ',pe.apellido) as partici,p.puntajeclub as puntaje \n" +
            "FROM participante p \n" +
            "inner join corredor co on co.idcorredor=p.corredor_idcorredor\n" +
            "inner join persona pe on pe.idpersona=co.persona_idpersona\n" +
            "inner join categoria c on c.idcategoria=p.categoria_idcategoria\n" +
            "inner join evento e on e.idevento=p.evento_idevento\n" +
            "inner join club cl on cl.idclub=e.club_idclub\n" +
            "where year(p.fecha)=:anho and p.completo=1 and (c.tipo=:tipoone or c.tipo=:tipotwo) " +
            "and p.puntua=1 " +
            "and p.club_idclub=:idclub and p.regional_idregional=:idregional \n" +
            " order by e.fecha,p.puntaje desc",nativeQuery = true)
    List<Punclubpartici> listaPuntajesByClubTwoParticiNative(
            @Param("anho") Integer anho,@Param("tipoone") Integer tipoone,
            @Param("tipotwo") Integer tipotwo,@Param("idclub") Integer idclub
            ,@Param("idregional") Integer idregional);

    @Modifying
    @Query(value = "update participante p inner join corredor co on co.idcorredor=p.corredor_idcorredor " +
            "            inner join persona pe on pe.idpersona=co.persona_idpersona \n" +
            "set p.tiempo = :tiempo, p.puestocat=:puestocat,p.puesto=:puesto," +
            "p.dorsal=:dorsal,p.puntaje=:puntaje,p.puntajeaux=:puntajeaux,p.completo=:completo, p.puntajeclub = :puntajeclub " +
            " where p.evento_idevento = :idevento and pe.ci = :ci ",nativeQuery = true)
    int setPuntajePosicion( @Param("tiempo") Date tiempo, @Param("puestocat") Integer puestocat,
                            @Param("puesto") Integer puesto, @Param("dorsal")    Integer dorsal,
                            @Param("puntaje")     Integer puntaje, @Param("puntajeaux")     Integer puntajeaux,
                            @Param("completo")     Integer completo, @Param("idevento")     Integer idevento,
                            @Param("ci")     String ci,@Param("puntajeclub") Integer puntajeclub);

    @Modifying
    @Query(value = "DELETE FROM participante \n" +
            "where evento_idevento=:idevento",nativeQuery = true)
    void deletePartEvento(
            @Param("idevento") Integer idevento
    );

    @Modifying
    @Query(value = "DELETE FROM participante \n" +
            "where evento_idevento=:idevento and completo=0",nativeQuery = true)
    void deletePartEventoNotCompleto(
            @Param("idevento") Integer idevento
    );


    @Query(value = "SELECT p.idparticipante as id, p.puesto as nro, concat(pe.nombre,' ',pe.apellido) as  nomparticipante,p.puestocat as poscategoria,\n" +
            "p.tiempos,p.dorsal,pe.ci,p.km as distancia,c.nomcorto as categoria,cl.nomclub as club, p.puntua \n" +
            "            FROM participante p \n" +
            "            inner join corredor co on co.idcorredor=p.corredor_idcorredor\n" +
            "            inner join persona pe on pe.idpersona=co.persona_idpersona\n" +
            "            inner join categoria c on c.idcategoria=p.categoria_idcategoria\n" +
            "            inner join evento e on e.idevento=p.evento_idevento\n" +
            "            inner join club cl on cl.idclub=p.club_idclub\n" +
            "            where e.activo=:activo  ",nativeQuery = true)
    List<Sendtimio> busTimioParticipantesByEventoActivo(
            @Param("activo") Integer activo);

    @Query(value = "SELECT p.idparticipante as id, p.puesto as nro, concat(pe.nombre,' ',pe.apellido) as  nomparticipante,p.puestocat as poscategoria,\n" +
            "p.tiempos,p.dorsal,pe.ci,p.km as distancia,c.nomcorto as categoria,cl.nomclub as club, p.puntua \n" +
            "            FROM participante p \n" +
            "            inner join corredor co on co.idcorredor=p.corredor_idcorredor\n" +
            "            inner join persona pe on pe.idpersona=co.persona_idpersona\n" +
            "            inner join categoria c on c.idcategoria=p.categoria_idcategoria\n" +
            "            inner join evento e on e.idevento=p.evento_idevento\n" +
            "            inner join club cl on cl.idclub=p.club_idclub\n" +
            "            where e.idevento=:idevento  ",nativeQuery = true)
    List<Sendtimio> busTimioParticipantesByEvento(
            @Param("idevento") Integer idevento);

    @Modifying
    @Query(value = "UPDATE participante p SET p.puntaje=p.puntajeaux \n" +
            "where p.corredor_idcorredor = :idcorredor  and year(p.fecha)=year(current_date)",nativeQuery = true)
    void activarPuntajeId(
            @Param("idcorredor") Integer idcorredor
    );

    @Modifying
    @Query(value = "UPDATE participante p SET p.puntaje=0 \n" +
            "where p.corredor_idcorredor = :idcorredor  and year(p.fecha)=year(current_date)",nativeQuery = true)
    void desactivarPuntajeId(
            @Param("idcorredor") Integer idcorredor
    );

    @Modifying
    @Query(value = "update participante set promedio =km*3600/time_to_sec(tiempo)  \n" +
            "where evento_idevento=:idevento",nativeQuery = true)
    void updatePromedio(
            @Param("idevento") Integer idevento
    );

    @Modifying
    @Query(value = "update participante p inner join corredor c on p.corredor_idcorredor=c.idcorredor " +
            "inner join persona pe on pe.idpersona=c.persona_idpersona " +
            "set p.club_idclub = c.club_idclub, p.categoria_idcategoria=c.categoria_idcategoria  \n" +
            "where p.evento_idevento=:idevento and c.idcorredor=:idcorredor",nativeQuery = true)
    void updateParticipanteClubCat(
            @Param("idevento") Integer idevento,  @Param("idcorredor") Integer idcorredor
    );

    @Modifying
    @Query(value = "update participante p " +
            "inner join evento e on e.idevento =p.evento_idevento "+
            "inner join modalidad m on m.idmodalidad =e.modalidad_idmodalidad "+
            "set  tamano=:tamano  \n" +
            "where corredor_idcorredor=:idcorredor and m.idmodalidad=2",nativeQuery = true)
    void updateParticipanteTamano(
            @Param("idcorredor") Integer idcorredor,
            @Param("tamano") Integer tamano

    );

    @Modifying
    @Query(value = "UPDATE participante p SET p.dorsal=:iddorsal \n" +
            "where p.idparticipante = :idparticipante ",nativeQuery = true)
    void actuaDorsalId(
            @Param("idparticipante") Integer idparticipante,
            @Param("iddorsal") Integer iddorsal
    );

}
