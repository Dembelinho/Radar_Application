package com.sdia.Imatriculationservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder @ToString
public class Proprietaire {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String date_naissance;
    private String nom;
    @OneToMany(mappedBy = "proprietaire")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Vehicule> vehicules;
    //   private Collection<Vehicule> vehicules;
}
