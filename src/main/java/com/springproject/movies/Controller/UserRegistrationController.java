package com.springproject.movies.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springproject.movies.Model.AuthUser;
import com.springproject.movies.Repository.UserRepository;

@RestController
@RequestMapping("/api/v1/user")
public class UserRegistrationController {
   
    @Autowired
    UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<AuthUser> registerUser(@RequestBody Map<String, String> payload){
        AuthUser authUser = userRepository.insert(new AuthUser(payload.get("username"),payload.get("name"),payload.get("email"),new BCryptPasswordEncoder().encode((payload.get("password"))),"USER"));
        return new ResponseEntity<AuthUser>(authUser,HttpStatus.CREATED);
    }
}
