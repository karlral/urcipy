package com.sistema.urcipy.repositorios;


import com.sistema.urcipy.entidades.Campeones;
import com.sistema.urcipy.entidades.custom.Anhocat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CampeonesRepository extends JpaRepository<Campeones,Integer> {

    @Query(value = "SELECT c.ano ,h.nomcorto,h.idcategoriah FROM urcipy.campeones c\n" +
            "inner join categoriah h on h.idcategoriah=c.categoriah_idcategoriah \n" +
            "group by c.ano,h.nomcorto,h.idcategoriah;",nativeQuery = true)
    List<Anhocat> categoriahByAnhoNative();

    List<Campeones> findCampeonesByCategoriahIdcategoriah(
            @Param("idcategoriah") Integer idcategoriah
    );

}
