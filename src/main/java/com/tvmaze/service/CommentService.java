package com.tvmaze.service;

import java.util.List;

import com.tvmaze.modelo.Comment;
import com.tvmaze.modelo.CommentRequestDTO;

public interface CommentService {

	Comment saveComment(Long showId, CommentRequestDTO request);

	List<Comment> getCommentsByShowId(Long showId);

}
