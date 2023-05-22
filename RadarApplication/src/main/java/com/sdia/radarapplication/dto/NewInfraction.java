package com.sdia.radarapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewInfraction {
    long id_Radar;
    String matricule;
    double vehicule_Vitesse;
}
