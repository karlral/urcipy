package com.sistema.urcipy.repositorios;

import com.sistema.urcipy.entidades.Historial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;


public interface HistorialRepository extends JpaRepository<Historial,Integer> {

    List<Historial> findAllByCi(String ci);

    @Procedure
    void cargahistorial(Integer p_idevento);
}
