package com.example.demogroup.service.Impl;

import com.example.demogroup.exception.CreateRecordException;
import com.example.demogroup.exception.ExceptionMessagesForExistingValues;
import com.example.demogroup.exception.ResourceNotFoundException2;
import com.example.demogroup.model.User;
import com.example.demogroup.model.dto.UserDto;
import com.example.demogroup.repository.UserRepository;
import com.example.demogroup.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
     private UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = new ArrayList<>(userRepository.findAllByOrderByLastName());
        List<UserDto> userDto = users.stream().map(user -> modelMapper.map(user , UserDto.class))
                               .collect(Collectors.toList());
        return userDto;
    }

    @Override
    public ResponseEntity<UserDto> createUser(UserDto userDto) {
        //convert dto to entity
        User userRequest = modelMapper.map(userDto , User.class);
        //Check if user email is available
        if(userRepository.findByEmail(userRequest.getEmail()) != null) {
            throw new CreateRecordException(ExceptionMessagesForExistingValues.EMAIL_ALREADY_EXISTS.getErrorResponse());
        }

        User user = userRepository.save(userRequest);

        // convert entity to dto

        UserDto userResponse = modelMapper.map(user , UserDto.class);
        return new ResponseEntity<>(userResponse , HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<UserDto> findUserById(Integer id) {
       Optional<User> userRequest = userRepository.findById(id);
       UserDto userResponse = modelMapper.map(userRequest , UserDto.class);
       return new ResponseEntity<>(userResponse,HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<UserDto> updateUser(Integer id, UserDto userDto) {
        // convert Dto to Entity
        User userRequest = modelMapper.map(userDto , User.class);
        // Get user and Update
        User user = userRepository.findById(id)
                                  .orElseThrow(() -> new ResourceNotFoundException2("User","id",id));
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        userRepository.save(user);

        //convert Entity to Dto

        UserDto userResponse = modelMapper.map(user , UserDto.class);
        return new ResponseEntity<>(userResponse,HttpStatus.ACCEPTED);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);

    }
}



