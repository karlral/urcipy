package com.sistema.urcipy.repositorios;


import com.sistema.urcipy.entidades.Categoriah;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoriahRepository extends JpaRepository<Categoriah,Integer> {

}
