package com.sistema.urcipy.repositorios;


import com.sistema.urcipy.entidades.Resultimio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ResultimioRepository extends JpaRepository<Resultimio,Integer> {

    @Modifying
    @Query(value = "DELETE FROM resultimio \n" +
            "where evento_idevento=:idevento",nativeQuery = true)
    void deleteSendEvento(
            @Param("idevento") Integer idevento
    );
}
