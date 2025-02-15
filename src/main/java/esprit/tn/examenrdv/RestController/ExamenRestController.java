package esprit.tn.examenrdv.RestController;

import esprit.tn.examenrdv.Entities.Clinique;
import esprit.tn.examenrdv.Entities.Medecin;
import esprit.tn.examenrdv.Entities.Patient;
import esprit.tn.examenrdv.Entities.RendezVous;
import esprit.tn.examenrdv.Service.IExamenService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import esprit.tn.examenrdv.Repositories.CliniqueRepository;
import java.util.List;
import esprit.tn.examenrdv.Entities.Specialite;


@RestController
@AllArgsConstructor
public class ExamenRestController {

    private IExamenService examenService;
    private CliniqueRepository cliniqueRepository;

    @PostMapping("/addClinique")
    public Clinique addClinique(@RequestBody Clinique clinique){
        return examenService.addClinique(clinique);
    }

    @PostMapping("/addMedecin/{cliniqueID}")
    public Medecin addMedecin(@RequestBody Medecin medecin, @PathVariable("cliniqueID") Long cliniqueID){


        return examenService.addMedecinAndAssignToClinique(medecin, cliniqueID);
    }

    @PostMapping("/addPatient")
    public Patient addPatient(@RequestBody Patient patient){
        return examenService.addPatient(patient);
    }


    @PostMapping("/addRDV/{medecinId}/{patientId}")
    public void addRDVAndAssignMedAndPatient(@RequestBody RendezVous rdv,
                                             @PathVariable Long medecinId,
                                             @PathVariable Long patientId) {
        examenService.addRDVAndAssignMedAndPatient(rdv, medecinId, patientId);
    }


    @GetMapping("/rendezvous/{idClinique}/{specialite}")
    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(@PathVariable Long idClinique,
                                                                 @PathVariable Specialite specialite) {
        return examenService.getRendezVousByCliniqueAndSpecialite(idClinique, specialite);
    }


    @GetMapping("/medecin/{idMedecin}/rendezvous/count")
    public int getNbrRendezVousMedecin(@PathVariable Long idMedecin) {
        return examenService.getNbrRendezVousMedecin(idMedecin);
    }


    @GetMapping("/test-retrieve-rendezvous")
    public void testRetrieveRendezVous() {
        examenService.retrieveRendezVous();
    }
}
