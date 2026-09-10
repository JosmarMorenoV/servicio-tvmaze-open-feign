package com.tvmaze.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tvmaze.modelo.CommentRequestDTO;
import com.tvmaze.service.CommentService;

@RestController
@RequestMapping("/api/shows/{showId}/comments")
public class CommentController {

	@Autowired
	private CommentService commentService;

	@PostMapping
	public ResponseEntity<String> addComment(@PathVariable Long showId, @RequestBody CommentRequestDTO request) {
		if (request.getRating() == null || request.getRating() < 0 || request.getRating() > 5) {
			return ResponseEntity.badRequest().body("El rating debe estar entre 0 y 5");
		}
		commentService.saveComment(showId, request);
		return ResponseEntity.status(HttpStatus.CREATED).body("Comentario guardado");
	}

}
