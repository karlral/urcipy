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
    @Query(value = "SELECT c.nomcorto as categoria,concat(co.nombre,' ',co.apellido) as  corredor,p.puestocat, p.tiempo\n" +
            "FROM participante p \n" +
            "inner join corredor co on co.idcorredor=p.corredor_idcorredor\n" +
            "inner join categoria c on c.idcategoria=p.categoria_idcategoria\n" +
            "where p.evento_idevento=:idevento\n" +
            " order by 1,3",nativeQuery = true)
    List<Resultado> buscarParticipantesByEventoIdeventoOrderByPuestocat(
            @Param("idevento") Integer idevento);

    @Query(value = "SELECT p.idparticipante as idresultimio,p.fecha,co.ci, concat(co.nombre,' ',co.apellido) as  nomparticipante, co.sexo,\n" +
            "co.fecnac, co.telefono,ci.nomciudad as ciudad, pa.nompais as pais,\n" +
            "cl.nomclub as club,c.nomcorto as categoria,t.km as distancia,p.tiempo,p.puntaje,p.completo,p.proceso,p.acobrar,p.pagado,p.dorsal,p.nrogiro\n" +
            "FROM participante p \n" +
            "inner join corredor co on co.idcorredor=p.corredor_idcorredor\n" +
            "inner join categoria c on c.idcategoria=p.categoria_idcategoria\n" +
            "inner join trayecto t on t.idtrayecto=c.trayecto_idtrayecto\n" +
            "inner join ciudad ci on ci.idciudad=co.ciudad_idciudad\n" +
            "inner join pais pa on pa.idpais = ci.pais_idpais\n" +
            "inner join club cl on cl.idclub = p.club_idclub\n" +
            "where p.evento_idevento=:idevento order by p.fecha",nativeQuery = true)
    List<Inscriptos> buscarParticipantesByEventoIdevento(
            @Param("idevento") Integer idevento);

    @Query(value = "SELECT  p.idparticipante as id,co.ci, concat(co.nombre,' ',co.apellido) as  corredor,\n" +
            " co.telefono,\n" +
            "cl.nomclub as club,c.nomcorto as categoria, p.acobrar,p.pagado,p.dorsal,p.nrogiro\n" +
            "FROM participante p \n" +
            "inner join corredor co on co.idcorredor=p.corredor_idcorredor\n" +
            "inner join categoria c on c.idcategoria=p.categoria_idcategoria\n" +
            "inner join club cl on cl.idclub = p.club_idclub\n" +
            "where p.evento_idevento=:idevento",nativeQuery = true)
    List<Inscripagos> buscarpagParticipantesByEventoIdevento(
            @Param("idevento") Integer idevento);

    Participante findParticipanteByEventoIdeventoAndCorredorCi(Integer idevento,String ci);

    @Query(value = "SELECT cl.ruta,cl.nomclub as club,c.nomcorto as categoria,concat(co.nombre,' ',co.apellido) as  corredor\n" +
            "FROM participante p \n" +
            "inner join corredor co on co.idcorredor=p.corredor_idcorredor\n" +
            "inner join categoria c on c.idcategoria=p.categoria_idcategoria\n" +
            "inner join evento e on e.idevento=p.evento_idevento\n" +
            "inner join club cl on cl.idclub=p.club_idclub\n" +
            "where e.activo=:activo\n" +
            " order by p.fecha ",nativeQuery = true)
    List<Inscripcion> buscarParticipantesByEventoActivo(
            @Param("activo") Integer activo);

    @Query(value = "SELECT co.idcorredor,concat(co.nombre,' ',co.apellido) as corredor,c.nomcorto as categoria,sum(p.puntaje) as puntaje,p.orden \n" +
            "FROM participante p \n" +
            "inner join corredor co on co.idcorredor=p.corredor_idcorredor\n" +
            "inner join categoria c on c.idcategoria=p.categoria_idcategoria\n" +
            "where year(p.fecha)=:anho and completo=1 \n" +
            "group by co.idcorredor,concat(co.nombre,' ',co.apellido),c.nomcorto,orden\n" +
            "order by 3,4 desc, 5",nativeQuery = true)
    List<Puncorredor> puntajeByParticiNative(
            @Param("anho") Integer anho);

    @Query(value = "SELECT co.idcorredor,concat(co.nombre,' ',co.apellido) as corredor\n" +
            ",c.nomcorto as categoria,cl.ruta,cl.nomclub as club, e.nomevento as evento,p.puestocat,p.puntaje\n" +
            "FROM participante p \n" +
            "inner join corredor co on co.idcorredor=p.corredor_idcorredor\n" +
            "inner join categoria c on c.idcategoria=p.categoria_idcategoria\n" +
            "inner join club cl on cl.idclub=p.club_idclub\n" +
            "inner join evento e on e.idevento=p.evento_idevento\n" +
            "where year(p.fecha)=:anho and p.completo=1 and co.idcorredor=:idcorredor",nativeQuery = true)
    List<Puntoscorredor> listaPuntajesByParticiNative(
            @Param("anho") Integer anho,@Param("idcorredor") Integer idcorredor);

    @Query(value = "SELECT cl.idclub,cl.ruta,cl.nomclub,sum(p.puntaje) as puntaje\n" +
            "FROM participante p \n" +
            "inner join categoria c on c.idcategoria=p.categoria_idcategoria\n" +
            "inner join club cl on cl.idclub=p.club_idclub\n" +
            "where year(p.fecha)=:anho and p.completo=1 and (c.tipo=:tipoone or c.tipo=:tipotwo) \n" +
            " group by cl.idclub,cl.ruta,cl.nomclub order by 4 desc",nativeQuery = true)
    List<Punclub> listaPuntajesInClubNative(
            @Param("anho") Integer anho,@Param("tipoone") Integer tipoone,@Param("tipotwo") Integer tipotwo);

    @Query(value = "SELECT cl.rutagrande,e.nomevento,concat(co.nombre,' ',co.apellido) as partici,p.puntaje\n" +
            "FROM participante p \n" +
            "inner join corredor co on co.idcorredor=p.corredor_idcorredor\n" +
            "inner join categoria c on c.idcategoria=p.categoria_idcategoria\n" +
            "inner join evento e on e.idevento=p.evento_idevento\n" +
            "inner join club cl on cl.idclub=e.club_idclub\n" +
            "where year(p.fecha)=:anho and p.completo=1 and (c.tipo=:tipoone or c.tipo=:tipotwo) and p.club_idclub=:idclub\n" +
            " order by e.fecha,p.puntaje desc",nativeQuery = true)
    List<Punclubpartici> listaPuntajesByClubParticiNative(
            @Param("anho") Integer anho,@Param("tipoone") Integer tipoone,@Param("tipotwo") Integer tipotwo,@Param("idclub") Integer idclub);

    @Modifying
    @Query("update Participante p set p.tiempo = :tiempo, p.puestocat=:puestocat," +
            "p.puesto=:puesto,p.dorsal=:dorsal,p.puntaje=:puntaje,p.puntajeaux=:puntajeaux," +
            "p.completo=:completo where p.idparticipante = :idparticipante ")
    int setPuntajePosicion( @Param("tiempo") Date tiempo, @Param("puestocat") Integer puestocat,
                            @Param("puesto") Integer puesto, @Param("dorsal")    Integer dorsal,
                            @Param("puntaje")     Integer puntaje, @Param("puntajeaux")     Integer puntajeaux,
                            @Param("completo")     Integer completo, @Param("idparticipante")     Integer idparticipante);

    @Modifying
    @Query(value = "DELETE FROM participante \n" +
            "where evento_idevento=:idevento",nativeQuery = true)
    void deletePartEvento(
            @Param("idevento") Integer idevento
    );

    @Query(value = "SELECT p.idparticipante as id, p.puesto as nro, concat(co.nombre,' ',co.apellido) as  nomparticipante,p.puestocat as poscategoria,\n" +
            "p.tiempos,p.dorsal,co.ci,p.km as distancia,c.nomcorto as categoria,cl.nomclub as club, p.puntua \n" +
            "            FROM participante p \n" +
            "            inner join corredor co on co.idcorredor=p.corredor_idcorredor\n" +
            "            inner join categoria c on c.idcategoria=p.categoria_idcategoria\n" +
            "            inner join evento e on e.idevento=p.evento_idevento\n" +
            "            inner join club cl on cl.idclub=p.club_idclub\n" +
            "            where e.activo=:activo  ",nativeQuery = true)
    List<Sendtimio> busTimioParticipantesByEventoActivo(
            @Param("activo") Integer activo);


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

}
