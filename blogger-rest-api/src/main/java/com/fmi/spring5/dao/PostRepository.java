package com.fmi.spring5.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.fmi.spring5.model.Post;

public interface PostRepository extends ReactiveMongoRepository<Post, Long>{

}
