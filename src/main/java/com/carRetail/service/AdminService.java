package com.carRetail.service;

import com.carRetail.models.User;
import com.carRetail.repository.adminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private adminRepository adminRepository;

    public User addUser(User user){
        return adminRepository.save(user);
    }

    //add multiple users

    public List<User> fetchAllUsers(){
        return adminRepository.findAll();
        //native query
    }

    public User updateUser(Long id, User updatedUser){
        User user = adminRepository.findById(id).get();
        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        user.setEmail(updatedUser.getEmail());
        user.setMobileNo(updatedUser.getMobileNo());
        user.setAddress(updatedUser.getAddress());
        user.setRole(updatedUser.getRole());
        user.setDeleteStatus(updatedUser.isDeleteStatus());
        adminRepository.save(user);
        return user;
    }

    public User deleteUser(Long id){
        User user = adminRepository.findById(id).get();
        user.setDeleteStatus(true);
        return user;
    }
}
