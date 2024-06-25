package fd.assignment.Services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;


import DTO.Entities.User.User;
import DTO.Entities.paiement.*;
import DTO.Entities.panier.panierProduit;


import fd.assignment.Repository.FactureRepository;
import fd.assignment.Repository.PaiementRepository;
import fd.assignment.Clients.UserServiceClient;
@Service 
public class factureServiceImpl implements IFactureService{
	
	@Autowired
	FactureRepository FactureRepo;
	
	@Autowired
	UserServiceClient UserRepo;
	
	@Autowired
	PaiementRepository PaiementRepo;

	@Override
	public List<facture> retrieveAllFacture() {
		// TODO Auto-generated method stub
		return (List<facture>) FactureRepo.findAll();
	}

	@Override
	public facture addFacture(facture f, Long idPaiement) {
		// TODO Auto-generated method stub
		paiement p = PaiementRepo.findById(idPaiement).orElse(null);
		f.setPaiement(p);
		f.setUser(p.getUser());
		f.setType(p.getNature());
		f.setEtat_livraison("Non Livré");
		f.setDate(new Date());
		FactureRepo.save(f);
		return f;
	}

	@Override
	public facture updateFacture(facture f) {
		// TODO Auto-generated method stub
		facture fa = FactureRepo.findById(f.getIdFacture()).orElse(null);
		fa.setType(f.getType());
		fa.setEtat_livraison(f.getEtat_livraison());
		return FactureRepo.save(f);
	}

	@Override
	public facture retrieveFacture(Long idFacture) {
		// TODO Auto-generated method stub
		return FactureRepo.findById(idFacture).orElse(null);
	}
	
	@Override
	public List<facture> retrieveFacturesByUser(Long idUser) {
		// TODO Auto-generated method stub
		User u = UserRepo.getUserById(idUser);
		List<facture> factures = FactureRepo.findByUser(u);
		return factures;
	}

	@Override
	public void removeFacture(Long idFacture) {
		// TODO Auto-generated method stub
		FactureRepo.deleteById(idFacture);
	}

	@Override
	public void imprimerFacture(Long idFacture) {
		// TODO Auto-generated method stub
		
	}
	
}
