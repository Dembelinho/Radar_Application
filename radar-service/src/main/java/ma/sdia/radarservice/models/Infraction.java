package ma.sdia.radarservice.models;

import jakarta.persistence.Transient;
import lombok.*;
import ma.sdia.radarservice.entities.Radar;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor

public class Infraction {
    private Long id;

    private Vehicule vehicule;
    private double vehicule_Vitesse;
    private int radar_Max_vitesse;
    private double montant;
    private  String date;
    private long id_Radar;
    private String matricule;
    private Radar radar;
}
