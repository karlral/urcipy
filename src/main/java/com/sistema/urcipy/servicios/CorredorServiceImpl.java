package com.sistema.urcipy.servicios;

import com.sistema.urcipy.entidades.Corredor;
import com.sistema.urcipy.entidades.custom.Corredorbus;
import com.sistema.urcipy.entidades.custom.Corredormen;
import com.sistema.urcipy.repositorios.CorredorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class CorredorServiceImpl implements CorredorService{

    @Autowired
    private CorredorRepository corredorRepository;

    @Override
    public Corredor guardarCorredor(Corredor corredor){
        return corredorRepository.save(corredor);
    }
    @Override
    public void guardarCorredores(List<Corredor> corredores){
        //corredores.forEach(corredor -> corredorRepository.save(corredor));
        corredorRepository.saveAllAndFlush(corredores);
    }

    @Override
    public Set<Corredor> obtenerCorredores() {
        return new LinkedHashSet<>(corredorRepository.findAll());
    }
    @Override
    public Set<Corredor> obtenerCorredores(Integer idRegional) {
        return new LinkedHashSet<>(corredorRepository.findAllByRegional_Idregional(idRegional));
    }

    @Override
    public Corredor obtenerCorredor(Integer idcorredor) {
        return corredorRepository.findByIdcorredor(idcorredor);
    }
    @Override
    public Corredor obtenerCorredorCi(String ci,Integer idregional) {
        return corredorRepository.findByPersonaCiAndRegionalIdregional(ci,idregional);
    }
    @Override
    public void eliminarCorredor(Integer idcorredor) {
        Corredor corredor= new Corredor();
        corredor.setIdcorredor(idcorredor);
        corredorRepository.delete(corredor);
    }
    @Override
    public Corredormen obtenerCorredormenCi(String ci, Integer idregional) {
        return corredorRepository.correByCi(ci,idregional);
    }
    @Override
    public Corredorbus obtenerCorredorbusCi(String ci, Integer idregional) {
        return corredorRepository.corredoresBusCi(ci,idregional);
    }
    @Override
    public Set<Corredormen> obtenerCorredoresmenCiNomApeClub(String buscado,Integer idregional){
        return new LinkedHashSet<>(corredorRepository.corredoresBusCiNomApeClub(buscado,idregional));
    }
    @Override
    public Set<Corredorbus> obtenerCorredoresbusCiNomApeClubDato(String buscado,Integer idregional){
        return new LinkedHashSet<>(corredorRepository.corredoresBusCiNomApeClubDato(buscado,idregional));
    }
    @Override
    @Transactional
    public void catAlianza(Integer idpersona,Integer idcategoria,Integer idclub) {

        corredorRepository.updateCorredorAlianza(idpersona,idcategoria,idclub);
    }
    @Override
    @Transactional
    public void updateCatCorre(Integer idcorredor,Integer idcategoria){
        corredorRepository.updateCorredorCat(idcorredor,idcategoria);
    }
}
