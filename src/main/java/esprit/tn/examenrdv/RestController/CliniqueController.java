package esprit.tn.examenrdv.RestController;


import esprit.tn.examenrdv.Entities.*;
import esprit.tn.examenrdv.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clinique")
public class CliniqueController {
    @Autowired
    private CliniqueService cliniqueService;

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