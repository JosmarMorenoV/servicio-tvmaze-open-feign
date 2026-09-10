package com.tvmaze.modelo;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Schedule {

	private String time;
	private List<String> days;

}
