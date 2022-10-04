package com.vipera.empresaer.dao.repositories;

import com.vipera.empresaer.dao.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User,String> {


    Optional<User> findByUsername(String username);
}
