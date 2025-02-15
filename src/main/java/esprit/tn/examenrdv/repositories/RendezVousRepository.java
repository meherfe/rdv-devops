package esprit.tn.examenrdv.repositories;

import esprit.tn.examenrdv.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface RendezVousRepository extends JpaRepository<RendezVous, Long>{

    @Query("SELECT r FROM RendezVous r WHERE r.medecins.specialite = :specialite AND r.medecins IN " +
            "(SELECT m FROM Clinique c JOIN c.medecins m WHERE c.idClinique = :idClinique)")
        List<RendezVous> findRendezVousByCliniqueAndSpecialite(@Param("idClinique") Long idClinique,
                                                           @Param("specialite") Specialite specialite);

    @Query("SELECT COUNT(r) FROM RendezVous r WHERE r.medecins.idMedecin = :idMedecin")
    int countByMedecinId(@Param("idMedecin") Long idMedecin);

    @Query("SELECT r FROM RendezVous r WHERE r.dateRDV > CURRENT_DATE")
    List<RendezVous> findFutureRendezVous();

}
