package com.example.demoneo4j.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.neo4j.ogm.annotation.*;

import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class Place {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@JsonIgnoreProperties({"start","end"})
	@Relationship(type = "CONNECTS_TO", direction = Relationship.UNDIRECTED)
	private Set<ConnectionTo> connections = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<ConnectionTo> getConnections() {
		return connections;
	}

	public void setConnections(Set<ConnectionTo> connections) {
		this.connections = connections;
	}
}
