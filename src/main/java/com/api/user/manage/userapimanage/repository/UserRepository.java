package com.api.user.manage.userapimanage.repository;

import com.api.user.manage.userapimanage.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
