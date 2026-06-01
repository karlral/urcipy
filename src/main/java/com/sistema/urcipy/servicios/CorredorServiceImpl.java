package com.sistema.urcipy.servicios;

import com.sistema.urcipy.entidades.Corredor;
import com.sistema.urcipy.entidades.Persona;
import com.sistema.urcipy.entidades.Regional;
import com.sistema.urcipy.entidades.custom.Correbus;
import com.sistema.urcipy.entidades.custom.Corredorbus;
import com.sistema.urcipy.entidades.custom.Corredormen;
import com.sistema.urcipy.repositorios.CorredorRepository;
import com.sistema.urcipy.repositorios.PersonaRepository;
import com.sistema.urcipy.repositorios.RegionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class CorredorServiceImpl implements CorredorService{

    @Autowired
    private CorredorRepository corredorRepository;

    @Autowired
    private PersonaRepository personaRepository;


    @Override
    public Corredor guardarCorredor(Corredor corredor){
        return corredorRepository.save(corredor);
    }
    @Override
    public Corredor guardarCorredorPersona(Corredor corredor){
        Corredor corredorGuardada;
        Regional regionalco=corredor.getRegional();
        Integer idregionalco=regionalco.getIdregional();
        System.out.println("guarda con regional y modalidad");
        System.out.println(idregionalco);

        Integer idmodalidadco=corredor.getModalidad().getIdmodalidad();
        System.out.println(idmodalidadco);
        corredorGuardada=corredorRepository.findByPersonaCiAndRegionalIdregionalAndModalidadIdmodalidad(corredor.getPersona().getCi(),idregionalco,idmodalidadco);
        if(corredorGuardada==null) { // vamos a crear el corredor con la regional
            Persona personaGuardada, personaAux;
            personaAux = personaRepository.findPersonaByCi(corredor.getPersona().getCi());
            if (personaAux == null) { //no hay persona en la regional y se crean
                personaAux = corredor.getPersona();
            }
            personaAux.setNombre(corredor.getPersona().getNombre().toUpperCase());
            personaAux.setApellido(corredor.getPersona().getApellido().toUpperCase());
            personaGuardada = personaRepository.saveAndFlush(personaAux);

            corredor.setPersona(personaGuardada);

            corredorGuardada= this.corredorRepository.saveAndFlush(corredor);

        }
        return corredorGuardada;
    }

    @Override
    public void guardarCorredores(List<Corredor> corredores){
        //corredores.forEach(corredor -> corredorRepository.save(corredor));
        corredorRepository.saveAllAndFlush(corredores);
    }
    @Override
    public Corredor guardarCorredorInscripcion(Corredor corredor){
        Corredor corredorGuardada;
        corredorGuardada = this.guardarCorredorPersona( corredor);

        return corredorGuardada;
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
    public Corredor obtenerCorredorCi(String ci,Integer idregional,Integer idmodalidad) {
        return corredorRepository.findByPersonaCiAndRegionalIdregionalAndModalidadIdmodalidad(ci,idregional,idmodalidad);
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
    public Corredorbus obtenerCorredorbusCi(String ci, Integer idregional,Integer idmodalidad) {
        return corredorRepository.corredoresBusCi(ci,idregional,idmodalidad);
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
    public void catAlianza(Integer idpersona,Integer idcategoria,Integer idclub,Byte tipo) {

        corredorRepository.updateCorredorAlianza(idpersona,idcategoria,idclub,tipo);
    }
    @Override
    @Transactional
    public void updateCatClubCorre(Corredor corredor){
        corredorRepository.updateCorredorClubCatElige(corredor.getIdcorredor(),corredor.getClub().getIdclub(),corredor.getCategoria().getIdcategoria(),corredor.getTipocat(),corredor.getModificar(),corredor.getLicencia());
    }
    @Override
    @Transactional
    public void updateTelremera(Correbus correbus){
        corredorRepository.updateCorredorTelremera(correbus.getIdcorredor(),correbus.getTelefono(),correbus.getTamano());
    }

}
