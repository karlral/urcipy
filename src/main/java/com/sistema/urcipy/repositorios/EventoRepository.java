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
    List<Evento> findByRegional_IdregionalOrderByFecha(Integer idregional);

    List<Evento> findByModoEqualsAndRegional_idregionalOrderByFecha(Integer modo,Integer idregional);
    List<Evento> findByActivoBetweenAndRegional_idregionalOrderByFecha(Integer startActivo, Integer endActivo, Integer idregional);

    Evento findByActivo(Integer activo);

    Evento findByActivoAndRegional_idregionalOrderByFecha(Integer activo,Integer idregional);

    List<Evento> findByActivoAndAlianzaOrderByFecha
            (Integer activo,Integer alianza);

    List<Evento> findByModoEqualsAndFechaLessThanAndRegional_idregionalOrderByFecha(Integer modo, Date fecha, Integer idregional);

}
