package com.sistema.urcipy.repositorios;


import com.sistema.urcipy.entidades.Puntaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PuntajeRepository extends JpaRepository<Puntaje,Integer> {

}