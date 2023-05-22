package ma.sdia.infractionservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class NewInfraction {
    long id_Radar;
    String matricule;
    double vehicule_Vitesse;
}
