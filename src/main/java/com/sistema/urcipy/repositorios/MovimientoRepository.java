package com.sistema.urcipy.repositorios;


import com.sistema.urcipy.entidades.Concepto;
import com.sistema.urcipy.entidades.Movimiento;
import com.sistema.urcipy.entidades.custom.Corredorank;
import com.sistema.urcipy.entidades.custom.Inscripagos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento,Integer> {
    List<Movimiento> findByConcepto_Regional_Idregional
            (Integer idregional);

    @Query(value = "SELECT m.idmovimiento, m.fecha,c.nomconcepto,co.idcorredor," +
            "concat(pe.nombre,' ',pe.apellido) as  corredor,cl.nomclub as club, \n" +
            "ca.nomcorto as categoria,m.entrada,m.salida,cl.ruta as foto,co.puntua \n"+
            "FROM movimiento m \n" +
            "inner join concepto c on c.idconcepto=m.concepto_idconcepto \n" +
            "inner join corredor co on co.idcorredor=m.corredor_idcorredor \n"+
            "inner join persona pe on pe.idpersona=co.persona_idpersona\n" +
            "inner join categoria ca on ca.idcategoria=co.categoria_idcategoria\n" +
            "inner join club cl on cl.idclub = co.club_idclub\n" +
            "where c.regional_idregional=:idregional and c.nomconcepto='RANKING' " +
            "and pe.ci like :ci",nativeQuery = true)
    Corredorank moviRankByCiAndIdregional(
            @Param("ci") String ci,
            @Param("idregional") Integer idregional);

   @Query(value = "SELECT m.idmovimiento, m.fecha,c.nomconcepto,co.idcorredor," +
           "concat(pe.nombre,' ',pe.apellido) as  corredor,cl.nomclub as club, \n" +
           "ca.nomcorto as categoria,m.entrada,m.salida,cl.ruta as foto,co.puntua \n"+
            "FROM movimiento m \n" +
            "inner join concepto c on c.idconcepto=m.concepto_idconcepto \n" +
            "inner join corredor co on co.idcorredor=m.corredor_idcorredor \n"+
           "inner join persona pe on pe.idpersona=co.persona_idpersona\n" +
           "inner join categoria ca on ca.idcategoria=co.categoria_idcategoria\n" +
           "inner join club cl on cl.idclub = co.club_idclub\n" +
            "where c.regional_idregional=:idregional and c.nomconcepto='RANKING'",nativeQuery = true)
    List<Corredorank> moviRankByIdregional(
            @Param("idregional") Integer idregional);
}
