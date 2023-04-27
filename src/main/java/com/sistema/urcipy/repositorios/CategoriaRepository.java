package com.sistema.urcipy.repositorios;


import com.sistema.urcipy.entidades.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Integer> {

}
