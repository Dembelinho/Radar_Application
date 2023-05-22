package ma.sdia.radarservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Proprietaire {
    //son id, son nom, sa date de naissance, son email

    private long id;
    private String nom;
    private String date_naissance;
    private String email;
}
