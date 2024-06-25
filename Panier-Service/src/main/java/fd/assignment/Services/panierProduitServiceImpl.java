package fd.assignment.Services;


import DTO.Entities.User.User;
import DTO.Entities.produit.produit;
import DTO.Entities.panier.panierProduit;
import fd.assignment.Repository.PanierProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fd.assignment.Clients.*;

import java.util.List;
import java.util.Optional;

@Service
public class panierProduitServiceImpl implements IPanierProduitService{
    @Autowired
    private PanierProduitRepository panierProdRepo;

    @Autowired
    private ProduitServiceClient produitServiceClient;

    @Autowired
    private UserServiceClient userServiceClient;

    @Override
    public panierProduit addProduit(panierProduit pp, Long idProduit, int quantity, Long id) {
        produit p = produitServiceClient.getProduitById(idProduit);
       User u = userServiceClient.getUserById(id);

        int addedQte = quantity;

        pp = panierProdRepo.findByUserAndProduit(u, p);
        if (pp != null) {
            addedQte = pp.getQuantity() + quantity;
            pp.setQuantity(addedQte);
            pp.setSomme(pp.getSomme() + (p.getPrix() * quantity));
        } else {
            pp = new panierProduit();
            pp.setQuantity(quantity);
       pp.setProduit(p);
            pp.setUser(u);
            pp.setSomme(p.getPrix() * quantity);
        }
        panierProdRepo.save(pp);
        return pp;
    }

    @Override
    public void removeProduit(User user, Long idProduit) {
        panierProdRepo.deleteByUserAndProduit(user.getId(), idProduit);
    }

    @Override
    public panierProduit updateQte(panierProduit pp) {
        panierProduit pproduit = panierProdRepo.findById(pp.getIdPanierProduit()).get();
        produit p = produitServiceClient.getProduitById(pp.getProduit().getIdProduit());

        pproduit.setQuantity(pp.getQuantity());
       pproduit.setSomme(p.getPrix() * pp.getQuantity());
   pproduit.setUser(pp.getUser());
        pproduit.setProduit(pp.getProduit());
        panierProdRepo.save(pproduit);
        return pproduit;
    }


    @Override
    public List<panierProduit> detailPanier(Long user_id) {
       User u = userServiceClient.getUserById(user_id);
        List<panierProduit> panier = panierProdRepo.findByUser(u);
        return panier;
    }


    @Override
    public panierProduit retrievePanierProduit(Long idPanierProduit) {
        return panierProdRepo.findById(idPanierProduit).orElse(null);
    }
}
