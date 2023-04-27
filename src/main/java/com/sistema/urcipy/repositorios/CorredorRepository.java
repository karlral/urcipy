package com.sistema.urcipy.repositorios;



import com.sistema.urcipy.entidades.Corredor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CorredorRepository extends JpaRepository<Corredor,Integer> {

}
