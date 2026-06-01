package com.sistema.urcipy.controladores;


import com.sistema.urcipy.entidades.Corredor;
import com.sistema.urcipy.entidades.Participante;
import com.sistema.urcipy.entidades.Persona;
import com.sistema.urcipy.entidades.Regional;
import com.sistema.urcipy.entidades.custom.Correbus;
import com.sistema.urcipy.entidades.custom.Corredorbus;
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


    @GetMapping("/{ci}/{idregional}")
    public Corredormen obtenerCorredorPorId(@PathVariable("ci") String ci,@PathVariable("idregional") Integer idregional){
        return corredorService.obtenerCorredormenCi(ci,idregional);
    }
    @GetMapping("/busci/{ci}/{idregional}/{idmodalidad}")
    public ResponseEntity<?> obtenerCorredorPorCi(@PathVariable("ci") String ci, @PathVariable("idregional") Integer idregional, @PathVariable("idmodalidad") Integer idmodalidad){
        Corredorbus corredorbus=corredorService.obtenerCorredorbusCi(ci,idregional,idmodalidad);
        return ResponseEntity.ok(corredorbus);
    }
    @GetMapping("/corbusci/{ci}/{idregional}/{idmodalidad}")
    public ResponseEntity<?> obtenerCorredorbusPorCi(@PathVariable("ci") String ci, @PathVariable("idregional") Integer idregional,@PathVariable("idmodalidad") Integer idmodalidad){
        Corredorbus corredorbus=corredorService.obtenerCorredorbusCi(ci,idregional,idmodalidad);
        if (corredorbus == null) {
            return ResponseEntity.badRequest().body("Corredor no existe");
        }
        return ResponseEntity.ok(corredorbus);
    }


    @PostMapping("/")
    public ResponseEntity<Corredor> guardarCorredorRun(@RequestBody Corredor corredor){
        Corredor corredorGuardada;
        corredorGuardada = corredorService.guardarCorredorInscripcion(corredor);


        return ResponseEntity.ok(corredorGuardada);
    }
    @PutMapping("/actuacatam")
    public void actualizarCategoria(@RequestBody Corredor corredor){

       // System.out.println("Probamos y vemos el contenido de"+corredor.toString() );
        Corredor corredoraux=corredorService.obtenerCorredor(corredor.getIdcorredor());
        if (corredoraux != null) {
            //System.out.println(corredor.getIdcorredor()+" - "+corredor.getCategoria().getIdcategoria()+" - ");
            corredorService.updateCatClubCorre(corredor);
        }

        Persona personaAux= personaService.obtenerPersona(corredor.getPersona().getIdpersona());
        if (personaAux != null) {
            //System.out.println(corredor.getPersona().getIdpersona()+ " - " + corredor.getPersona().getTamano());

            personaService.updateTamano(corredor.getPersona().getIdpersona(),corredor.getPersona().getTamano());
        }




    }
    @PutMapping("/telremera")
    public void actualizartelremera(@RequestBody Correbus correbus){
        corredorService.updateTelremera(correbus);
    }
}
