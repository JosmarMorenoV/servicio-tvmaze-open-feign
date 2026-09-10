package com.tvmaze.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentSummaryDTO {

	private String comment;
	private Integer rating;

}
