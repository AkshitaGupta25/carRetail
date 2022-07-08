package com.carRetail.controller;

import com.carRetail.models.User;
import com.carRetail.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/add")
    public User addUser(@RequestBody User user){
        return adminService.addUser(user);
    }

    //add multiple users

    @GetMapping
    public List<User> fetchAllUsers(){
        return adminService.fetchAllUsers();
    }

    @PutMapping
    public User updateUser(@PathVariable Long id, @RequestBody User user){
        return adminService.updateUser(id,user);
    }

    @DeleteMapping
    public User deleteUser(@PathVariable Long id){
        return adminService.deleteUser(id);
    }
    }
