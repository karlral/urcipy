package com.sistema.urcipy.servicios;

import com.sistema.urcipy.entidades.Club;
import com.sistema.urcipy.entidades.CorredorClubRegional;
import com.sistema.urcipy.repositorios.CorredorClubRegionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class CorredorClubRegionalServiceImpl implements CorredorClubRegionalService{

    @Autowired
    private CorredorClubRegionalRepository corredorClubRegionalRepository;

    @Override
    public CorredorClubRegional guardarCorredorClubRegional(CorredorClubRegional corredorClubRegional){
        return corredorClubRegionalRepository.save(corredorClubRegional);
    }

    @Override
    public Set<CorredorClubRegional> obtenerCorredorClubRegionales() {
        return new LinkedHashSet<>(corredorClubRegionalRepository.findAll());
    }

    @Override
    public CorredorClubRegional obtenerCorredorClubRegional(Integer idcorredorClubRegional) {
        return corredorClubRegionalRepository.findById(idcorredorClubRegional).get();
    }

    @Override
    public void eliminarCorredorClubRegional(Integer idcorredorClubRegional) {
        CorredorClubRegional corredorClubRegional= new CorredorClubRegional();
        corredorClubRegional.setIdcorredorClubRegional(idcorredorClubRegional);
        corredorClubRegionalRepository.delete(corredorClubRegional);
    }
    @Override
    public Club obtenerClub(Integer idcorredor, Integer idRegional) {

        return corredorClubRegionalRepository.findCorredorClubRegionalByCorredorIdcorredorAndRegionalIdregional(idcorredor, idRegional).getClub();
    }
    @Override
    public CorredorClubRegional obtenerCorreClubReg(Integer idcorredor, Integer idRegional) {

        return corredorClubRegionalRepository.findCorredorClubRegionalByCorredorIdcorredorAndRegionalIdregional(idcorredor, idRegional);
    }
}
