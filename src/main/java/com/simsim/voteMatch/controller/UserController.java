package com.simsim.voteMatch.controller;

import com.simsim.voteMatch.model.User;
import com.simsim.voteMatch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value="/userMatch",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void setUserMatch(@RequestBody User user) {
        userService.setUserMatch(user);

    }


    @GetMapping("/user")
    public Optional<User> getUser(Long id) {
        return userService.getUser(id);
    }

    @GetMapping("/allusers")
    public Iterable<User> getUsers() {
        return userService.getUsers();
    }
}
