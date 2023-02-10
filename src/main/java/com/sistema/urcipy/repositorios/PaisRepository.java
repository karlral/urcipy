package com.sistema.urcipy.repositorios;


import com.sistema.urcipy.entidades.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PaisRepository extends JpaRepository<Pais,Integer> {

}
