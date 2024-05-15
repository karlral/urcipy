package com.sistema.urcipy.repositorios;



import com.sistema.urcipy.entidades.Corredor;
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
            "inner join club cl on cl.idclub=co.club_idclub \n" +
            "inner join categoria ca on ca.idcategoria=co.categoria_idcategoria \n" +
            "where ci =:ci and (carnetfpc=1 or carnetfpc=2)",nativeQuery = true)
    Corredormen correByCi(
            @Param("ci") String ci);

    @Query(value = "select co.idcorredor,co.nombre,co.apellido,cl.nomclub as club,co.fecnac,ca.nomcorto as categoria, \n" +
            "cast(co.fecmodi as date) as fecmodi,concat(co.nombre,' ',co.apellido) as corredor, co.carnetfpc , co.foto, co.puntua \n" +
            "from corredor co \n" +
            "inner join club cl on cl.idclub=co.club_idclub \n" +
            "inner join categoria ca on ca.idcategoria=co.categoria_idcategoria \n" +
            "where ci like :buscado or co.nombre like :buscado or co.apellido like :buscado or cl.nomclub like :buscado",nativeQuery = true)
    List<Corredormen> corredoresBusCiNomApeClub(
            @Param("buscado") String buscado);

}
