package com.sistema.urcipy.repositorios;



import com.sistema.urcipy.entidades.Corredor;
import com.sistema.urcipy.entidades.custom.Corredorbus;
import com.sistema.urcipy.entidades.custom.Corredormen;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CorredorRepository extends JpaRepository<Corredor,Integer> {
    //@EntityGraph(attributePaths = {"club"})
     Corredor findByIdcorredor(Integer idcorredor);


    //@EntityGraph(attributePaths = {"club"})
    Corredor findByPersonaCiAndRegionalIdregional
            (String ci,Integer idregional);

    @Query(value = "select co.idcorredor,p.nombre,p.apellido,cl.nomclub as club,p.fecnac,ca.nomcorto as categoria, \n" +
            "cast(co.fecmodi as date) as fecmodi,concat(p.nombre,' ',p.apellido) as corredor, co.carnetfpc, cl.ruta as foto, co.puntua \n" +
            "from corredor co \n" +
            "inner join persona p on p.idpersona=co.persona_idpersona \n" +
            "inner join club cl on cl.idclub = co.club_idclub \n" +
            "inner join categoria ca on ca.idcategoria=co.categoria_idcategoria \n" +
            "where p.ci =:ci and co.regional_idregional=:idregional and co.puntua=1",nativeQuery = true) //(co.carnetfpc=1 or co.carnetfpc=2 or co.carnetfpc=3)
    Corredormen correByCi(
            @Param("ci") String ci,
            @Param("idregional") Integer idregional);

    @Query(value = "select co.idcorredor,p.nombre,p.apellido,cl.nomclub as club,p.fecnac,ca.nomcorto as categoria, \n" +
            "cast(co.fecmodi as date) as fecmodi,concat(p.nombre,' ',p.apellido) as corredor, co.carnetfpc, p.foto, co.puntua \n" +
            "from corredor co \n" +
            "inner join persona p on p.idpersona=co.persona_idpersona \n" +
            "inner join club cl on cl.idclub = co.club_idclub \n" +
            "inner join categoria ca on ca.idcategoria=co.categoria_idcategoria \n" +
            "where (p.ci like :buscado or p.nombre like :buscado or p.apellido like :buscado or cl.nomclub like :buscado or ca.nomcorto like :buscado) and co.regional_idregional=:idregional",nativeQuery = true)
    List<Corredormen> corredoresBusCiNomApeClub(
            @Param("buscado") String buscado,
            @Param("idregional") Integer idregional);

    @Query(value = "select co.idcorredor,p.idpersona,ca.idcategoria,p.ci,concat(p.nombre,' ',p.apellido) as corredor,p.fecnac,p.sexo,p.telefono,ca.nomcorto as categoria,cl.nomclub as club, \n" +
            "p.nacionalidad,ci.nomciudad as ciudad, pa.nompais as pais, co.carnetfpc,  co.puntua, p.tamano\n" +
            "from corredor co \n" +
            "inner join persona p on p.idpersona=co.persona_idpersona \n" +
            "inner join club cl on cl.idclub = co.club_idclub \n" +
            "inner join categoria ca on ca.idcategoria=co.categoria_idcategoria \n" +
            "inner join ciudad ci on ci.idciudad=p.ciudad_idciudad\n" +
            "inner join pais pa on pa.idpais = ci.pais_idpais\n" +
            "where (p.ci like :buscado or p.nombre like :buscado or p.apellido like :buscado or cl.nomclub like :buscado or ca.nomcorto like :buscado) and co.regional_idregional=:idregional",nativeQuery = true)
    List<Corredorbus> corredoresBusCiNomApeClubDato(
            @Param("buscado") String buscado,
            @Param("idregional") Integer idregional);

    @Query(value = "select co.idcorredor,p.idpersona,ca.idcategoria,p.ci,concat(p.nombre,' ',p.apellido) as corredor,p.fecnac,p.sexo,p.telefono,ca.nomcorto as categoria,cl.nomclub as club, \n" +
            "p.nacionalidad,ci.nomciudad as ciudad, pa.nompais as pais, co.carnetfpc,  co.puntua, p.tamano \n" +
            "from corredor co \n" +
            "inner join persona p on p.idpersona=co.persona_idpersona \n" +
            "inner join club cl on cl.idclub = co.club_idclub \n" +
            "inner join categoria ca on ca.idcategoria=co.categoria_idcategoria \n" +
            "inner join ciudad ci on ci.idciudad=p.ciudad_idciudad\n" +
            "inner join pais pa on pa.idpais = ci.pais_idpais\n" +
            "where (p.ci = :ci) and co.regional_idregional=:idregional",nativeQuery = true)
    Corredorbus corredoresBusCi(
            @Param("ci") String ci,
            @Param("idregional") Integer idregional);

    @Modifying
    @Query(value = "update corredor co  " +
            "inner join persona pe on pe.idpersona=co.persona_idpersona \n" +
            "set  co.categoria_idcategoria=:idcategoria, co.club_idclub=:idclub  \n" +
            "where co.persona_idpersona=:idpersona and co.catalianza=1",nativeQuery = true)
    void updateCorredorAlianza(
            @Param("idpersona") Integer idpersona,
            @Param("idcategoria") Integer idcategoria,
            @Param("idclub") Integer idclub

    );

    @Modifying
    @Query(value = "update corredor co  " +
            "set  co.categoria_idcategoria=:idcategoria  \n" +
            "where co.idcorredor=:idcorredor",nativeQuery = true)
    void updateCorredorCat(
            @Param("idcorredor") Integer idcorredor,
            @Param("idcategoria") Integer idcategoria

    );

}
