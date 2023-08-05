package com.sistema.urcipy.repositorios;



import com.sistema.urcipy.entidades.Corredor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CorredorRepository extends JpaRepository<Corredor,Integer> {
    Corredor findByCiEquals(String ci);
    List<Corredor> findByCiLikeOrNombreLikeOrApellidoLike(String ci, String nombre, String apellido);
}
