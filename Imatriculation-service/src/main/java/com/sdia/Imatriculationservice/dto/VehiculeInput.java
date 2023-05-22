package com.sdia.Imatriculationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehiculeInput{
    private String matricule;
    private String marque;
    private Float puissance;
    private String model;
    private ProprietaireInput proprietaire;
}
