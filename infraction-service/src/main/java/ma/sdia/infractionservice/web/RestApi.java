package ma.sdia.infractionservice.web;

import lombok.AllArgsConstructor;
import ma.sdia.infractionservice.entities.Infraction;
import ma.sdia.infractionservice.feignApi.RadarsRestClient;
import ma.sdia.infractionservice.feignApi.VehiculesRestClient;
import ma.sdia.infractionservice.models.NewInfraction;
import ma.sdia.infractionservice.models.Radar;
import ma.sdia.infractionservice.models.Vehicule;
import ma.sdia.infractionservice.repositories.InfractionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@AllArgsConstructor
public class RestApi {
    private InfractionRepository infractionRepository;
    private VehiculesRestClient vehiculesRestClient;
    private RadarsRestClient radarsRestClient;


    @GetMapping("/infractions")
    public List<Infraction> getAllInfractions(){
        List<Infraction> infractionList = infractionRepository.findAll();
        infractionList.forEach(infraction -> {
            Vehicule vehicule=vehiculesRestClient.vehiculeByMatricule(infraction.getMatricule());
            Radar radar=radarsRestClient.getRadarById(infraction.getId_Radar());
            infraction.setVehicule(vehicule);
            infraction.setRadar(radar);
        });
        return infractionList;
    }
    @PostMapping("/infractions/add")
    public Infraction addInfraction(@RequestBody NewInfraction newInfraction){
        Vehicule vehicule=vehiculesRestClient.vehiculeByMatricule(newInfraction.getMatricule());
        Radar radar=radarsRestClient.getRadarById(newInfraction.getId_Radar());
        Random random=new Random();
        Infraction infraction=Infraction.builder().vehicule_Vitesse(newInfraction.getVehicule_Vitesse())
                .date(String.valueOf(new Date())).radar(radar).id_Radar(newInfraction.getId_Radar())
                .montant(random.nextInt(1000)).matricule(newInfraction.getMatricule()).vehicule(vehicule)
                .radar_Max_vitesse(radar.getVitesse_Max()).build();
        return infractionRepository.save(infraction);
    }
}
