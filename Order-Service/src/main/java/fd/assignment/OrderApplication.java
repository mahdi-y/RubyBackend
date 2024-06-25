package fd.assignment;


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
@EntityScan(basePackages = {"fd.assignment.Entities", "DTO.Entities.User", "DTO.Entities.stock", "DTO.Entities.produit", "DTO.Entities.paiement", "DTO.Entities.panier"})
@ComponentScan(basePackages = {"fd.assignment", "DTO.Entities.User", "DTO.Entities.stock", "DTO.Entities.produit", "DTO.Entities.paiement", "DTO.Entities.panier"})
@EnableFeignClients(basePackages = "fd.assignment.Clients")

public class OrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

}
