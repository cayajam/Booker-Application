package com.example.demo.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Image;
import com.example.demo.model.TravelPackage;
import com.example.demo.model.TravelService;
import com.example.demo.service.ImageService;
import com.example.demo.service.TravelPackageService;
import com.example.demo.service.TravelServiceService;

@RestController
@RequestMapping("/travel-packages")
public class TravelPackageController {
	
	private TravelPackageService travelPackageService;
	private ImageService imageService;
	private TravelServiceService travelServiceService;
	
	
	public TravelPackageController(TravelPackageService travelPackageService, ImageService imageService,
			TravelServiceService travelServiceService) {
		super();
		this.travelPackageService = travelPackageService;
		this.imageService = imageService;
		this.travelServiceService = travelServiceService;
	}
	
	
	@GetMapping
	public List<TravelPackage> findAll() {
		return (List<TravelPackage>) travelPackageService.findAll();
	}
	
	@PostMapping
	public TravelPackage saveTravelPackage(@RequestBody TravelPackage travelPackage) {
		return travelPackageService.saveTravelPackage(travelPackage);
	}
	
	@PutMapping
	public TravelPackage updateTravelPackage(@RequestBody TravelPackage travelPackage) {
		return travelPackage = travelPackageService.saveTravelPackage(travelPackage);

	}
	
	@DeleteMapping
	public void deleteTravelPackageList(@RequestBody List<TravelPackage> travelPackages) {
		travelPackageService.deleteTravelPackages(travelPackages);
	}
	
}
