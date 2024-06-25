package com.example.Client;

import DTO.Entities.User.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "user-service", url = "http://localhost:8090/SpringMVC/api/auth") // Specify base URL here
public interface UserServiceClient {

    @GetMapping("/ListUser")
    List<User> getList();

    @GetMapping("/getUserById/{id}")
    User getUserById(@PathVariable("id") Long id);

    @GetMapping("/getUserByUsername/{username}")
   User getUserByUsername(@PathVariable("username") String username);
}
