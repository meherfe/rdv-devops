package esprit.tn.examenrdv.Service;

import esprit.tn.examenrdv.Entities.*;
import esprit.tn.examenrdv.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

// Clinique Service
@Service
public class CliniqueService {
    @Autowired
    private CliniqueRepository cliniqueRepository;

    public Clinique saveClinique(Clinique clinique) {
        return cliniqueRepository.save(clinique);
    }

    public List<Clinique> getAllCliniques() {
        return cliniqueRepository.findAll();
    }

    public Optional<Clinique> getCliniqueById(Long id) {
        return cliniqueRepository.findById(id);
    }

    public void deleteClinique(Long id) {
        cliniqueRepository.deleteById(id);
    }
}