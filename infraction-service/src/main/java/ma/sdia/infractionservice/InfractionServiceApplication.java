package ma.sdia.infractionservice;

import lombok.AllArgsConstructor;
import ma.sdia.infractionservice.entities.Infraction;
import ma.sdia.infractionservice.feignApi.RadarsRestClient;
import ma.sdia.infractionservice.feignApi.VehiculesRestClient;
import ma.sdia.infractionservice.models.Radar;
import ma.sdia.infractionservice.models.Vehicule;
import ma.sdia.infractionservice.repositories.InfractionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
@AllArgsConstructor
public class InfractionServiceApplication {
	VehiculesRestClient vehiculesRestClient;
	RadarsRestClient radarsRestClient;

	public static void main(String[] args) {
		SpringApplication.run(InfractionServiceApplication.class, args);
	}

	//@Bean
//	CommandLineRunner start(InfractionRepository infractionRepository){
//		return args -> {
//			Vehicule vehicule1=vehiculesRestClient.vehiculeByMatricule("696f5827-08c6-41e6-b7f5-581c3c8bf40c");
//			Radar radar=radarsRestClient.getRadarById(2L);
//
//			Random random=new Random();
//			Infraction infraction = Infraction.builder().id_Radar(2).radar(radar)
//					.date(String.valueOf(new Date())).radar_Max_vitesse(radar.getVitesse_Max())
//					.vehicule_Vitesse(200).vehicule(vehicule1).matricule(vehicule1.getMatricule())
//					.montant(random.nextInt(1000)).build();
//			infractionRepository.save(infraction);
//		};
//	}
}
