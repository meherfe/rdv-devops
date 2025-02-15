package esprit.tn.examenrdv.Service;

import esprit.tn.examenrdv.Entities.*;
import esprit.tn.examenrdv.Repositories.CliniqueRepository;
import esprit.tn.examenrdv.Repositories.MedecinRepository;
import esprit.tn.examenrdv.Repositories.PatientRepository;
import esprit.tn.examenrdv.Repositories.RendezVousRepository;
import esprit.tn.examenrdv.Entities.Specialite;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.scheduling.annotation.Scheduled;
import java.text.SimpleDateFormat;


import java.util.List;


@Service
@AllArgsConstructor
public class ExamenServiceIMP implements IExamenService{



    private CliniqueRepository cliniqueRepository;
    private MedecinRepository medecinRepository;
    private PatientRepository patientRepository;
    private RendezVousRepository rendezVousRepository;


    @Override
    public Clinique addClinique(Clinique clinique) {
        return cliniqueRepository.save(clinique);
    }

    @Override
    public Medecin addMedecinAndAssignToClinique(Medecin medecin, Long cliniqueId) {

        Clinique clinique = cliniqueRepository.findById(cliniqueId)
                .orElseThrow(() -> new IllegalArgumentException("Clinique not found with ID: " + cliniqueId));

        clinique.getMedecins().add(medecin);

        medecinRepository.save(medecin);
        cliniqueRepository.save(clinique);
        return medecinRepository.save(medecin);
    }

    @Override
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void addRDVAndAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long idPatient) {

        // Find the Medecin by id
        Medecin medecin = medecinRepository.findById(idMedecin)
                .orElseThrow(() -> new IllegalArgumentException("Medecin not found with ID: " + idMedecin));

        // Find the Patient by id
        Patient patient = patientRepository.findById(idPatient)
                .orElseThrow(() -> new IllegalArgumentException("Patient not found with ID: " + idPatient));

        // Assign the Medecin and Patient to the RendezVous
        rdv.setMedecins(medecin);
        rdv.setPatients(patient);


        // Save the RendezVous
        rendezVousRepository.save(rdv);

    }

    @Override
    public List getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite) {
        return rendezVousRepository.findRendezVousByCliniqueAndSpecialite(idClinique, specialite);
    }

    @Override
    public int getNbrRendezVousMedecin(Long idMedecin) {
        return rendezVousRepository.countByMedecinId(idMedecin);
    }

    @Override
    @Scheduled(fixedRate = 30000) // Runs every 30 seconds
    public void retrieveRendezVous() {
        List<RendezVous> futureRendezVous = rendezVousRepository.findFutureRendezVous();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        for (RendezVous rdv : futureRendezVous) {
            System.out.println("La liste des RendezVous : " + dateFormat.format(rdv.getDateRDV()) +
                    " : Medecin : " + rdv.getMedecins().getNomMedecin() +
                    " : Patient : " + rdv.getPatients().getNomPatient());
        }
    }
}
