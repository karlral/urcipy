package com.sistema.urcipy.repositorios;


import com.sistema.urcipy.entidades.Club;
import com.sistema.urcipy.entidades.custom.Clube;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ClubRepository extends JpaRepository<Club,Integer> {

    List<Club> findByModalidad_Idmodalidad(Integer idmodalidad);

    @Query(value = "SELECT c.idclub,c.nomclub \n" +
            "FROM club c \n" +
            "where c.modalidad_idmodalidad=:idmodalidad",nativeQuery = true)
    List<Clube> saarchByClube(
            @Param("idmodalidad") Integer idmodalidad);
}
