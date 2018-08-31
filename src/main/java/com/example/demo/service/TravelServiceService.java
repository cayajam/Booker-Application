package com.example.demo.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Image;
import com.example.demo.model.TravelService;
import com.example.demo.repository.TravelServiceRepository;

public class TravelServiceService {
	
	private TravelServiceRepository travelServiceRepository;
	private ImageService imageService;

	public TravelServiceService(TravelServiceRepository travelServiceRepository, ImageService imageService) {
		super();
		this.travelServiceRepository = travelServiceRepository;
		this.imageService = imageService;
	}
	
	@Transactional
	public TravelService saveTravelService(TravelService travelService) {
		return travelServiceRepository.save(travelService);
	}
	
	@Transactional
	public List<TravelService> saveAvailedServices(List<TravelService> availedServices) {
		availedServices = (List<TravelService>) travelServiceRepository.saveAll(availedServices);
		for (TravelService eachService : availedServices) {
			for (Image image : eachService.getImages()) {
				image.setService(eachService);
				imageService.saveImage(image);
			}
		}
		return availedServices;
	}
	
	@Transactional
	public TravelService findById(int serviceId, List<TravelService> availedServices) {
		TravelService travelService = null;
		for (TravelService eachService : availedServices) {
			int savedId = eachService.getServiceId();
			if (serviceId == savedId) {
				travelService = travelServiceRepository.findById(serviceId).get();
			}
		}
		return travelService;
	}
	
	@Transactional
	public void deleteTravelServices(List<TravelService> travelServices) {
		for(TravelService eachService : travelServices) {
			imageService.deleteImages(eachService.getImages());
		}
		travelServiceRepository.deleteAll(travelServices);
	}
	
	@Transactional
	public void deleteTravelService(TravelService travelService) {
		imageService.deleteImages(travelService.getImages());
		travelServiceRepository.delete(travelService);
	}
}
