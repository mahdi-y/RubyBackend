package DTO.Entities.stock;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;


import DTO.Entities.produit.produit;
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
@Table(name = "stock")
public class stock implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	private long idStock;
	
	private String libelleStock;
	
	private Integer quantite;
	
	private Integer quantiteMin;
	
	private String supplier_name;
	
	private String supplier_mail;

	@OneToMany(mappedBy = "stock")
	private Set<produit> listProduits;
}