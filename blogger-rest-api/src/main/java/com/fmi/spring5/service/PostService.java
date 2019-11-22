package com.fmi.spring5.service;

import com.fmi.spring5.model.Post;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PostService {
	Flux<Post> findAll();

	Mono<Post> findById(Long id);

	Mono<Post> create(Post article);

	Mono<Post> update(Post article);

	Mono<Post> delete(Long articleId);

	Mono<Long> getCount();
}
