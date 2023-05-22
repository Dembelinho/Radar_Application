package com.sdia.Imatriculationservice.web;

import com.sdia.Imatriculationservice.entities.Vehicule;
import com.sdia.Imatriculationservice.repositories.VehiculeRepository;
import com.sdia.Imatriculationservice.services.VehiculeService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
//@RequestMapping("/api")
public class VehiculeRestController {
    private VehiculeRepository vehiculeRepository;
    private VehiculeService vehiculeService;

    public VehiculeRestController(VehiculeRepository vehiculeRepository, VehiculeService vehiculeService) {
        this.vehiculeRepository = vehiculeRepository;
        this.vehiculeService = vehiculeService;
    }

    @GetMapping("/vehicules")
    public List<Vehicule> getAllVehicules(){
        return vehiculeRepository.findAll();
    }

    @GetMapping("/vehicules/{id}")
    public Vehicule getVehiculeById(@PathVariable Long id){
        return vehiculeRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Vehicule %s not found",id)));
    }

    @GetMapping("/vehicules/{matricule}")
    public Vehicule vehiculeByMatricule(@PathVariable String matricule){
        return vehiculeRepository.searchVehiculeByMatricule(matricule);
    }

    @GetMapping("/vehicules/{marque}")
    public List<Vehicule> vehiculeByMarque(@PathVariable String marque){
        return vehiculeRepository.searchVehiculeByMarque(marque);
    }

    @PostMapping("/vehicules")
    public Vehicule save(@RequestBody Vehicule vehicule){
        return vehiculeRepository.save(vehicule);
    }

    @PutMapping("/vehicules/{id}")
    public Vehicule update(@PathVariable Long id,@RequestBody Vehicule vehicule){
        return vehiculeService.updateVehicule(id, vehicule);
    }

    @DeleteMapping ("/vehicules/{id}")
    public void delete(@PathVariable Long id){
        vehiculeRepository.deleteById(id);
    }
}
