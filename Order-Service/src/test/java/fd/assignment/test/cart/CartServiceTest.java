/*
package fd.assignment.test.cart;




import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fd.assignment.Repository.FactureRepository;
import fd.assignment.Services.factureServiceImpl;
import fd.assignment.Clients.PanierProduitServiceClient;
import DTO.Entities.paiement.*;
import DTO.Entities.panier.panierProduit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;





@SpringBootTest
@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
public class CartServiceTest {

	@Mock
	PanierProduitServiceClient ppr;





	panierProduit p;





	@Test
	public void testRetrieveCart() {

		panierProduit cart = new panierProduit(1L, 0, 0, null, null);

		cart.setIdPanierProduit(1L);

	p=ppr.getPanierProduitById(1L);

	Mockito.when(p);

		ppr.getPanierProduitById(1L);




	Assertions.assertNotNull(cart);

	System.out.println(cart);
	System.out.println(" Retrieve is working correctly...!!");

	}




*/
/*	@Test
	public void createCartTest()
	{

		panierProduit cart2 = new panierProduit(2L, 0, 0, null, null);

		cart2.setIdPanierProduit(2L);

		pps.addProduit(cart2, null, 0, 1L);

		verify(ppr, times(1)).save(cart2);
		System.out.println(cart2);
		System.out.println(" Create is working correctly...!!");
	}
	*//*






}*/
