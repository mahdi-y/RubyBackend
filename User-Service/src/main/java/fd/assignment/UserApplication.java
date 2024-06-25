package fd.assignment;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;



@EnableWebMvc
@SpringBootApplication
@EnableScheduling
@EntityScan(basePackages = { "DTO.Entities.User", "DTO.Entities.stock", "DTO.Entities.produit"})
@ComponentScan(basePackages = {"fd.assignment", "DTO.Entities.User", "DTO.Entities.stock", "DTO.Entities.produit"})

public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

}
