package com.example.demogroup.service;

import com.example.demogroup.model.dto.UserDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

   List<UserDto> getAllUsers();

   ResponseEntity<UserDto> createUser(UserDto userDto);

   ResponseEntity<UserDto> findUserById(Integer id);

   ResponseEntity<UserDto> updateUser(Integer id , UserDto userDto);

   void deleteUser(Integer id);



}
