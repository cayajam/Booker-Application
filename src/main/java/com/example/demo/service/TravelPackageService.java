package com.example.demo.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Image;
import com.example.demo.model.TravelPackage;
import com.example.demo.model.TravelService;
import com.example.demo.repository.TravelPackageRepository;

public class TravelPackageService {

	private TravelPackageRepository travelPackageRepository;
	private ImageService imageService;
	private TravelServiceService travelServiceService;

	public TravelPackageService(TravelPackageRepository travelPackageRepository, ImageService imageService,
			TravelServiceService travelServiceService) {
		super();
		this.travelPackageRepository = travelPackageRepository;
		this.imageService = imageService;
		this.travelServiceService = travelServiceService;
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
	public List<TravelPackage> saveTravelPackage(List<TravelPackage> travelPackages) {
		travelPackages = (List<TravelPackage>) travelPackageRepository.saveAll(travelPackages);
		for (TravelPackage travelPackage : travelPackages) {
			for (Image image : travelPackage.getImages()) {
				image.setTravelPackage(travelPackage);
				imageService.saveImage(image);
			}
			travelServiceService.saveAvailedServices(travelPackage.getAvailableServiceList());
			for (TravelService travelService : travelPackage.getAvailableServiceList()) {
				travelService.setTravelPackage(travelPackage);
				//travelServiceService.saveTravelService(travelService);
				for (Image serviceImage : travelService.getImages()) {
					serviceImage.setService(travelService);
					imageService.saveImage(serviceImage);
				}
			}
		}
		return travelPackages;
	}
	
	@Transactional
	public TravelPackage saveTravelPackage(TravelPackage travelPackage) {
		travelPackage = travelPackageRepository.save(travelPackage);
		
		return travelPackage;
	}
	
	@Transactional
	public TravelPackage updateTravelPackageById(int travelPackageId) {
		TravelPackage travelPackage = travelPackageRepository.findById(travelPackageId).get();
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
	public List<TravelPackage> updateTravelPackage(List<TravelPackage> travelPackages) {
		travelPackages = (List<TravelPackage>) travelPackageRepository.saveAll(travelPackages);
		for (TravelPackage travelPackage : travelPackages) {
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
		}
		return travelPackages;
	}

	@Transactional
	public void deleteTravelPackages(List<TravelPackage> travelPackages) {
		for (TravelPackage travelPackage : travelPackages) {
			imageService.deleteImages(travelPackage.getImages());
			for (TravelService travelService : travelPackage.getAvailableServiceList()) {
				imageService.deleteImages(travelService.getImages());
			}
			travelServiceService.deleteTravelServices(travelPackage.getAvailableServiceList());
		}
		travelPackageRepository.deleteAll(travelPackages);

	}
	
	@Transactional
	public void deleteTravelPackageById(int travelPackageId) {
		TravelPackage travelPackage = travelPackageRepository.findById(travelPackageId).get();
		imageService.deleteImages(travelPackage.getImages());
		for (TravelService travelService : travelPackage.getAvailableServiceList()) {
			imageService.deleteImages(travelService.getImages());
		}
		travelServiceService.deleteTravelServices(travelPackage.getAvailableServiceList());
		travelPackageRepository.delete(travelPackage);
	}

}
