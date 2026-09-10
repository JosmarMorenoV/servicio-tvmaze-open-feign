package com.tvmaze.service;

import java.util.List;
import java.util.Map;

import com.tvmaze.modelo.ShowSummaryDTO;

public interface ShowService {

	List<ShowSummaryDTO> searchShows(String query);

	Map<String, Object> getShowById(Long id);

}
