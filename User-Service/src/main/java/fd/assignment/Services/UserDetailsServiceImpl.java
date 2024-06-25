package fd.assignment.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DTO.Entities.User.User;
import DTO.Entities.User.ERole;
import DTO.Entities.User.Role;

import fd.assignment.Repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = userRepository.findByUsername(username);

        return UserDetailsImpl.build(user);
    }


    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public User listUser(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public void updateUser(User user){
        userRepository.save(user);
    }

    public List<User> getList(){
      return    userRepository.findAll();}




    public Optional<User> getUserById(Long userId) {
        // Use findById method of UserRepository
        return userRepository.findById(userId);
    }


}