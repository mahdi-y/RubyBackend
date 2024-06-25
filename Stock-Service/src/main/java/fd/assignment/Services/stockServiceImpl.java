package fd.assignment.Services;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import DTO.Entities.produit.produit;
import DTO.Entities.stock.stock;

import fd.assignment.Repository.stockRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Slf4j

@Service
public class stockServiceImpl implements IStockService{
	
	
	@Autowired
	stockRepository StockRepo;


	@Autowired
	private JavaMailSender javaMailSender;
	
	
	
	

	@Override
	public List<stock> retrieveAllStock() {
		// TODO Auto-generated method stub
		return (List<stock>) StockRepo.findAll();
	}

	@Override
	public stock addStock(stock c) {
		StockRepo.save(c);
		return c;
	}

	@Override
	public void deleteStock(Long id) {
		StockRepo.deleteById(id);
		
	}

	@Override
	public stock retrieveStock(Long id) {
		
		return StockRepo.findById(id).orElse(null);
	}

	@Override
	public stock updateStock(stock s) {
		stock stock = StockRepo.findById(s.getIdStock()).get();
		stock.setLibelleStock(s.getLibelleStock());
		stock.setQuantite(s.getQuantite());
		stock.setSupplier_name(s.getSupplier_name());
		stock.setSupplier_mail(s.getSupplier_mail());
	
		return StockRepo.save(stock);
	}


	@Override
	public List<stock> listAll(String keyword) {
		if (keyword != null) {
			return StockRepo.search(keyword);
		}
		return (List<stock>) StockRepo.findAll();
	}
	
	
	
	@Bean
	public JavaMailSender getJavaMailSender() {
	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	    mailSender.setHost("smtp.gmail.com");
	    mailSender.setPort(587);
	    
	    mailSender.setUsername("ah.sass.nas@gmail.com");
	    mailSender.setPassword("anas21541416");
	    
	    Properties props = mailSender.getJavaMailProperties();
	    props.put("mail.transport.protocol", "smtp");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.debug", "true");
	    
	    return mailSender;
	}
	
	
	

	//@Scheduled(cron = "*/15 * * * * *")
	@Override
	public void status() throws MessagingException, IOException{
		SimpleMailMessage msg = new SimpleMailMessage();
		MimeMessage msgHtml = javaMailSender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(msgHtml, true);
	
		
		 List<stock> stocks= (List<stock>)StockRepo.findAll();
		 
	        if(stocks!=null) {
	        for (stock stock : stocks){
	        	
	            if (stock.getQuantite()<=stock.getQuantiteMin()){
	            	
	            	//msg.setTo("nourmrad171199@gmail.com", "nourmrad171199@gmail.com");
	            	//msg.setTo(stock.getSupplier_mail(), stock.getSupplier_mail());
	            	helper.setTo(stock.getSupplier_mail());
	            	
	               // msg.setSubject("Stock almost out!!!!");
	            	helper.setSubject("Stock almost out!");
	            	
	               // msg.setText("Monsieur "+stock.getSupplier_name()+" produit "+ stock.getLibelleStock()+" est epuisé ");
	                helper.setText("<h3>Dear sir/miss "+stock.getSupplier_name()+" </h3> the stock "+ stock.getLibelleStock()+" is almost out!, Please contact the product owner and refill the stock. ",true);
	            	
	                javaMailSender.send(msgHtml);

	          
	            }
		
	        	}
	        }
	}
	
	
}
