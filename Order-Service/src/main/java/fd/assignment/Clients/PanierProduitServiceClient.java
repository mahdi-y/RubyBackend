package fd.assignment.Clients;

import DTO.Entities.panier.panierProduit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "panier-service", url = "http://localhost:8082/SpringMVC/panierproduit")
public interface PanierProduitServiceClient {

    @GetMapping("/{id}")
    panierProduit getPanierProduitById(@PathVariable("id") Long id);

    @GetMapping("/getPanier/{id}")
    List<panierProduit> getPanierByUserId(@PathVariable("id") Long id);
}
