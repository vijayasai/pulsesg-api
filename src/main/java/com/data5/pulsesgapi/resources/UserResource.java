package com.data5.pulsesgapi.resources;

import com.data5.pulsesgapi.model.User;
import com.data5.pulsesgapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getUsers() {
         return userRepository.findAllByEmailLike("%5datainc.com");
    }

}
