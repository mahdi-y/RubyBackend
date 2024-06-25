package fd.assignment.Services;


import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import DTO.Entities.stock.stock;

import java.util.List;

public interface IStockService {
	
	List<stock> retrieveAllStock();

	stock addStock (stock s);

	void deleteStock (Long id);

	stock updateStock (stock s);

	stock retrieveStock (Long id);	
	
	List<stock> listAll(String keyword);
	
	void status() throws MessagingException, IOException;

}
