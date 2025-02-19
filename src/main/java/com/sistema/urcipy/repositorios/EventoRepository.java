package com.sistema.urcipy.repositorios;



import com.sistema.urcipy.entidades.Corredor;
import com.sistema.urcipy.entidades.Evento;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface EventoRepository extends JpaRepository<Evento,Integer> {

    @EntityGraph(attributePaths = {"club"})
    Evento findByIdevento(Integer idevento);

    @EntityGraph(attributePaths = {"club"})
    List<Evento> findByRegional_Idregional(Integer idregional);

    List<Evento> findByModoEqualsAndRegional_idregional(Integer modo,Integer idregional);
    List<Evento> findByActivoBetweenAndRegional_idregional(Integer startActivo, Integer endActivo, Integer idregional);

    Evento findByActivo(Integer activo);

    Evento findByActivoAndRegional_idregional(Integer activo,Integer idregional);

    List<Evento> findByActivoAndAlianza
            (Integer activo,Integer alianza);

    List<Evento> findByModoEqualsAndFechaLessThanAndRegional_idregional(Integer modo, Date fecha, Integer idregional);

}
