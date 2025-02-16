package esprit.tn.examenrdv.services;

import esprit.tn.examenrdv.entities.*;
import esprit.tn.examenrdv.repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

// Clinique Service
@Service
@AllArgsConstructor
public class CliniqueService {
    private final CliniqueRepository cliniqueRepository;

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