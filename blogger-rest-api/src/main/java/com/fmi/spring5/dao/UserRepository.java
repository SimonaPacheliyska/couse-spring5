package com.fmi.spring5.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.fmi.spring5.model.User;

public interface UserRepository extends ReactiveMongoRepository<User, Long> {

}
