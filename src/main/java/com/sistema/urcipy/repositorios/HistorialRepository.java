package com.sistema.urcipy.repositorios;

import com.sistema.urcipy.entidades.Historial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface HistorialRepository extends JpaRepository<Historial,Integer> {

    List<Historial> findAllByCi(String ci);
}
