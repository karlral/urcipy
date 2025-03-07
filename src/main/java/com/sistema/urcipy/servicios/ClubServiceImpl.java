package com.sistema.urcipy.servicios;

import com.sistema.urcipy.entidades.Club;
import com.sistema.urcipy.repositorios.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class ClubServiceImpl implements ClubService{

    @Autowired
    private ClubRepository clubRepository;

    @Override
    public Club guardarClub(Club club){
        return clubRepository.save(club);
    }

    @Override
    public Set<Club> obtenerClubes() {
        return new LinkedHashSet<>(clubRepository.findAll());
    }
    @Override
    public Set<Club> obtenerClubesRun() {
        return new LinkedHashSet<>(clubRepository.findByModalidad_Idmodalidad(2));
    }

    @Override
    public Club obtenerClub(Integer idclub) {
        return clubRepository.findById(idclub).get();
    }

    @Override
    public void eliminarClub(Integer idclub) {
        Club club= new Club();
        club.setIdclub(idclub);
        clubRepository.delete(club);
    }
}
