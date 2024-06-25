package DTO.Entities.panier;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import DTO.Entities.User.User;
import DTO.Entities.produit.produit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
public class panierProduit implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPanierProduit;
	
	private int quantity;
	
	private float somme;
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "produit_id")
	private produit produit;



}