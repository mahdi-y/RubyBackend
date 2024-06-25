package fd.assignment.Services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import DTO.Entities.User.User;
import DTO.Entities.paiement.*;
import DTO.Entities.stock.stock;
import DTO.Entities.panier.panierProduit;

import fd.assignment.Repository.PaiementRepository;

import fd.assignment.Clients.*;



@Service 
public class paiementServiceImpl implements IPaiementService{
	
	@Autowired
	PanierProduitServiceClient PanierProdRepo;
	
	@Autowired
	UserServiceClient UserRepo;
	
	@Autowired
	PaiementRepository PaiRepo;
	
	@Autowired
	StockServiceClient StockRepo;
	
	@Override
	public List<paiement> retrieveAllPaiement() {
		// TODO Auto-generated method stub
		return (List<paiement>) PaiRepo.findAll();
	}

	@Override
	public paiement addPaiement(paiement pa, Long id) {
		// TODO Auto-generated method stub
		User u = UserRepo.getUserById(id);
		List<panierProduit> produits = PanierProdRepo.getPanierByUserId(u.getId());
		pa.setNature(pa.getNature());
		pa.setSommetotal(pa.getSommetotal());
		pa.setDate(new Date());
		pa.setCard(pa.getCard());
		pa.setCvc(pa.getCvc());
		pa.setExp(pa.getExp());
		pa.setUser(u);
		pa.setProduits(produits);
		PaiRepo.save(pa);
		return pa;
	}

	@Override
	public paiement retrievePaiement(Long idPaiement) {
		// TODO Auto-generated method stub
		return PaiRepo.findById(idPaiement).orElse(null);
	}
	
	
	@Override
	public List<paiement> retrievePaiementByUser(Long id) {
		// TODO Auto-generated method stub
	User u = UserRepo.getUserById(id);
		return PaiRepo.findByUser(u);
	}
	
	@Override
	public List<panierProduit> detailPanier(Long paiement_id) {
		paiement p = PaiRepo.findById(paiement_id).get();
		List<panierProduit> panier = p.getProduits();
		return panier;
	}

	
}