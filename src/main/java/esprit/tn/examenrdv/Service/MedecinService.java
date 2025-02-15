package esprit.tn.examenrdv.Service;
import esprit.tn.examenrdv.Entities.*;
import esprit.tn.examenrdv.Repositories.*;
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
