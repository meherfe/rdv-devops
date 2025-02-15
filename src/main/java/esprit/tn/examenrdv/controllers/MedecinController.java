package esprit.tn.examenrdv.controllers;

import esprit.tn.examenrdv.entities.Medecin;
import esprit.tn.examenrdv.services.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


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
