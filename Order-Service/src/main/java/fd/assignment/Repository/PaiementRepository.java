package fd.assignment.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import DTO.Entities.User.User;
import DTO.Entities.paiement.*;
import DTO.Entities.produit.produit;

@Repository
public interface PaiementRepository extends CrudRepository<paiement, Long> {
	
	List<paiement> findByUser(User user);

}