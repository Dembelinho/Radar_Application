package com.sdia.Imatriculationservice.repositories;

import com.sdia.Imatriculationservice.entities.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;


//@RepositoryRestResource //Spring va démarrer Un WS Restfull qui va gérer les Vehicules

public interface VehiculeRepository extends JpaRepository<Vehicule,Long> {

    //@RestResource(path = "/byMatricule")
   // List<Vehicule> findByMatricule(String matricule);

    @Query("select v from Vehicule v where (v.matricule like :matricule) ")
    Vehicule searchVehiculeByMatricule(@Param("matricule") String matricule);

    @Query("select v from Vehicule v where (v.marque like :marque) ")
    List<Vehicule> searchVehiculeByMarque(@Param("marque") String marque);
}
