package com.sdia.Imatriculationservice.mappers;

import com.sdia.Imatriculationservice.dto.VehiculeInput;
import com.sdia.Imatriculationservice.entities.Vehicule;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class VehiculeMapper {
    Random random = new Random();

    public VehiculeInput fromVehicule(Vehicule vehicule){
        VehiculeInput vehiculeInput=new VehiculeInput();
        BeanUtils.copyProperties(vehicule,vehiculeInput);
        return vehiculeInput;
    }

    public Vehicule fromVehiculeInput(VehiculeInput vehiculeInput){
        Vehicule vehicule=new Vehicule();
        vehicule.setId(random.nextLong());
        BeanUtils.copyProperties(vehiculeInput,vehicule);
        return vehicule;
    }
}
