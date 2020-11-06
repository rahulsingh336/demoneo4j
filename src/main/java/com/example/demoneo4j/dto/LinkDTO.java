package com.example.demoneo4j.dto;

import lombok.Data;

@Data
public class LinkDTO {

	private String source;
	private String target;
	private Integer distance;
}
