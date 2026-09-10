package com.tvmaze.client;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "tvMazeClient", url = "${tvmaze.api.url}")
public interface TvMazeClient {

	@GetMapping("/search/shows")
	List<Map<String, Object>> searchShows(@RequestParam("q") String query);

	@GetMapping("/shows/{id}")
	Map<String, Object> getShowById(@PathVariable("id") Long id);

}
