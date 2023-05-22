package com.sdia.radarapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Radar {
    private Long id;
    private int vitesse_Max;
    private double Longitude , Latitude;

}
