package fd.assignment.Services;

import java.util.List;

import DTO.Entities.User.User;
import DTO.Entities.produit.produit;
import DTO.Entities.panier.panierProduit;

public interface IPanierProduitService {
	
	
	
//	panierProduit updateQte(Long idProduit, int quantity, Long id);

	//panierProduit addProduit(Long idProduit, int quantity, Long id);

	List<panierProduit> detailPanier(Long user_id);

	void removeProduit(User user, Long idProduit);

//	panierProduit updateQte(panierProduit pp, int quantity);

	panierProduit updateQte(panierProduit pp);

	panierProduit retrievePanierProduit(Long idPanierProduit);

	panierProduit addProduit(panierProduit pp, Long idProduit, int quantity, Long id);
	
}