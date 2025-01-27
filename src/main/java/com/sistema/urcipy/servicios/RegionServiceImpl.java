package com.sistema.urcipy.servicios;

import com.sistema.urcipy.entidades.Region;
import com.sistema.urcipy.repositorios.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class RegionServiceImpl implements RegionService{

    @Autowired
    private RegionRepository regionRepository;

    @Override
    public Region guardarRegion(Region region){
        return regionRepository.save(region);
    }

    @Override
    public Set<Region> obtenerRegiones() {
        return new LinkedHashSet<>(regionRepository.findAll());
    }

    @Override
    public Region obtenerRegion(Integer idregion) {
        return regionRepository.findById(idregion).get();
    }

    @Override
    public void eliminarRegion(Integer idregion) {
        Region region= new Region();
        region.setIdregion(idregion);
        regionRepository.delete(region);
    }
}