package com.sistema.urcipy.repositorios;


import com.sistema.urcipy.entidades.Campeonato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;


@Repository
public interface CampeonatoRepository extends JpaRepository<Campeonato,Integer> {

    Set<Campeonato> findByRegional_Idregional(Integer idregional);


}