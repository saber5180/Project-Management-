package com.example.demo.repository;


import com.example.demo.dto.DevDto;
import com.example.demo.entity.Developper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DevRepository extends JpaRepository<Developper, Integer> {

//
    Developper findByEmail(String email);
    @Query("SELECT u FROM Developper u WHERE u.userName = :username or u.email= :email")
    Optional<Developper> findByUser(@Param("username")String UserName,@Param("username")String email);

    Optional<Developper> findByUserName(String UserName);


     Developper getUserByUserName(String UserName);
}
