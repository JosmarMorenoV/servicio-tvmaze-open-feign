package com.tvmaze.modelo;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "shows_cache")
public class ShowCache {

	@Id
	private Long id;
	private Map<String, Object> show;

}
