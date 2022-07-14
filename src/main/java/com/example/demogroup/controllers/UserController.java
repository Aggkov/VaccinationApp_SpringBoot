package com.example.demogroup.controllers;

import com.example.demogroup.model.dto.UserDto;
import com.example.demogroup.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    IUserService userService;

    @GetMapping("/allUsers")
    public List<UserDto> allUsers() {
       return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") Integer id) {
        return userService.findUserById(id);
    }

   @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
   }

   @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Integer id , @RequestBody UserDto userDto) {
        return userService.updateUser(id , userDto);
   }

  // @DeleteMapping("/{id}")



}
