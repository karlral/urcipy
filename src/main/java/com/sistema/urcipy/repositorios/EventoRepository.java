package com.sistema.urcipy.repositorios;



import com.sistema.urcipy.entidades.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EventoRepository extends JpaRepository<Evento,Integer> {

}