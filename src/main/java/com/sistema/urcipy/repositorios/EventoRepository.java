package com.sistema.urcipy.repositorios;



import com.sistema.urcipy.entidades.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface EventoRepository extends JpaRepository<Evento,Integer> {

    List<Evento> findByModoEquals(Integer modo);
    List<Evento> findByActivoBetween(Integer startActivo, Integer endActivo);
    Evento findByActivo(Integer activo);

    List<Evento> findByModoEqualsAndFechaLessThan(Integer modo, Date fecha);

}
