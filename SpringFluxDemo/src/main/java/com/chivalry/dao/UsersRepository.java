package com.chivalry.dao;

import com.chivalry.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author verne.zhong
 * @date 2025/03/22
 * @description
 */
public interface UsersRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
}
