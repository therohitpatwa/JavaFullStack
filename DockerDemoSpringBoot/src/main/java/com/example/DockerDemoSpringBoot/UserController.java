package com.example.DockerDemoSpringBoot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping
@RestController
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping
    public User addUser(@RequestBody User user)
    {
        return userRepo.save(user);
    }

    @GetMapping
    public List<User>  getAllUser()
    {
        return userRepo.findAll();
    }



}
