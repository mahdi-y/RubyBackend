package fd.assignment;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;



@EnableWebMvc
@SpringBootApplication
@EnableScheduling
@EnableFeignClients
@EntityScan(basePackages = { "DTO.Entities.User", "DTO.Entities.stock", "DTO.Entities.produit", "DTO.Entities.panier", "DTO.Entities.paiement"})


public class PanierApplication {

	public static void main(String[] args) {
		SpringApplication.run(PanierApplication.class, args);
	}

}
