package esprit.tn.examenrdv.services;
import esprit.tn.examenrdv.entities.*;
import esprit.tn.examenrdv.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class RendezVousService {
    @Autowired
    private RendezVousRepository rendezVousRepository;

    public RendezVous saveRendezVous(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    public List<RendezVous> getAllRendezVous() {
        return rendezVousRepository.findAll();
    }

    public Optional<RendezVous> getRendezVousById(Long id) {
        return rendezVousRepository.findById(id);
    }

    public void deleteRendezVous(Long id) {
        rendezVousRepository.deleteById(id);
    }
}