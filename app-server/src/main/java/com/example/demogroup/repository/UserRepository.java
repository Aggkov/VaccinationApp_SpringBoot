package com.example.demogroup.repository;

import com.example.demogroup.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

        List<User> findAllByOrderByLastName();


         User findByEmail(String email);

}
