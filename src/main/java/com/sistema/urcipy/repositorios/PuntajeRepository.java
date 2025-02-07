package com.sistema.urcipy.repositorios;


import com.sistema.urcipy.entidades.Puntaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;


@Repository
public interface PuntajeRepository extends JpaRepository<Puntaje,Integer> {

    Set<Puntaje> findByRegional_Idregional(Integer idregional);

    Puntaje findByPosicionAndRegional_Idregional(Integer posicion,Integer idregional);
}