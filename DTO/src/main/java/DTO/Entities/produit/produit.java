package DTO.Entities.produit;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import DTO.Entities.User.User;
import DTO.Entities.stock.stock;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Table(name = "produit")
public class produit implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private long idProduit;
	
	private String categorieProduit;
	
	private String libelleProduit;
	
	private String description;
	
	private String image;
		
	private float prix;
	
	private Date dateCreation;
	
	@JsonIgnore
	@ManyToOne
	private stock stock;

	@JsonIgnore	
	@ManyToOne
	private User user;
		
}
