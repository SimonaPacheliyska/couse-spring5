package com.fmi.spring5.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.fmi.spring5.dao.UserRepository;
import com.fmi.spring5.exception.NonExistingEntityException;
import com.fmi.spring5.model.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public Flux<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public Mono<User> findById(Long id) {
		return userRepository.findById(id).switchIfEmpty(
				Mono.error(new NonExistingEntityException(String.format("User with ID:%s does not exist.", id))));
	}

	@Override
	public Mono<User> create(User user) {
		return userRepository.insert(user);
	}

	@Override
	public Mono<User> update(User user) {
		return userRepository.save(user);
	}

	@Override
	public Mono<User> delete(Long userId) {
		return userRepository.findById(userId)
				.flatMap(user -> userRepository.deleteById(userId).thenReturn(user).switchIfEmpty(Mono.error(
						new NonExistingEntityException(String.format("User with ID:%s does not exist.", userId)))));
	}

	@Override
	public Mono<Long> getCount() {
		return userRepository.count();
	}

}
