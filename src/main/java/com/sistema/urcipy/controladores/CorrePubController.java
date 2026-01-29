package com.sistema.urcipy.controladores;


import com.sistema.urcipy.entidades.Corredor;
import com.sistema.urcipy.entidades.Participante;
import com.sistema.urcipy.entidades.Persona;
import com.sistema.urcipy.entidades.Regional;
import com.sistema.urcipy.entidades.custom.Corredormen;
import com.sistema.urcipy.servicios.CorredorService;
import com.sistema.urcipy.servicios.ParticipanteService;
import com.sistema.urcipy.servicios.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/correpub")
@CrossOrigin("*")
public class CorrePubController {
    @Autowired
    private CorredorService corredorService;
    @Autowired
    private PersonaService personaService;
    @Autowired
    private ParticipanteService participanteService;


    @GetMapping("/{ci}/{idregional}")
    public Corredormen obtenerCorredorPorId(@PathVariable("ci") String ci,@PathVariable("idregional") Integer idregional){
        return corredorService.obtenerCorredormenCi(ci,idregional);
    }
    @GetMapping("/busci/{ci}/{idregional}")
    public ResponseEntity<?> obtenerCorredorPorCi(@PathVariable("ci") String ci, @PathVariable("idregional") Integer idregional){

        return ResponseEntity.ok(corredorService.obtenerCorredorbusCi(ci,idregional));
    }
    @GetMapping("/buscar/{ci}/{idregional}")
    public ResponseEntity<?> obtenerCorredorPorCiFull(@PathVariable("ci") String ci, @PathVariable("idregional") Integer idregional){

        return ResponseEntity.ok(corredorService.obtenerCorredorCi(ci,idregional));
    }

    @PostMapping("/")
    public ResponseEntity<Corredor> guardarCorredorRun(@RequestBody Corredor corredor){
        Corredor corredorGuardada;

        Regional regionalco= new Regional();
        regionalco.setIdregional(4);

        corredorGuardada=corredorService.obtenerCorredorCi(corredor.getPersona().getCi(),regionalco.getIdregional());
        if(corredorGuardada==null) { // vamos a crear el corredor con la regional
            Persona personaGuardada, personaAux;
            personaAux = personaService.obtenerPersonaCi(corredor.getPersona().getCi());
            if (personaAux == null) { //no hay persona en la regional y se crean
                personaAux = corredor.getPersona();
            }
            personaAux.setNombre(corredor.getPersona().getNombre().toUpperCase());
            personaAux.setApellido(corredor.getPersona().getApellido().toUpperCase());
            personaGuardada = personaService.guardarPersonaFlush(personaAux);

            //guardar en la regional 4 que es running
            Corredor corredorVar;
            corredorVar=new Corredor();
            corredorVar.setPersona(personaGuardada);
            corredorVar.setRegional(regionalco);

            corredorVar.setPuntua(corredor.getPuntua());
            corredorVar.setCarnet(corredor.getCarnet());
            corredorVar.setCategoria(corredor.getCategoria());
            corredorVar.setClub(corredor.getClub());
            corredorVar.setCarnetatras(corredor.getCarnetatras());
            corredorVar.setCatalianza(corredor.getCatalianza());
            corredorVar.setFecmodi(corredor.getFecmodi());
            corredorVar.setLicencia(corredor.getLicencia());
            corredorVar.setModificar(corredor.getModificar());
            corredorVar.setMontopuntua(corredor.getMontopuntua());
            corredorVar.setTipocat(corredor.getTipocat());
            corredorVar.setUsuario(corredor.getUsuario());
            corredorVar.setVerificar(corredor.getVerificar());
            corredorGuardada=corredorService.guardarCorredor(corredorVar);

        }
        return ResponseEntity.ok(corredorGuardada);
    }
    @PutMapping("/actuacatam")
    public void actualizarCategoria(@RequestBody Corredor corredor){

       // System.out.println("Probamos y vemos el contenido de"+corredor.toString() );
        Corredor corredoraux=corredorService.obtenerCorredor(corredor.getIdcorredor());
        if (corredoraux != null) {
            //System.out.println(corredor.getIdcorredor()+" - "+corredor.getCategoria().getIdcategoria()+" - ");
            corredorService.updateCatCorre(corredor.getIdcorredor(),corredor.getCategoria().getIdcategoria());
        }


        Persona personaAux= personaService.obtenerPersona(corredor.getPersona().getIdpersona());
        if (personaAux != null) {
            //System.out.println(corredor.getPersona().getIdpersona()+ " - " + corredor.getPersona().getTamano());

            personaService.updateTamano(corredor.getPersona().getIdpersona(),corredor.getPersona().getTamano());
        }

        Integer activo =1;
        participanteService.actualizarPartiTamCat(corredor.getIdcorredor(),corredor.getPersona().getTamano(),corredor.getCategoria().getIdcategoria(),activo);

    }
}
