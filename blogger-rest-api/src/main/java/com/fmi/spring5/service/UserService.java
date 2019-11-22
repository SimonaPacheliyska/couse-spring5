package com.fmi.spring5.service;

import com.fmi.spring5.model.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
	
	Flux<User> findAll();

	Mono<User> findById(Long id);

	Mono<User> create(User user);

	Mono<User> update(User user);

	Mono<User> delete(Long userId);

	Mono<Long> getCount();
}
