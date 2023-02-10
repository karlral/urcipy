package com.sistema.urcipy.repositorios;

import com.sistema.urcipy.entidades.Entidad;
import org.springframework.data.jpa.repository.JpaRepository;



public interface EntidadRepository extends JpaRepository<Entidad,Integer> {
}
