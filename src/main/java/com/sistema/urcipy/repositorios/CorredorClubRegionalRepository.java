package com.sistema.urcipy.repositorios;

import com.sistema.urcipy.entidades.CorredorClubRegional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorredorClubRegionalRepository extends JpaRepository<CorredorClubRegional, Integer> {

    CorredorClubRegional findCorredorClubRegionalByCorredorIdcorredorAndRegionalIdregional(
            Integer corredor_idcorredor, Integer regional_idregional
    );

}
