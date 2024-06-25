package fd.assignment.Services;

import java.util.List;

import DTO.Entities.panier.panierProduit;
import DTO.Entities.paiement.paiement;

public interface IPaiementService {

	List<paiement> retrieveAllPaiement();
	
	List<paiement> retrievePaiementByUser(Long id);

	paiement retrievePaiement(Long id);

	paiement addPaiement(paiement pa, Long id);

	List<panierProduit> detailPanier(Long paiement_id);
	
}