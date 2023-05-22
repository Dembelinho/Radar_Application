package com.sdia.Imatriculationservice.repositories;

import com.sdia.Imatriculationservice.entities.Proprietaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource
public interface ProprietaireRepository extends JpaRepository<Proprietaire,Long> {

    @Query("select p from Proprietaire p where p.id = :id")
    Proprietaire findProprietaireById(@Param("id") long id);

    @Query("select p from Proprietaire p where (p.nom = :nom)")
    Proprietaire findProprietaireByNom(@Param("nom")String nom);

}
