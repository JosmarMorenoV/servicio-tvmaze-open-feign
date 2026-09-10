package com.tvmaze.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tvmaze.modelo.Comment;
import com.tvmaze.modelo.CommentRequestDTO;
import com.tvmaze.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;

	@Override
	public Comment saveComment(Long showId, CommentRequestDTO request) {
		Comment comment = new Comment(null, showId, request.getComment(), request.getRating());
		return commentRepository.save(comment);
	}

	@Override
	public List<Comment> getCommentsByShowId(Long showId) {
		return commentRepository.findByShowId(showId);
	}

}
