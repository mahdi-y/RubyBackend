package tn.esprit.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import DTO.Entities.Reclamation.Reclamation;


@Repository
public interface ReclamationRepository extends CrudRepository<Reclamation, Long> {

}
