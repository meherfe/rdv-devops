package esprit.tn.examenrdv.repositories;


import esprit.tn.examenrdv.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface MedecinRepository extends JpaRepository<Medecin, Long>{
}
