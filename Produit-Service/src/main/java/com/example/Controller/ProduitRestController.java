package com.example.Controller;


import DTO.Entities.User.User;
import DTO.Entities.produit.produit;
import DTO.Entities.stock.stock;
import com.example.Client.StockServiceClient;
import com.example.Services.*;
import com.example.helpers.ZXingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import com.example.Client.UserServiceClient;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;


@CrossOrigin(origins = "*", maxAge = 3600 )



@RestController
@RequestMapping("/produit")
public class ProduitRestController {
	private static final Logger LOGGER = Logger.getLogger(ProduitRestController.class.getName());

	@Autowired
    produitServiceImpl produitService;


	@Autowired
	UserServiceClient UserServiceClient;
	@Autowired
	StockServiceClient u;

	@GetMapping("/users/{id}")
	@ResponseBody
	public stock users(@PathVariable("id")Long id)
	{

		return u.getStockById(id);
	}




	//http://localhost:8080	/SpringMVC/produit/{id}
	@GetMapping("/{id}")
	public produit getProduitById(@PathVariable("id") Long idProduit) {

        return produitService.getProductById(idProduit);
	}

	//http://localhost:8080/SpringMVC/produit/retrieve-produit/{produit-id}
	@GetMapping("/retrieve-produit/{produit-id}")
	@ResponseBody
	public produit retrieveProduit(@PathVariable("produit-id") Long produitId) {
		LOGGER.info("Invoked getProduitById with ID: " + produitId);

		return produitService.retrieveProduit(produitId);
	}
	@GetMapping("/omi")
	@ResponseBody
	public String retrieveProduit1() {
return "omk";
	}

	// http://localhost:8080/SpringMVC/produit/retrieve-all-products
	@GetMapping("/retrieve-all-products")
	@ResponseBody
	public List<produit> getProduits() {
		List<produit> listProduits = produitService.retrieveAllProduits();
		return listProduits;
	}


	@RequestMapping(value = "barcode/{produit-id}", method = RequestMethod.GET)
	public void barcode(@PathVariable("produit-id") String produitId, HttpServletResponse response) throws Exception {
		response.setContentType("image/png");
		OutputStream outputStream = response.getOutputStream();
		outputStream.write(ZXingHelper.getBarCodeImage(produitId, 200, 200));
		outputStream.flush();
		outputStream.close();
	}

	//http://localhost:8080/SpringMVC/produit/remove-produit/{produit-id}
	@DeleteMapping("/remove-produit/{produit-id}")
	@ResponseBody
	public void removeProduit(@PathVariable("produit-id") Long produitId) {

		produitService.deleteProduit(produitId);




	}

	//http://localhost:8080/SpringMVC/produit/modify-produit
	@PutMapping("/modify-produit")
	@ResponseBody
	public produit updateProduit(@RequestBody produit p)
	{
		produit Produit = produitService.updateProduit(p);
		return Produit;
	}


	@GetMapping("/GetProduitByStockId/{stock-id}")
	@ResponseBody
	public List<produit> GetProduitByStockId(@PathVariable("stock-id") int id) {
		List<produit> listproduits = produitService.findByIdstock(Long.valueOf(id));
		return listproduits;
	}
	@RequestMapping("/")
	public String viewHomePage(Model model, @Param("keyword") String keyword) {
		List<produit> listProducts = produitService.listAll(keyword);
		model.addAttribute("listProducts", listProducts);
		model.addAttribute("keyword", keyword);

		return "index";
	}



	// http://localhost:8090/SpringMVC/produit/GetProduitByIdUser/{user-id}
	@GetMapping("/GetProduitByIdUser/{user-id}")
	@ResponseBody
	public List<produit> GetProduitByIdUser(@PathVariable("user-id") int id) {
		List<produit> listproduits = produitService.FindByIdUser(Long.valueOf(id));
		return listproduits;
	}















	
	


	

/*

	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("produit", produitService.retrieveAllProduits());
		return "produit/index";
	}

*/



	

	//http://localhost:8080/SpringMVC/produit/add-produit
	@PostMapping("/add-produit/{stock-id}/{user-id}")
	@ResponseBody
	public produit addProduit(@RequestBody produit p,@PathVariable("stock-id")Long idStock,@PathVariable("user-id")Long idUser)
	{	
        
		produit Produit = produitService.addProduit(p,idStock,idUser);

	    return Produit;
	}
	
	


	

	

	 
		// http://localhost:8089/SpringMVC/produit/AssagnProduitToStock/{idS}/{idP}
		@PutMapping("/AssagnProduitToStock/{idS}/{idP}")
		@ResponseBody
		public void AssagnProductStock(@PathVariable("idS")Long idStock,@PathVariable("idP") Long idProduct) {
			produitService.AssagnProductStock(idStock, idProduct);
		
		}


}
