package tn.esprit.Clients;

import DTO.Entities.Livraison.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "Livraison-service", url = "http://localhost:8086/SpringMVC/Livraison") // Specify base URL here
public interface LivraisonServiceClient {

    @GetMapping("/retrieve-Livraison/{Livraison-id}")
    Livraison retrieveLivraison(@PathVariable("Livraison-id") Long idLivraison);

}
