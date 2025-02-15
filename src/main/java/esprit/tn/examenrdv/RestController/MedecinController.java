package esprit.tn.examenrdv.RestController;

import esprit.tn.examenrdv.Entities.Clinique;
import esprit.tn.examenrdv.Entities.Medecin;
import esprit.tn.examenrdv.Entities.Patient;
import esprit.tn.examenrdv.Entities.RendezVous;
import esprit.tn.examenrdv.Service.IExamenService;
import esprit.tn.examenrdv.Service.MedecinService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import esprit.tn.examenrdv.Repositories.CliniqueRepository;
import java.util.List;
import java.util.Optional;

import esprit.tn.examenrdv.Entities.Specialite;


@RestController
@RequestMapping("/medecin")
public class MedecinController {
    @Autowired
    private MedecinService medecinService;

    @PostMapping("/add")
    public Medecin addMedecin(@RequestBody Medecin medecin) {
        return medecinService.saveMedecin(medecin);
    }

    @GetMapping("/all")
    public List<Medecin> getAllMedecins() {
        return medecinService.getAllMedecins();
    }

    @GetMapping("/{id}")
    public Optional<Medecin> getMedecinById(@PathVariable Long id) {
        return medecinService.getMedecinById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteMedecin(@PathVariable Long id) {
        medecinService.deleteMedecin(id);
    }
}