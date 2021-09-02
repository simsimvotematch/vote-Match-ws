package com.simsim.voteMatch.controller;

import com.simsim.voteMatch.model.Admin;
import com.simsim.voteMatch.service.AdminService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

   // @GetMapping("/admin")
    //public Admin login(String username, String password){
     //   return adminService.login(username,password);
   // }

    @GetMapping("/adminlogin")
    public Admin login(@RequestParam ("username") String username, @RequestParam ("password") String password){
       return adminService.login(username,password);
    }
    @PostMapping("/isadminlogin")
    public boolean islogin(@RequestBody Admin admin){
        System.out.println("test");
        System.out.println(admin.toString());
        if(admin == null) return false;
        else if(adminService.isLogin(admin.getUserName(),admin.getPassword())){
            return true;
        }
        return false;
    }


    @PutMapping(value="/updateAdmin",
            consumes=MediaType.APPLICATION_JSON_VALUE)
    public Boolean updateAdmin(
            @RequestParam(value = "password") String password,
            @RequestParam(value = "userName") String userName,
            @Valid @RequestBody Admin oldAdmin ) throws ResourceNotFoundException {
        if(this.adminService.checkAdmin(oldAdmin)){
            adminService.updateAdmin(userName , password,oldAdmin);
            return true;
        }
        return false;
    }


    @PutMapping(value="/updatePassword",
            consumes=MediaType.APPLICATION_JSON_VALUE)
    public Boolean updatePassword(
            @RequestParam(value = "password") String password,
            @Valid @RequestBody Admin oldAdmin ) throws ResourceNotFoundException {
            if(this.adminService.checkAdmin(oldAdmin)){
                adminService.updateAdminPassword(password,oldAdmin);
                return true;
            }
            return false;
    }
}