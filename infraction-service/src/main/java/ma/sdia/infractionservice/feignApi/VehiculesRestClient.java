package ma.sdia.infractionservice.feignApi;

import ma.sdia.infractionservice.models.Vehicule;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient (name = "imatriculation-service")
public interface VehiculesRestClient {
    @GetMapping(path = "/vehicules")
    List<Vehicule> getAllVehicules();

    @GetMapping(path ="/vehicules/{matricule}")
    Vehicule vehiculeByMatricule(@PathVariable String matricule);

    @GetMapping("/vehicules/{id}")
    Vehicule getVehiculeById(@PathVariable Long id);

}
