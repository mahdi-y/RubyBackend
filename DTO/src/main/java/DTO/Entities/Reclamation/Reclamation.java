package DTO.Entities.Reclamation;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import DTO.Entities.Livraison.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import DTO.Entities.User.User;
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
public class Reclamation implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idReclamation;
	private Date dateRec;
	private String description;
	private String type;
	private String user_email;
	private boolean etat;
	@JsonIgnore
	@ManyToOne
	private Livraison livraison;
	@JsonIgnore
	@ManyToOne
	private User user;


}
