package com.example.demogroup.repository;

import com.example.demogroup.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

        List<User> findAllByOrderByUserSurnameAsc();


         User findByUserEmail(String email);

}
