package fd.assignment.Repository;

import java.util.List;

import DTO.Entities.User.User;
import DTO.Entities.produit.produit;
import DTO.Entities.panier.panierProduit;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface PanierProduitRepository extends CrudRepository<panierProduit, Long> {


	List<panierProduit> findByUser(User user);

	panierProduit findByUserAndProduit(User user, produit Produit);

	@Query("DELETE FROM panierProduit pp ")
	@Modifying
	void deleteByUserAndProduit(Long id, Long idProduit);




}