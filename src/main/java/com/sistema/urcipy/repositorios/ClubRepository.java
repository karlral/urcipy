package com.sistema.urcipy.repositorios;


import com.sistema.urcipy.entidades.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClubRepository extends JpaRepository<Club,Integer> {

}
