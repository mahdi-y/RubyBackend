package fd.assignment.Clients;

import DTO.Entities.produit.produit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "produit-service", url = "http://localhost:8083/SpringMVC/produit")
public interface ProduitServiceClient {

    @GetMapping("/{id}")
    produit getProduitById(@PathVariable("id") Long id);
}
