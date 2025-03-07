package com.sistema.urcipy.repositorios;


import com.sistema.urcipy.entidades.Modalidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ModalidadRepository extends JpaRepository<Modalidad,Integer> {

}