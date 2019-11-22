package com.fmi.spring5.service;

import com.fmi.spring5.model.Post;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PostService {
	Flux<Post> findAll();

	Mono<Post> findById(Long id);

	Mono<Post> create(Post post);

	Mono<Post> update(Post post);

	Mono<Post> delete(Long postId);

	Mono<Long> getCount();
}
