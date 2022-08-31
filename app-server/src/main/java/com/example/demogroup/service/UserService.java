package com.example.demogroup.service;

import com.example.demogroup.model.user.User;
import com.example.demogroup.payload.request.UserProfileUpdateRequest;
import com.example.demogroup.payload.response.UserProfileResponse;
import com.example.demogroup.security.UserPrincipal;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    UserProfileResponse getCurrentUser(UserPrincipal userPrincipal);

   List<User> getAllUsers();

//   ResponseEntity<User> addUser(User user);

   ResponseEntity<UserProfileResponse> updateUser(Integer id , UserProfileUpdateRequest userProfileUpdateRequest);

//   void deleteUser(Integer id);



}
