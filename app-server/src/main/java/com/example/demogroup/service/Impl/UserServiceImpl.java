package com.example.demogroup.service.Impl;

import com.example.demogroup.exception.ResourceNotFoundException;
import com.example.demogroup.model.user.User;
import com.example.demogroup.payload.request.UserProfileUpdateRequest;
import com.example.demogroup.payload.response.UserProfileResponse;
import com.example.demogroup.repository.UserRepository;
import com.example.demogroup.security.UserPrincipal;
import com.example.demogroup.service.UserService;
import com.example.demogroup.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
     private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserProfileResponse getCurrentUser(UserPrincipal userPrincipal) {
        return new UserProfileResponse(userPrincipal.getUser().getFirstName(), userPrincipal.getUser().getLastName(),
                userPrincipal.getUser().getEmail(), userPrincipal.getUser().getUserAfm());
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>(userRepository.findAllByOrderByLastName());

        return users;
    }

//    @Override
//    public ResponseEntity<UserResponse> addUser(UserResponse userDto) {
//        User userRequest = modelMapper.map(userDto , User.class);
//
//        if(userRepository.findByEmail(userRequest.getEmail()) != null) {
//            throw new CreateRecordException(ExceptionMessagesForExistingValues.EMAIL_ALREADY_EXISTS.getErrorResponse());
//        }
//
//        User user = userRepository.save(userRequest);
//
//        UserResponse userResponse = modelMapper.map(user , UserResponse.class);
//        return new ResponseEntity<>(userResponse , HttpStatus.CREATED);
//    }

    @Override
    public ResponseEntity<UserProfileResponse> updateUser(Integer id, UserProfileUpdateRequest userProfileUpdateRequest) {

        User user = userRepository.findById(id)
                                  .orElseThrow(() -> new ResourceNotFoundException("User was not found"));

        user.setFirstName(userProfileUpdateRequest.getFirstName());
        user.setLastName(userProfileUpdateRequest.getLastName());
        user.setEmail(userProfileUpdateRequest.getEmail());

        User updatedUser = userRepository.save(user);

        UserProfileResponse userProfileResponse = ObjectMapperUtils.map(user , UserProfileResponse.class);

        return new ResponseEntity<>(userProfileResponse, HttpStatus.CREATED);
    }

//    @Override
//    public void deleteUser(Integer id) {
//        userRepository.deleteById(id);
//
//    }
}



