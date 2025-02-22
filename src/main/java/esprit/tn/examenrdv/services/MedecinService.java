package esprit.tn.examenrdv.services;
import esprit.tn.examenrdv.entities.*;
import esprit.tn.examenrdv.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
// Medecin Service
@Service
public class MedecinService {
    @Autowired
    private MedecinRepository medecinRepository;

    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    public List<Medecin> getAllMedecins() {
        return medecinRepository.findAll();
    }

    public Optional<Medecin> getMedecinById(Long id) {
        return medecinRepository.findById(id);
    }

    public void deleteMedecin(Long id) {
        medecinRepository.deleteById(id);
    }
}
