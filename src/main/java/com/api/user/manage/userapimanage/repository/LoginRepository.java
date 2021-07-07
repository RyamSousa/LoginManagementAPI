package com.api.user.manage.userapimanage.repository;

import com.api.user.manage.userapimanage.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}