package tn.esprit;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@EnableWebMvc
@SpringBootApplication
@EnableScheduling
@EnableFeignClients
@EntityScan(basePackages = { "DTO.Entities.User", "DTO.Entities.stock", "DTO.Entities.produit", "DTO.Entities.paiement", "DTO.Entities.panier", "DTO.Entities.Livraison,, DTO.Entities.Reclamation"})
@ComponentScan(basePackages = { "tn.esprit","DTO.Entities.User", "DTO.Entities.stock", "DTO.Entities.produit", "DTO.Entities.paiement", "DTO.Entities.panier", "DTO.Entities.Livraison", "DTO.Entities.Reclamation"})

public class ReclamationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReclamationApplication.class, args);
	}

}
