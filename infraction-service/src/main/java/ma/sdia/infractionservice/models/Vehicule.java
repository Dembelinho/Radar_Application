package ma.sdia.infractionservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @Builder @NoArgsConstructor
public class Vehicule {
    private String matricule;
    private String marque;
    private Float puissance;
    private String model;
    private Proprietaire proprietaire;
}
