package com.example.demogroup.controller;

import com.example.demogroup.payload.UserDto;
import com.example.demogroup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {


    @Autowired
    UserService userService;

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