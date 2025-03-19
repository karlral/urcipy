package com.sistema.urcipy.repositorios;

import com.sistema.urcipy.entidades.Dorsal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface DorsalRepository extends JpaRepository<Dorsal,Integer> {

    List<Dorsal> findByActivoIsTrueAndColorEquals(String color);
}
