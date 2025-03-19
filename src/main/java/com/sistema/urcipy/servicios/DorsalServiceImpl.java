package com.sistema.urcipy.servicios;

import com.sistema.urcipy.entidades.Dorsal;
import com.sistema.urcipy.repositorios.DorsalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class DorsalServiceImpl implements DorsalService {
    @Autowired
    private DorsalRepository dorsalRepository;

    @Override
    public Dorsal guardarDorsal(Dorsal dorsal) {
        return dorsalRepository.save(dorsal);
    }

   
    @Override
    public Set<Dorsal> obtenerDorsales() {
        return new LinkedHashSet<>(dorsalRepository.findAll());
    }
    @Override
    public List<Dorsal> obtenerDorsalesActivosColor(String color) {
        return dorsalRepository.findByActivoIsTrueAndColorEquals(color);
    }
    @Override
    public Dorsal obtenerDorsal(Integer iddorsal) {
        return dorsalRepository.findById(iddorsal).get();
    }

    @Override
    public void eliminarDorsal(Integer iddorsal) {
        Dorsal dorsal= new Dorsal();
        dorsal.setIddorsal(iddorsal);
        dorsalRepository.delete(dorsal);
    }
}
