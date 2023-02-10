package com.sistema.urcipy.repositorios;


import com.sistema.urcipy.entidades.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CiudadRepository extends JpaRepository<Ciudad,Integer> {

}
