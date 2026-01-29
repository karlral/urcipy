package com.sistema.urcipy.repositorios;


import com.sistema.urcipy.entidades.EventoRemera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;


@Repository
public interface EventoRemeraRepository extends JpaRepository<EventoRemera,Integer> {
    Set<EventoRemera> findAllByEvento_Idevento(Integer idEvento);
}
