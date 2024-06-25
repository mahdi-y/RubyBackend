package tn.esprit.Clients;

import DTO.Entities.paiement.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "Order-service", url = "http://localhost:8084/SpringMVC/facture") // Specify base URL here
public interface FactureServiceClient {

    @GetMapping("/retrieve-facture/{facture-id}")
    public facture retrieveFacture(@PathVariable("facture-id") Long factureId);


}
