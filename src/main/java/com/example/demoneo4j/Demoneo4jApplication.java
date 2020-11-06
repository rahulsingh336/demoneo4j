package com.example.demoneo4j;

import com.example.demoneo4j.entity.ConnectionTo;
import com.example.demoneo4j.entity.Place;
import com.example.demoneo4j.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

import java.util.*;

@SpringBootApplication
@EnableNeo4jRepositories("com.example.demoneo4j.repository")
public class Demoneo4jApplication {

	@Autowired
	private PlaceRepository placeRepository;

	public static void main(String[] args) {
		SpringApplication.run(Demoneo4jApplication.class, args);
	}


	//@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's insert some data");

			Set<ConnectionTo> connectionToList = new HashSet<>();
			Place place = new Place();
			//place.setId(0);
			place.setName("0");
			Place place1 = new Place();
			//place.setId(1);
			place1.setName("1");

			ConnectionTo connectionTo = new ConnectionTo();
			//connectionTo.setId(0);
			connectionTo.setDistance(4);
			connectionTo.setStart(place);
			connectionTo.setEnd(place1);

			connectionToList.add(connectionTo);

			place.setConnections(connectionToList);

			placeRepository.save(place);

		};
	}

}
