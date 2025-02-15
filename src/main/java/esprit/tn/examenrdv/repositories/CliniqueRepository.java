package esprit.tn.examenrdv.repositories;


import esprit.tn.examenrdv.entities.Clinique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CliniqueRepository extends JpaRepository<Clinique, Long> {
}
