package com.tvmaze.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tvmaze.modelo.Comment;

public interface CommentRepository extends MongoRepository<Comment, String> {

	List<Comment> findByShowId(Long showId);

}
