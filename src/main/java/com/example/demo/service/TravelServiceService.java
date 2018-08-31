package com.example.demo.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.TravelService;
import com.example.demo.repository.TravelServiceRepository;

public class TravelServiceService {
	
	private TravelServiceRepository travelServiceRepository;

	public TravelServiceService(TravelServiceRepository travelServiceRepository) {
		super();
		this.travelServiceRepository = travelServiceRepository;
	}
	
	@Transactional
	public TravelService saveTravelService(TravelService travelService) {
		return travelServiceRepository.save(travelService);
	}
	
	@Transactional
	public void deleteTravelServices(List<TravelService> travelServices) {
		travelServiceRepository.deleteAll(travelServices);
	}
}
