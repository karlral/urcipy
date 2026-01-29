package com.sistema.urcipy.repositorios;


import com.sistema.urcipy.entidades.EventoTipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;


@Repository
public interface EventoTipoRepository extends JpaRepository<EventoTipo,Integer> {

    Set<EventoTipo> findAllByEvento_Idevento(Integer idEvento);

}
