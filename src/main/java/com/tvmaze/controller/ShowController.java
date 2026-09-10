package com.tvmaze.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tvmaze.modelo.ShowSummaryDTO;
import com.tvmaze.service.ShowService;

@RestController
@RequestMapping("/api/shows")
public class ShowController {

	@Autowired
	private ShowService showService;

	@GetMapping("/search")
	public List<ShowSummaryDTO> search(@RequestParam("query") String query) {
		return showService.searchShows(query);
	}

}
