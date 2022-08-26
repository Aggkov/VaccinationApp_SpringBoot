package com.example.demogroup.repository;

import com.example.demogroup.model.role.ERole;
import com.example.demogroup.model.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByRoleName(ERole roleName);
}
