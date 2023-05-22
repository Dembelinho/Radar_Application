package com.sdia.radarapplication.service;

import com.sdia.radarapplication.dto.NewInfraction;
import com.sdia.radarapplication.dto.Radar;
import com.sdia.radarapplication.dto.Vehicule;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Data
@AllArgsConstructor
@Service
public class RestApi {
    private RestTemplate restTemplate;
    public Radar[] getAllRadars(){
        String url="http://localhost:8888/RADAR-SERVICE/radars";
        Radar[] radar = restTemplate.getForObject(url, Radar[].class);
        System.out.println(radar.length);
        return radar;
    }
    public Vehicule[] getAllVehicules(){
        String url="http://localhost:8888/IMATRICULATION-SERVICE/vehicules";
        Vehicule[] vehicles= restTemplate.getForObject(url,Vehicule[].class);
        return vehicles;
    }
    public boolean sendInfraction(NewInfraction newInfraction){
        String url="http://localhost:8888/RADAR-SERVICE/newInfraction";
        Boolean result = restTemplate.postForObject(url, newInfraction, Boolean.class);
        return result;
    }
}
