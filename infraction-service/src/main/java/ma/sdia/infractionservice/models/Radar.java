package ma.sdia.infractionservice.models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Radar {
    private Long id;
    private int vitesse_Max;
    private double Longitude , Latitude;
}
