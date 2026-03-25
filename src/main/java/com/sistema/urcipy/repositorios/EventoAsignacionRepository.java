package com.sistema.urcipy.repositorios;


import com.sistema.urcipy.entidades.EventoAsignacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;


@Repository
public interface EventoAsignacionRepository extends JpaRepository<EventoAsignacion,Integer> {

    Set<EventoAsignacion> findAllByEvento_Idevento(Integer idEvento);

}
