package tn.esprit.Services;

import DTO.Entities.Livraison.Livraison;
import DTO.Entities.Reclamation.Reclamation;

public interface IReclamationService {
	
	Iterable<Reclamation> retrieveAllReclamations();

	Reclamation addReclamation(Reclamation rec,Long idUser,Long idLivraison);

	Reclamation updateReclamation(Reclamation rec);

	Reclamation retrieveReclamation(Long idReclamation);

	void removeReclamation(Long idReclamation);
	
	void assignReclamationToUser(Long id,Long idReclamation);
	
	void assignReclamationToLivraison(Long idLivraison,Long idReclamation);
	
	void traiterReclamation1();
	
	void traiterReclamation2();
	
	void traiterReclamation3();

	Livraison omk(Long idReclamation);
}
