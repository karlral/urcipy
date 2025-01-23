package com.sistema.urcipy.repositorios;


import com.sistema.urcipy.entidades.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Integer> {

    /*List<Categoria> findByRegional_Idregional(Integer idregional);*/

    List<Categoria> findByActivoIsTrue();

    List<Categoria> findByActivoIsTrueOrderByTandaAscOrdenAsc();
    /*@Query(value = "SELECT * \n"+
            "FROM categoria  \n" +
            "where regional_idregional=:idregional and activo \n" +
            "order by tanda,orden",nativeQuery = true)
    List<Categoria> findActivos(
            @Param("idregional") Integer idregional);*/
    Categoria findBySexoAndEdadinicioIsLessThanEqualAndEdadfinIsGreaterThanEqualAndTipoAndActivo(
            Byte sexo,Byte edadinicio,Byte edadfin,Byte tipo,Boolean activo
    );
}
