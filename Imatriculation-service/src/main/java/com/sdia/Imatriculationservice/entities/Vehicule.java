package com.sdia.Imatriculationservice.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String matricule;
    private String marque;
    private Float puissance;
    private String model;
    @ManyToOne
    private Proprietaire proprietaire;
}
