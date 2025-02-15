package esprit.tn.examenrdv.Entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString


public class Medecin implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMedecin;
    private String nomMedecin;
    private int telephone;
    private int prixConsultation;

    @Enumerated(EnumType.STRING)
    private  Specialite specialite;


    @ManyToMany(mappedBy="medecins")
    @JsonIgnore
    private List<Clinique> cliniques;


    @OneToMany(cascade = CascadeType.ALL, mappedBy="medecins")
    @JsonIgnore
    private List<RendezVous> rendezvous;


}
