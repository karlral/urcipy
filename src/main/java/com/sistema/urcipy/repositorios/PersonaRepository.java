package com.sistema.urcipy.repositorios;


import com.sistema.urcipy.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonaRepository extends JpaRepository<Persona,Integer> {

    Persona findPersonaByCi(String ci);

}