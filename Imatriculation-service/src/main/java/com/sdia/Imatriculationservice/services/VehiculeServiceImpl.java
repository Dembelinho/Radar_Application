package com.sdia.Imatriculationservice.services;

import com.sdia.Imatriculationservice.entities.Vehicule;
import com.sdia.Imatriculationservice.repositories.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class VehiculeServiceImpl implements VehiculeService{
    @Autowired
    private VehiculeRepository vehiculeRepository;

    @Override
    public Vehicule updateVehicule(Long id, Vehicule vehicule) {
        Vehicule vehicule1 = vehiculeRepository.findById(id).orElseThrow();
        vehicule1.setMarque(vehicule.getMarque());
        vehicule1.setModel(vehicule.getModel());
        vehicule1.setPuissance(vehicule.getPuissance());
        vehicule1.setProprietaire(vehicule.getProprietaire());
        vehicule1.setMatricule(vehicule.getMatricule());
        vehiculeRepository.save(vehicule1);
        return vehicule1;
    }
}
