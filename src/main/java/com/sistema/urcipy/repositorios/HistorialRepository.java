package com.sistema.urcipy.repositorios;

import com.sistema.urcipy.entidades.Historial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface HistorialRepository extends JpaRepository<Historial,Integer> {

    List<Historial> findAllByCi(String ci);

    @Query(value = "SELECT * \n" +
            "FROM historial \n" +
            "where year(fecha)=:anho",nativeQuery = true)
    List<Historial> searchByYearNative(
            @Param("anho") Integer anho);

    @Procedure
    void cargahistorial(Integer p_idevento);
}
