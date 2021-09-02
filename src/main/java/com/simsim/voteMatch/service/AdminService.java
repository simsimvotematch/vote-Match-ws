package com.simsim.voteMatch.service;

import com.simsim.voteMatch.model.Admin;
import com.simsim.voteMatch.model.User;
import com.simsim.voteMatch.repository.AdminRepository;
import com.simsim.voteMatch.repository.UserRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;


@Service
public class AdminService {


    @Autowired
    private AdminRepository adminRepository;


//    public Iterable<Admin> getAdmins(){ return adminRepository.findAll();}

    public Admin login( String username, String password) {

        Iterable<Admin> Admins = adminRepository.findAll();
        for (Admin adminLogin : Admins) {
            if (adminLogin.getUserName().equals(username) & adminLogin.getPassword().equals(password)) {
                return adminLogin;
            }
        }
        return null;
        }
    public boolean isLogin(String username, String password)  {
        Iterable<Admin> Admins = adminRepository.findAll();
        for (Admin adminLogin : Admins) {
            if (adminLogin.getUserName().equals(username) & adminLogin.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void updateAdmin(String userName, String password, Admin adminDetails){
        Admin admin = adminRepository.findById(adminDetails.getId_admin())
                .orElseThrow(() -> new ResourceNotFoundException("User not found on :: "+ adminDetails.getId_admin()));

        admin.setUserName(userName);
        admin.setPassword(password);
        final Admin updatedAdmin = adminRepository.save(admin);
    }

    public void updateAdminPassword(String password, Admin adminDetails)
    {
        Admin admin = adminRepository.findById(adminDetails.getId_admin())
                .orElseThrow(() -> new ResourceNotFoundException("User not found on :: "+ adminDetails.getId_admin()));
        admin.setPassword(password);
        final Admin updatedAdminPassword = adminRepository.save(admin);
    }
    public boolean checkAdmin(Admin admin){
        Admin tempAdmin = adminRepository.findById(admin.getId_admin())
                .orElseThrow(() -> new ResourceNotFoundException("User not found on :: "+ admin.getId_admin()));

        return tempAdmin.getPassword().equals(admin.getPassword());
    }

}