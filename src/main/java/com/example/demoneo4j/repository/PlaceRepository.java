package com.example.demoneo4j.repository;

import com.example.demoneo4j.entity.Place;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface PlaceRepository extends Neo4jRepository<Place, Integer> {

	@Query("MATCH (p:Place) - [c:CONNECTS_TO] -> (p1:Place)\n" +
			"RETURN p,c,p1")
	Iterable<Place> getAllNodesAndRelatedConnections();

	/*Place getMovieByTitle(String title);

	Iterable<Place> findMovieByTitleLike(String title);

	@Query("MATCH (m:Movie)<-[r:ACTED_IN]-(a:Person) RETURN m,r,a LIMIT {limit}")
	Collection<Place> Place(@Param("limit") int limit);*/
}
