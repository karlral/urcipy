package com.sistema.urcipy.repositorios;


import com.sistema.urcipy.entidades.Asignacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AsignacionRepository extends JpaRepository<Asignacion,Integer> {



}
