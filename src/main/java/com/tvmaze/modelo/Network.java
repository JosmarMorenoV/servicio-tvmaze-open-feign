package com.tvmaze.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Network {

	private Long id;
	private String name;
	private Country country;
	private String officialSite;

}
