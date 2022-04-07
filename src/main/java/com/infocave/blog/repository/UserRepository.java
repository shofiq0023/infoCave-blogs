package com.infocave.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.infocave.blog.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {
	
	@Query(value = "SELECT * FROM users WHERE password = :password AND email = :email", nativeQuery = true)
	Optional<UserModel> login(@Param("password") String password, @Param("email") String email);
}
