package com.tvmaze.service;

import java.util.List;

import com.tvmaze.modelo.ShowSummaryDTO;

public interface ShowService {

	List<ShowSummaryDTO> searchShows(String query);

}
