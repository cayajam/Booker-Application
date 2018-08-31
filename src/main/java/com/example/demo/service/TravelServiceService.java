package com.example.demo.service;

import org.springframework.stereotype.Component;

import com.example.demo.model.TravelService;
import com.example.demo.repository.TravelServiceRepository;

public class TravelServiceService {
	
	private TravelServiceRepository travelServiceRepository;

	public TravelServiceService(TravelServiceRepository travelServiceRepository) {
		super();
		this.travelServiceRepository = travelServiceRepository;
	}
	
	public TravelService saveTravelService(TravelService travelService) {
		return travelServiceRepository.save(travelService);
	}
}
