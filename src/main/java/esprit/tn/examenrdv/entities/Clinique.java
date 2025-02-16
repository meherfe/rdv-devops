package esprit.tn.examenrdv.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Clinique implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idClinique;
    private String nomClinique;
    private String adresse;
    private int telephone;
    @ManyToMany
    private List<Medecin> medecins;


}
