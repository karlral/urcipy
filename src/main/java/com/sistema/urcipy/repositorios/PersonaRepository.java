package com.sistema.urcipy.repositorios;


import com.sistema.urcipy.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonaRepository extends JpaRepository<Persona,Integer> {

    Persona findPersonaByCi(String ci);

    @Modifying
    @Query(value = "update persona  " +
            "set  tamano=:tamano  \n" +
            "where idpersona=:idpersona",nativeQuery = true)
    void updatePersonaTamano(
            @Param("idpersona") Integer idpersona,
            @Param("tamano") Integer tamano

    );

}