package fd.assignment.Repository;

import DTO.Entities.User.User;
import DTO.Entities.User.ERole;
import DTO.Entities.User.Role;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}