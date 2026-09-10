package com.tvmaze.modelo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Show {

	private Long id;
	private String url;
	private String name;
	private String type;
	private String language;
	private List<String> genres;
	private String status;
	private Integer runtime;
	private Integer averageRuntime;
	private String premiered;
	private String ended;
	private String officialSite;
	private Schedule schedule;
	private Rating rating;
	private Integer weight;
	private Network network;
	private Network webChannel;
	private Image image;
	private String summary;
	private Long updated;

}
