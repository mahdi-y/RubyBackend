package DTO.Entities.paiement;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import DTO.Entities.User.User;
import DTO.Entities.panier.panierProduit;
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

public class paiement implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private long idPaiement;
	
	private String nature;
	
	private Date date;
	
	private float sommetotal;
	
	private long card;
	
	private int cvc;
	
	private String exp;

	//@JsonIgnore
	@OneToMany
	private List<panierProduit> produits;
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	
	
}	
		