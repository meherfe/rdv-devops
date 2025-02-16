package esprit.tn.examenrdv.controllers;



import esprit.tn.examenrdv.entities.Clinique;
import esprit.tn.examenrdv.services.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/clinique")
public class CliniqueController {
    private final  CliniqueService cliniqueService;

    @PostMapping("/add")
    public Clinique addClinique(@RequestBody Clinique clinique) {
        return cliniqueService.saveClinique(clinique);
    }

    @GetMapping("/all")
    public List<Clinique> getAllCliniques() {
        return cliniqueService.getAllCliniques();
    }

    @GetMapping("/{id}")
    public Optional<Clinique> getCliniqueById(@PathVariable Long id) {
        return cliniqueService.getCliniqueById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteClinique(@PathVariable Long id) {
        cliniqueService.deleteClinique(id);
    }
}
