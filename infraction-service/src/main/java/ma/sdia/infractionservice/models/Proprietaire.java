package ma.sdia.infractionservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data  @AllArgsConstructor @Builder @NoArgsConstructor
public class Proprietaire {
    private Long id;
    private String email;
    private String date_naissance;
    private String nom;
}
