package com.example.demogroup.service;

import com.example.demogroup.payload.UserDto;
import com.example.demogroup.payload.response.UserProfile;
import com.example.demogroup.security.UserPrincipal;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    UserProfile getCurrentUser(UserPrincipal userPrincipal);

   List<UserDto> getAllUsers();

   ResponseEntity<UserDto> createUser(UserDto userDto);

   ResponseEntity<UserDto> findUserById(Integer id);

   ResponseEntity<UserDto> updateUser(Integer id , UserDto userDto);

   void deleteUser(Integer id);



}
