package com.spring.demo.repository;

import com.spring.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * User Dao
 */
@Repository
public interface UserDao extends JpaRepository<User, Long> {
}
