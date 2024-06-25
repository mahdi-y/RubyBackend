/*
package fd.assignment.test.Bills;




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
import fd.assignment.Repository.PaiementRepository;
import fd.assignment.Services.factureServiceImpl;
import fd.assignment.Services.paiementServiceImpl;
import fd.assignment.Entities.facture;
import fd.assignment.Entities.paiement;

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
public class BillsServiceTest {
	
	@Mock
	FactureRepository br;
	
	@Mock
	PaiementRepository pr;
	
	@InjectMocks
	factureServiceImpl bs;
	
	@InjectMocks
	paiementServiceImpl ps;
	

	
	
	@Test
	public void testRetrieveBill() {
		
		facture bill = new facture(1L, null, "ach","aaa",null, null);
		bill.setIdFacture(1L);
		
	Mockito.when(br.findById(1L)).thenReturn(Optional.of(bill));

	bs.retrieveFacture(1L);
	Assertions.assertNotNull(bill);
	
	System.out.println(bill); 
	System.out.println(" Retrieve is working correctly...!!");  
	
	}
	
	
	
	
*/
/*	@Test
	public void createBillTest()
	{

		facture bill2 = new facture(1L, null, "ach","aaa",null, null);
		paiement payment = new paiement(1L, null, null, 0, 0, 0, null, null, null);
		
		bill2.setIdFacture(2L);

		payment.setIdPaiement(1L);

		bs.addFacture(bill2, 1L);
		verify(br, times(1)).save(bill2);
		System.out.println(bill2); 
		System.out.println(" Create is working correctly...!!");  
	}
	*//*

	
	
	
	
	
	
	@Test
	public void getAllSecteursTest()
	{
		List<facture> BillList = new ArrayList<facture>() {

			{
		add(new facture(3L, null, "ach","aaa",null, null));
		add(new facture(4L, null, "ach","aaa",null, null));
		add(new facture(5L, null, "ach","aaa",null, null));
			}};
			
			
		when(bs.retrieveAllFacture()).thenReturn(BillList);
		//test
		List<facture> sList = bs.retrieveAllFacture();
		assertEquals(3, sList.size());
		System.out.println(" Retrieve all is working correctly...!!");  
	
	}
	

	
	
	@Test
	public void TestDeleteSecteur(){

	facture bill3 = new facture(2L, null,"bbbb","no",null, null);

	bill3.setIdFacture(2L);
	
	Mockito.lenient().when(br.findById(bill3.getIdFacture())).thenReturn(Optional.of(bill3));

	bs.removeFacture(2L);
	verify(br).deleteById(bill3.getIdFacture());
	
	System.out.println(bill3);
	System.out.println(" Delete is working correctly...!!");  
	}
	
	
	
	
}*/
