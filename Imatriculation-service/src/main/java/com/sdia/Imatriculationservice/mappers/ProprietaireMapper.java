package com.sdia.Imatriculationservice.mappers;

import com.sdia.Imatriculationservice.dto.ProprietaireInput;
import com.sdia.Imatriculationservice.dto.VehiculeInput;
import com.sdia.Imatriculationservice.entities.Proprietaire;
import com.sdia.Imatriculationservice.entities.Vehicule;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ProprietaireMapper {
    Random random = new Random();

    public ProprietaireInput fromProprietaire(Proprietaire proprietaire){
        ProprietaireInput proprietaireInput=new ProprietaireInput();
        BeanUtils.copyProperties(proprietaire,proprietaireInput);
        return proprietaireInput;
    }

    public Proprietaire fromProprietaireInput(ProprietaireInput proprietaireInput){
        Vehicule vehicule=new Vehicule();
        Proprietaire proprietaire= Proprietaire.builder().build();
        proprietaire.setId(random.nextLong());
        BeanUtils.copyProperties(proprietaireInput,proprietaire);
        return proprietaire;
    }
}
