package com.sdia.radarapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Proprietaire {
    private long id;
    private String nom;
    private String date_naissance;
    private String email;
}
