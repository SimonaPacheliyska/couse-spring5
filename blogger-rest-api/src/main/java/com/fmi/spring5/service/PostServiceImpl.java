package com.fmi.spring5.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.fmi.spring5.dao.PostRepository;
import com.fmi.spring5.exception.NonExistingEntityException;
import com.fmi.spring5.model.Post;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;

	@Override
	public Flux<Post> findAll() {
		return postRepository.findAll();
	}

	@Override
	public Mono<Post> findById(Long id) {
		return postRepository.findById(id).switchIfEmpty(
				Mono.error(new NonExistingEntityException(String.format("Post with ID:%s does not exist.", id))));
	}

	@Override
	public Mono<Post> create(Post post) {
		return postRepository.insert(post);
	}

	@Override
	public Mono<Post> update(Post post) {
		return postRepository.save(post);
	}

	@Override
	public Mono<Post> delete(Long postId) {
		return postRepository.findById(postId)
				.flatMap(post -> postRepository.deleteById(postId).thenReturn(post).switchIfEmpty(Mono.error(
						new NonExistingEntityException(String.format("Post with ID:%s does not exist.", postId)))));
	}

	@Override
	public Mono<Long> getCount() {
		return postRepository.count();
	}

}
