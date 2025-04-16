package com.megaminds.pointage.controllers;

import java.util.List;
import com.megaminds.pointage.entities.User;
import com.megaminds.pointage.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/pointage/users")
public class UserController {
    private final UserRepository userRepository;
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @GetMapping
    public List<User> getAllProjets() {
        return userRepository.findAll();
    }

}
