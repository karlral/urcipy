package com.sistema.urcipy.repositorios;


import com.sistema.urcipy.entidades.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RegionRepository extends JpaRepository<Region,Integer> {

}