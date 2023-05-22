package com.sdia.radarapplication;

import com.sdia.radarapplication.dto.NewInfraction;
import com.sdia.radarapplication.dto.Radar;
import com.sdia.radarapplication.dto.Vehicule;
import com.sdia.radarapplication.service.RestApi;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

@SpringBootApplication @AllArgsConstructor
public class RadarApplication implements CommandLineRunner {
    private RestApi restTempServices;

    public static void main(String[] args) {
        SpringApplication.run(RadarApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        TimerTask task=new TimerTask() {
            @Override
            public void run() {
                //getAllRadars
                Radar[] allRadars = restTempServices.getAllRadars();
                //getAllVehicles
                Vehicule[] allVehicules = restTempServices.getAllVehicules();

                Random random=new Random();
                //randomIndexes
                int indxRadar = random.nextInt(allRadars.length);
                int indxVehicle = random.nextInt(allVehicules.length);

                Radar selectedRadar=allRadars[indxRadar];
                Vehicule selectedVehicle=allVehicules[indxVehicle];

                //Generate Random Vitesse
                double vehicule_Vitesse=random.nextDouble(selectedRadar.getVitesse_Max(),
                        selectedRadar.getVitesse_Max()+random.nextInt(100));

                //send New Infraction
                NewInfraction newInfraction = NewInfraction.builder().id_Radar(selectedRadar.getId())
                        .matricule(selectedVehicle.getMatricule())
                        .vehicule_Vitesse(vehicule_Vitesse).build();
                boolean results = restTempServices.sendInfraction(newInfraction);
                System.out.println(results);

            }
        };
        Timer timer=new Timer("Waiting....");
        timer.scheduleAtFixedRate(task,0,15000L);
    }
}
