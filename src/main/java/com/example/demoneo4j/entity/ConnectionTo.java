package com.example.demoneo4j.entity;

import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "CONNECTS_TO")
public class ConnectionTo {

	@Id
	@GeneratedValue
	private Long id;

	@Property  private Integer distance;

	@StartNode
	private Place start;

	@EndNode
	private Place end;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Place getStart() {
		return start;
	}

	public void setStart(Place start) {
		this.start = start;
	}

	public Place getEnd() {
		return end;
	}

	public void setEnd(Place end) {
		this.end = end;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}
}
