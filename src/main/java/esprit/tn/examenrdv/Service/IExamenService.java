package esprit.tn.examenrdv.Service;

import esprit.tn.examenrdv.Entities.Clinique;
import esprit.tn.examenrdv.Entities.Medecin;
import esprit.tn.examenrdv.Entities.Patient;
import esprit.tn.examenrdv.Entities.RendezVous;
import esprit.tn.examenrdv.Entities.Specialite;
import java.util.List;
public interface IExamenService {

    public Clinique addClinique (Clinique clinique);
    public Medecin addMedecinAndAssignToClinique (Medecin medecin, Long cliniqueId);
    public Patient addPatient(Patient patient);
    public void addRDVAndAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long idPatient);
    public List getRendezVousByCliniqueAndSpecialite(Long idClinique,Specialite specialite);
    public int getNbrRendezVousMedecin(Long idMedecin);
    public void retrieveRendezVous();

}
