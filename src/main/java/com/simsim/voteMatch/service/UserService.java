package com.simsim.voteMatch.service;


import com.simsim.voteMatch.model.User;
import com.simsim.voteMatch.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUser(final Long id) { return userRepository.findById(id); }

    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    public void setUserMatch(User user) {

        User persistedUser = userRepository.save(user);
  }


}