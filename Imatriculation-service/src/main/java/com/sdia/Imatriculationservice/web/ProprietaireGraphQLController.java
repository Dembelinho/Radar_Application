package com.sdia.Imatriculationservice.web;

import com.sdia.Imatriculationservice.dto.ProprietaireInput;
import com.sdia.Imatriculationservice.dto.VehiculeInput;
import com.sdia.Imatriculationservice.entities.Proprietaire;
import com.sdia.Imatriculationservice.entities.Vehicule;
import com.sdia.Imatriculationservice.mappers.ProprietaireMapper;
import com.sdia.Imatriculationservice.repositories.ProprietaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProprietaireGraphQLController {
    ProprietaireMapper proprietaireMapper;
    @Autowired
    private ProprietaireRepository proprietaireRepository;

    public ProprietaireGraphQLController(ProprietaireRepository proprietaireRepository) {
        this.proprietaireRepository = proprietaireRepository;
    }

    @QueryMapping
    public List<Proprietaire> getProprietaires(){
        return proprietaireRepository.findAll();
    }

    @QueryMapping("getProprietaire")
    public Proprietaire getProprietaireById(@Argument Long id){
        return proprietaireRepository.findById(id).get();
    }

    @MutationMapping
    public Proprietaire saveProprietaire(@Argument ProprietaireInput proprietaireInput){
        Proprietaire proprietaire = proprietaireMapper.fromProprietaireInput(proprietaireInput);
        return proprietaireRepository.save(proprietaire);
    }

    @MutationMapping
    public Proprietaire updateProprietaire(@Argument Long id,ProprietaireInput proprietaireInput){
        proprietaireRepository.deleteById(id);
        Proprietaire proprietaire = proprietaireMapper.fromProprietaireInput(proprietaireInput);
        proprietaire.setId(id);
        return proprietaireRepository.save(proprietaire);
    }

    @MutationMapping
    public Boolean deleteProprietaire(@Argument Long id){
        proprietaireRepository.deleteById(id);
        return true;
    }
}
