package com.sistema.urcipy.repositorios;



import com.sistema.urcipy.entidades.Corredor;
import com.sistema.urcipy.entidades.custom.Corredorbus;
import com.sistema.urcipy.entidades.custom.Corredormen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CorredorRepository extends JpaRepository<Corredor,Integer> {
    Corredor findByCiEquals(String ci);
    List<Corredor> findByCiLikeOrNombreLikeOrApellidoLike(String ci, String nombre, String apellido);

    @Query(value = "select co.idcorredor,co.nombre,co.apellido,cl.nomclub as club,co.fecnac,ca.nomcorto as categoria, \n" +
            "cast(co.fecmodi as date) as fecmodi,concat(co.nombre,' ',co.apellido) as corredor, co.carnetfpc, co.foto, co.puntua \n" +
            "from corredor co \n" +
            "inner join corredor_club_regional ccr on ccr.corredor_idcorredor=co.idcorredor \n" +
            "inner join club cl on cl.idclub = ccr.club_idclub \n" +
            "inner join categoria ca on ca.idcategoria=co.categoria_idcategoria \n" +
            "where co.ci =:ci and ccr.regional_idregional=:idregional and (carnetfpc=1 or carnetfpc=2 or carnetfpc=3)",nativeQuery = true)
    Corredormen correByCi(
            @Param("ci") String ci,
            @Param("idregional") Integer idregional);

    @Query(value = "select co.idcorredor,co.nombre,co.apellido,cl.nomclub as club,co.fecnac,ca.nomcorto as categoria, \n" +
            "cast(co.fecmodi as date) as fecmodi,concat(co.nombre,' ',co.apellido) as corredor, co.carnetfpc , co.foto, co.puntua \n" +
            "from corredor co \n" +
            "inner join corredor_club_regional ccr on ccr.corredor_idcorredor=co.idcorredor \n" +
            "inner join club cl on cl.idclub = ccr.club_idclub \n" +
            "inner join categoria ca on ca.idcategoria=co.categoria_idcategoria \n" +
            "where (co.ci like :buscado or co.nombre like :buscado or co.apellido like :buscado or cl.nomclub like :buscado or ca.nomcorto like :buscado) and ccr.regional_idregional=:idregional",nativeQuery = true)
    List<Corredormen> corredoresBusCiNomApeClub(
            @Param("buscado") String buscado,
            @Param("idregional") Integer idregional);

    @Query(value = "select co.ci,concat(co.nombre,' ',co.apellido) as corredor,co.fecnac,co.sexo,co.telefono,ca.nomcorto as categoria,cl.nomclub as club, \n" +
            "pa.nacionalidad,ci.nomciudad as ciudad, pa.nompais as pais, co.carnetfpc,  co.puntua \n" +
            "from corredor co \n" +
            "inner join corredor_club_regional ccr on ccr.corredor_idcorredor=co.idcorredor \n" +
            "inner join club cl on cl.idclub = ccr.club_idclub \n" +
            "inner join categoria ca on ca.idcategoria=co.categoria_idcategoria \n" +
            "inner join ciudad ci on ci.idciudad=co.ciudad_idciudad\n" +
            "inner join pais pa on pa.idpais = ci.pais_idpais\n" +
            "where (co.ci like :buscado or co.nombre like :buscado or co.apellido like :buscado or cl.nomclub like :buscado or ca.nomcorto like :buscado) and ccr.regional_idregional=:idregional",nativeQuery = true)
    List<Corredorbus> corredoresBusCiNomApeClubDato(
            @Param("buscado") String buscado,
            @Param("idregional") Integer idregional);

}
