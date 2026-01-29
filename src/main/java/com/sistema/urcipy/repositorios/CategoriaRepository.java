package com.sistema.urcipy.repositorios;


import com.sistema.urcipy.entidades.Categoria;
import com.sistema.urcipy.entidades.Corredor;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Integer> {

   // @EntityGraph(attributePaths = {"trayecto","modalidad"})
    Categoria findByIdcategoria(Integer idcategoria);
    /*List<Categoria> findByRegional_Idregional(Integer idregional);*/

    List<Categoria> findByActivoIsTrue();

    List<Categoria> findByOrderByModalidad_IdmodalidadAscTandaAscOrdenAsc();

    List<Categoria> findByActivoIsTrueOrderByTandaAscOrdenAsc();

    List<Categoria> findByActivoIsTrueAndModalidad_IdmodalidadOrderByNomcategoria(Integer idmodalidad);

    List<Categoria> findByActivoIsTrueAndTrayecto_IdtrayectoOrderByTandaAscOrdenAsc(Integer idtrayecto);

    /*@Query(value = "SELECT * \n"+
            "FROM categoria  \n" +
            "where regional_idregional=:idregional and activo \n" +
            "order by tanda,orden",nativeQuery = true)
    List<Categoria> findActivos(
            @Param("idregional") Integer idregional);*/
    Categoria findBySexoAndEdadinicioIsLessThanEqualAndEdadfinIsGreaterThanEqualAndTipoAndActivoAndModalidad_idmodalidad(
            Byte sexo,Byte edadinicio,Byte edadfin,Byte tipo,Boolean activo,Integer idmodalidad
    );
}
