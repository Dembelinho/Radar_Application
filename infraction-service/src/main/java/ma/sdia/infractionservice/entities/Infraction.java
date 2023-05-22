package ma.sdia.infractionservice.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.sdia.infractionservice.models.Radar;
import ma.sdia.infractionservice.models.Vehicule;

@Entity @Data @AllArgsConstructor @Builder @ToString @NoArgsConstructor
public class Infraction {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String date;
    private long id_Radar;
    private String matricule;
    @Transient
    private Radar radar;
    @Transient
    private Vehicule vehicule;
    private double vehicule_Vitesse;
    private int radar_Max_vitesse;
    private int montant;

}
