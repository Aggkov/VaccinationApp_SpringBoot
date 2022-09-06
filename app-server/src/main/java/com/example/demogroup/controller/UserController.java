package com.example.demogroup.controller;

import com.example.demogroup.model.user.User;
import com.example.demogroup.payload.request.UserProfileUpdateRequest;
import com.example.demogroup.payload.response.UserProfileResponse;
import com.example.demogroup.security.UserPrincipal;
import com.example.demogroup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/profile")
    public ResponseEntity<UserProfileResponse> getCurrentUser(@AuthenticationPrincipal UserPrincipal userPrincipal) {

        UserProfileResponse userProfileResponse = userService.getCurrentUser(userPrincipal);

        return new ResponseEntity< >(userProfileResponse, HttpStatus.OK);
    }
    @GetMapping
    public List<User> allUsers() {
       return userService.getAllUsers();
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<UserProfileResponse> updateUser(@PathVariable Integer id , @RequestBody UserProfileUpdateRequest userProfileUpdateRequest) {

        return userService.updateUser(id , userProfileUpdateRequest);
   }

}
