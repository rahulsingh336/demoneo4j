package com.example.demoneo4j.dto;

import com.example.demoneo4j.entity.ConnectionTo;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class ConnectedPlacesDTO {

	private List<NodeDTO> nodes = new ArrayList<>();

	private Set<ConnectionTo> connections = new HashSet<>();
	private Set<LinkDTO> links = new HashSet<>();

}
