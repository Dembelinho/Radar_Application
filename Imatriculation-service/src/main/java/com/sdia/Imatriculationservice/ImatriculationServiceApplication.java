package com.sdia.Imatriculationservice;

import com.sdia.Imatriculationservice.entities.Proprietaire;
import com.sdia.Imatriculationservice.entities.Vehicule;
import com.sdia.Imatriculationservice.repositories.ProprietaireRepository;
import com.sdia.Imatriculationservice.repositories.VehiculeRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication @AllArgsConstructor
public class ImatriculationServiceApplication {
	RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(com.sdia.Imatriculationservice.ImatriculationServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(VehiculeRepository vehiculeRepository,ProprietaireRepository proprietaireRepository){
		repositoryRestConfiguration.exposeIdsFor(VehiculeRepository.class); //This configuration is useful when you want the IDs of your entities to be visible and accessible in the REST API responses. Without this configuration, Spring Data REST hides the entity IDs by default.
		return args -> {
			Stream.of("Ayoub","Amine","Messi","PELE").forEach(p->{
				Proprietaire proprietaire= Proprietaire.builder().nom(p)
						.email(p+"@gmail.com").date_naissance(new Date().toString()).build();
				proprietaireRepository.save(proprietaire);
			});
			proprietaireRepository.findAll().forEach(proprietaire -> {
				for(int i=0; i<3 ;i++){
					Vehicule vehicule= Vehicule.builder()
							.proprietaire(proprietaire).model("C250")
							.matricule(UUID.randomUUID().toString())
							.marque("Mercedes").puissance(800F)
							.build();
					vehiculeRepository.save(vehicule);
				}
			});
		};
	}
}
