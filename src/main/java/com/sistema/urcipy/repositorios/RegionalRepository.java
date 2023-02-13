package com.sistema.urcipy.repositorios;


import com.sistema.urcipy.entidades.Regional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RegionalRepository extends JpaRepository<Regional,Integer> {

}
