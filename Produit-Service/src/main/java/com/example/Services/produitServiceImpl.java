package com.example.Services;

import DTO.Entities.User.User;
import DTO.Entities.produit.produit;
import DTO.Entities.stock.stock;
import com.example.Client.StockServiceClient;
import com.example.Client.UserServiceClient;
import com.example.Controller.ProduitRestController;
import com.example.Repository.produitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

@Service
public class produitServiceImpl {

    private static final Logger LOGGER = Logger.getLogger(ProduitRestController.class.getName());


    @Autowired

UserServiceClient  UserServiceClient;
     @Autowired
    StockServiceClient  StockServiceClient;



    @Autowired
    produitRepository produitrepo ;

    public produit getProductById(Long id) {
        return produitrepo.findByIdProduit(id);
    }

    public produit retrieveProduit(Long id) {
        // TODO Auto-generated method stub
        return produitrepo.findById(id).orElse(null);
    }



    public List<produit> retrieveAllProduits() {
        // TODO Auto-generated method stub
        return (List<produit>) produitrepo.findAll();
    }

    public produit updateProduit(produit p) {
        produit produit = produitrepo.findById(p.getIdProduit()).get();



        produit.setCategorieProduit(p.getCategorieProduit());

        produit.setLibelleProduit(p.getLibelleProduit());
        produit.setDescription(p.getDescription());
        produit.setImage(p.getImage());
        produit.setPrix(p.getPrix());




        produitrepo.save(p);
        return p;

    }


    public void deleteProduit(Long id) {
        // TODO Auto-generated method stub
        produitrepo.deleteById(id);

    }



    public List<produit> listAll(String keyword) {
        if (keyword != null) {
            return produitrepo.search(keyword);
        }
        return (List<produit>) produitrepo.findAll();
    }


    public List<produit> FindByIdUser(Long id) {
        return (List<produit>) produitrepo.findByIdUser(id);
    }

    public List<produit> findByIdstock(Long id) {
        // TODO Auto-generated method stub
        return (List<produit>) produitrepo.findByIdstock(id);
    }







	public produit addProduit(produit p,Long idStock, Long idUser) {
		stock stock = StockServiceClient.getStockById(idStock);
		User u = UserServiceClient.getUserById(idUser);
		
		
		String link = "https://www.youtube.com/embed/";		
		
        String url = p.getImage();
        
        url = url.substring(url.length()-11);
        
        link = link + url;
		       
		p.setStock(stock);
		p.setUser(u);
		p.setDateCreation(new Date());
		p.setImage(link);

		produitrepo.save(p);
	    return p;		
	}
	



	
	
	public void AssagnProductStock(Long idStock, Long idProduct) {
		
			stock st = StockServiceClient.getStockById(idStock);
			produit p = produitrepo.findById(idProduct).orElse(null);
			p.setStock(st); //cle etrangere
			produitrepo.save(p);
				
			
		}






		
}
