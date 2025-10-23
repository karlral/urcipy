package com.sistema.urcipy.repositorios;


import com.sistema.urcipy.entidades.Remera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RemeraRepository extends JpaRepository<Remera,Integer> {

}
