package com.sdia.Imatriculationservice.web;

import com.sdia.Imatriculationservice.entities.Proprietaire;
import com.sdia.Imatriculationservice.repositories.ProprietaireRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api")
public class ProprietaireRestController {
    private ProprietaireRepository proprietaireRepository;

    public ProprietaireRestController(ProprietaireRepository proprietaireRepository) {
        this.proprietaireRepository = proprietaireRepository;
    }

    @GetMapping("/proprietaires")
    public List<Proprietaire> getAllProprietaires(){
        return proprietaireRepository.findAll();
    }

    @GetMapping("/proprietaires/{id}")
    public Proprietaire getProprietaireById(@PathVariable Long id){
        return proprietaireRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Proprietaire %s not found",id)));
    }

    @PostMapping("/proprietaires")
    public Proprietaire save(@RequestBody Proprietaire proprietaire){
        return proprietaireRepository.save(proprietaire);
    }

    @PutMapping("/proprietaires/{id}")
    public Proprietaire update(@PathVariable Long id,@RequestBody Proprietaire proprietaire){
        Proprietaire proprietaire1 = proprietaireRepository.findById(id).get();
        proprietaire1.setDate_naissance(proprietaire.getDate_naissance());
        proprietaire1.setEmail(proprietaire.getEmail());
        proprietaire1.setNom(proprietaire.getNom());
        proprietaire1.setVehicules(proprietaire.getVehicules());
        return proprietaireRepository.save(proprietaire1);
    }

    @DeleteMapping ("/proprietaires/{id}")
    public void delete(@PathVariable Long id){
        proprietaireRepository.deleteById(id);
    }
}
