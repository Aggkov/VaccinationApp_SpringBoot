package com.example.demogroup.controller;

import com.example.demogroup.payload.UserDto;
import com.example.demogroup.payload.response.UserProfile;
import com.example.demogroup.security.UserPrincipal;
import com.example.demogroup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/profile")
    public ResponseEntity<UserProfile> getCurrentUser(Authentication authentication) {
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        System.out.println(userPrincipal);
        UserProfile userProfile = userService.getCurrentUser(userPrincipal);

        return new ResponseEntity< >(userProfile, HttpStatus.OK);
    }
    @GetMapping
    public List<UserDto> allUsers() {
       return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") Integer id) {
        return userService.findUserById(id);
    }

   @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
   }

   @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Integer id , @RequestBody UserDto userDto) {
        return userService.updateUser(id , userDto);
   }

  // @DeleteMapping("/{id}")



}
