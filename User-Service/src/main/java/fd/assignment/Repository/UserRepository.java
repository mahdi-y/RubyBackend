package fd.assignment.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import DTO.Entities.User.User;
import DTO.Entities.User.ERole;
import DTO.Entities.User.Role;

import javax.persistence.EntityNotFoundException;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT p FROM User p  where p.id=:username ")
    User getuserById(long username) throws EntityNotFoundException;


    User findByUsername(String username) throws EntityNotFoundException;

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);



}