package com.sistema.urcipy.servicios;

import com.sistema.urcipy.entidades.Dorsal;

import java.util.List;
import java.util.Set;

public interface DorsalService {
    public Dorsal guardarDorsal(Dorsal dorsal);
    
    public Set<Dorsal> obtenerDorsales();

    public List<Dorsal> obtenerDorsalesActivosColor(String color);

    public Dorsal obtenerDorsal(Integer iddorsal);

    public void eliminarDorsal(Integer iddorsal);

}
