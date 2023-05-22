package com.sdia.Imatriculationservice.web;

import com.sdia.Imatriculationservice.dto.VehiculeInput;
import com.sdia.Imatriculationservice.entities.Vehicule;
import com.sdia.Imatriculationservice.mappers.VehiculeMapper;
import com.sdia.Imatriculationservice.repositories.VehiculeRepository;
import com.sdia.Imatriculationservice.services.VehiculeService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Random;

@Controller
public class VehiculeGraphQLController {
    VehiculeMapper vehiculeMapper;
    @Autowired
    private VehiculeRepository vehiculeRepository;
    @Autowired
    private VehiculeService vehiculeService;

    public VehiculeGraphQLController(VehiculeRepository vehiculeRepository, VehiculeService vehiculeService) {
        this.vehiculeRepository = vehiculeRepository;
        this.vehiculeService = vehiculeService;
    }

    @QueryMapping
    public List<Vehicule> getVehicules(){
        return vehiculeRepository.findAll();
    }

    // - Read by id
    @QueryMapping("getVehicule")
    public Vehicule getVehiculeById(@Argument Long id){
        return vehiculeRepository.findById(id).get();
    }

    @MutationMapping
    public Vehicule saveVehicule(@Argument VehiculeInput vehiculeInput){
        Vehicule vehicule = vehiculeMapper.fromVehiculeInput(vehiculeInput);
        return vehiculeRepository.save(vehicule);
    }

    @MutationMapping
    public Vehicule updateVehicule(Long id,VehiculeInput vehiculeInput){
        return vehiculeService.updateVehicule(id,vehiculeMapper.fromVehiculeInput(vehiculeInput));
    }

    @MutationMapping
    public Boolean deleteVehicule(Long id){
        vehiculeRepository.deleteById(id);
        return true;
    }
}


