package com.sistema.urcipy.repositorios;



import com.sistema.urcipy.entidades.UsuarioRol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface UsuarioRolRepository extends JpaRepository<UsuarioRol,Integer> {
    Set<UsuarioRol> findAllByRol_idrol(Integer idrol);
}
