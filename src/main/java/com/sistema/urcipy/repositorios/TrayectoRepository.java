package com.sistema.urcipy.repositorios;


import com.sistema.urcipy.entidades.Trayecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TrayectoRepository extends JpaRepository<Trayecto,Integer> {

}
