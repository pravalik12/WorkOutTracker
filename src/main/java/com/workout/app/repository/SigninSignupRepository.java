package com.workout.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.workout.app.model.SigninSignup;

@Repository
public interface SigninSignupRepository extends JpaRepository<SigninSignup, Long> {
	
}
