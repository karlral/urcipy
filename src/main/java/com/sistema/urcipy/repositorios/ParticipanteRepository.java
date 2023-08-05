package com.sistema.urcipy.repositorios;



import com.sistema.urcipy.entidades.Participante;
import com.sistema.urcipy.entidades.custom.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

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
}
