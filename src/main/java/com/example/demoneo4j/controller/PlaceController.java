package com.example.demoneo4j.controller;

import com.example.demoneo4j.dto.LinkDTO;
import com.example.demoneo4j.dto.NodeDTO;
import com.example.demoneo4j.dto.ConnectedPlacesDTO;
import com.example.demoneo4j.entity.ConnectionTo;
import com.example.demoneo4j.repository.PlaceRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/places")
public class PlaceController {
	private final PlaceRepository placeRepository;

	public PlaceController(PlaceRepository placeRepository) {
		this.placeRepository = placeRepository;
	}

	@GetMapping
	@CrossOrigin(origins = "*")
	public ConnectedPlacesDTO findAll() {
		ConnectedPlacesDTO places = new ConnectedPlacesDTO();
		placeRepository.getAllNodesAndRelatedConnections().forEach(place -> {
			NodeDTO n = new NodeDTO();
			n.setId(place.getId());
			n.setName(place.getName());
			places.getNodes().add(n);
			place.getConnections().stream().forEach(connectionTo -> {
				/*ConnectionTo connectionTemp = new ConnectionTo();
				connectionTemp.setId(connectionTo.getId());
				connectionTemp.setStart(connectionTo.getStart());
				connectionTemp.setEnd(connectionTo.getEnd());
				connectionTemp.setDistance(connectionTo.getDistance());*/
				LinkDTO linkDTO = new LinkDTO();
				linkDTO.setDistance(connectionTo.getDistance());
				linkDTO.setSource(connectionTo.getStart().getName());
				linkDTO.setTarget(connectionTo.getEnd().getName());
				places.getLinks().add(linkDTO);
			});
		}); //fun with Java 8
		return places;
	}

	/*@GetMapping("/{title}")
	public Place getMovieByTitle(@PathVariable String title) {
		return placeRepository.getMovieByTitle(title);
	}

	@GetMapping("/search/{title}")
	public Iterable<Place> findMovieByTitleLike(@PathVariable String title) {
		return placeRepository.findMovieByTitleLike(title);
	}*/
}
