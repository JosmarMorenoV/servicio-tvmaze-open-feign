package com.tvmaze.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping("/{id}")
	public Map<String, Object> getShowById(@PathVariable Long id) {
		return showService.getShowById(id);
	}

}
