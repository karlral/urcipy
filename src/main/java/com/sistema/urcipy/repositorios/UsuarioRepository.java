package com.sistema.urcipy.repositorios;


import com.sistema.urcipy.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    public Usuario findByUsername(String username);
}
