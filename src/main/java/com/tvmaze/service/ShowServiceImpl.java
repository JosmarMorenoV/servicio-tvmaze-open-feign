package com.tvmaze.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tvmaze.client.TvMazeClient;
import com.tvmaze.modelo.ShowCache;
import com.tvmaze.modelo.ShowSummaryDTO;
import com.tvmaze.repository.ShowCacheRepository;

@Service
public class ShowServiceImpl implements ShowService {

	@Autowired
	private TvMazeClient tvMazeClient;

	@Autowired
	private ShowCacheRepository showCacheRepository;

	@Override
	@SuppressWarnings("unchecked")
	public List<ShowSummaryDTO> searchShows(String query) {
		List<Map<String, Object>> results = tvMazeClient.searchShows(query);
		return results.stream()
				.map(result -> (Map<String, Object>) result.get("show"))
				.map(this::toSummaryDTO)
				.collect(Collectors.toList());
	}

	@SuppressWarnings("unchecked")
	private ShowSummaryDTO toSummaryDTO(Map<String, Object> show) {
		Map<String, Object> network = (Map<String, Object>) show.get("network");
		Map<String, Object> webChannel = (Map<String, Object>) show.get("webChannel");
		String channel = network != null ? (String) network.get("name")
				: webChannel != null ? (String) webChannel.get("name") : null;

		Long id = Long.valueOf(show.get("id").toString());
		String name = (String) show.get("name");
		String summary = (String) show.get("summary");
		List<String> genres = (List<String>) show.get("genres");

		return new ShowSummaryDTO(id, name, channel, summary, genres);
	}

	@Override
	public Map<String, Object> getShowById(Long id) {
		return showCacheRepository.findById(id)
				.map(ShowCache::getShow)
				.orElseGet(() -> {
					Map<String, Object> show = tvMazeClient.getShowById(id);
					showCacheRepository.save(new ShowCache(id, show));
					return show;
				});
	}

}
