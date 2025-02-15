package esprit.tn.examenrdv.Entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString

public class RendezVous implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRDV;
    @Temporal(TemporalType.DATE)
    private Date dateRDV;
    private String remarque;


    @ManyToOne
    @JsonIgnore
    private Medecin medecins;

    @ManyToOne
    @JsonIgnore
    private Patient patients;



}
