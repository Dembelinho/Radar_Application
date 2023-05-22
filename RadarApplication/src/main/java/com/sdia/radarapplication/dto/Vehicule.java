package com.sdia.radarapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Vehicule {
    private long id;
    private String matricule;
    private String marque;
    private String modele;
    private Float puissance;
    private Proprietaire proprietaire;
}
