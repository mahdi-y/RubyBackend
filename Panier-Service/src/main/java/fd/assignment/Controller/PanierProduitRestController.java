package fd.assignment.Controller;

import java.io.OutputStream;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import fd.assignment.Clients.ProduitServiceClient;
import fd.assignment.Clients.UserServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import DTO.Entities.User.User;
import DTO.Entities.produit.produit;
import DTO.Entities.panier.panierProduit;

import fd.assignment.Services.IPanierProduitService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/panierproduit")
public class PanierProduitRestController {


    @Autowired
    private ProduitServiceClient produitServiceClient;

    @Autowired
    private UserServiceClient userServiceClient;

    @Autowired
    private IPanierProduitService panierProduitService;

    @PostMapping("/addToPanier/{produit-id}/{qte}/{user-id}")
    public panierProduit addToPanier(@RequestBody panierProduit pp,
                                     @PathVariable("produit-id") Long produitId,
                                     @PathVariable("qte") int quantity,
                                     @PathVariable("user-id") Long userId) {

        // Fetch produit details from produit-service using Feign client
        produit produit = produitServiceClient.getProduitById(produitId);

        // Fetch user details from user-service using Feign client
       User user = userServiceClient.getUserById(userId);

        // Add the produit to panierProduit

  pp.setProduit(produit);
        pp.setUser(user);

        pp.setQuantity(quantity);

        // Save panierProduit using the service
        panierProduitService.addProduit(pp,produitId,quantity,userId);

        return pp;
    }

    @GetMapping("/getPanier/{user-id}")
    public List<panierProduit> getPanier(@PathVariable("user-id") Long userId) {
      User user = userServiceClient.getUserById(userId);
        return panierProduitService.detailPanier(user.getId());
    }

    @GetMapping("/produit/{id}")
    public produit getproduit(@PathVariable("id") Long id) {

        return produitServiceClient.getProduitById(id);
    }

    @GetMapping("/{id}")
    public panierProduit getPanier1(@PathVariable("id") Long id) {

        return panierProduitService.retrievePanierProduit(id);
    }

    @GetMapping("/getPanierProduit/{panierproduit-id}")
    public panierProduit getPanierProduit(@PathVariable("panierproduit-id") Long panierProduitId) {
        return panierProduitService.retrievePanierProduit(panierProduitId);
    }

    @PutMapping("/updateQuantity")
    public panierProduit updateQuantity(@RequestBody panierProduit pp) {
        return panierProduitService.updateQte(pp);
    }

    @DeleteMapping("/removeFromPanier/{user-id}/{produit-id}")
    public void removeFromPanier(@PathVariable("user-id") Long userId,
                                 @PathVariable("produit-id") Long produitId) {
      User user = userServiceClient.getUserById(userId);
        panierProduitService.removeProduit(user, produitId);
    }



}

