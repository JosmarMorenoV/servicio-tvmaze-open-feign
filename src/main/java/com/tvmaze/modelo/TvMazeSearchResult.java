package com.tvmaze.modelo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TvMazeSearchResult {

	private Double score;
	private Show show;

}
