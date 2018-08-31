package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import com.example.demo.model.Image;
import com.example.demo.model.TravelPackage;
import com.example.demo.model.TravelService;
import com.example.demo.repository.TravelPackageRepository;

public class TravelPackageService {
	
	private TravelPackageRepository travelPackageRepository;
	private ImageService imageService;
	private TravelServiceService travelServiceService;

	public TravelPackageService(TravelPackageRepository travelPackageRepository) {
		super();
		this.travelPackageRepository = travelPackageRepository;
	}
	
	@Transactional
	public List<TravelPackage> findAll() {
		return (List<TravelPackage>) travelPackageRepository.findAll();
	}
	
	@Transactional
	public TravelPackage findById(int travelPackageId) {
		return travelPackageRepository.findById(travelPackageId).get();
	}
	
	@Transactional
	public TravelPackage saveTravelPackage(TravelPackage travelPackage) {
		travelPackage = travelPackageRepository.save(travelPackage);
		for (Image image : travelPackage.getImages()) {
			image.setTravelPackage(travelPackage);
			imageService.saveImage(image);
		}
		for (TravelService travelService : travelPackage.getAvailableServiceList()) {
			travelService.setTravelPackage(travelPackage);
			travelServiceService.saveTravelService(travelService);
			
			for (Image serviceImage : travelService.getImages()) {
				serviceImage.setService(travelService);
				imageService.saveImage(serviceImage);
			}
		}
		return travelPackage;
	}
	
	@Transactional
	public TravelPackage updateTravelPackage(TravelPackage travelPackage) {
		travelPackage = travelPackageRepository.save(travelPackage);
		for (Image image : travelPackage.getImages()) {
			image.setTravelPackage(travelPackage);
			imageService.saveImage(image);
		}
		for (TravelService travelService : travelPackage.getAvailableServiceList()) {
			travelService.setTravelPackage(travelPackage);		
			travelServiceService.saveTravelService(travelService);
			
			for (Image serviceImage : travelService.getImages()) {
				serviceImage.setService(travelService);
				imageService.saveImage(serviceImage);
			}
		}
		return travelPackage;
	}
	
	@Transactional
	public void deleteTravelPackages(List<TravelPackage> travelPackages) {
		travelPackageRepository.deleteAll(travelPackages);
	}

}
