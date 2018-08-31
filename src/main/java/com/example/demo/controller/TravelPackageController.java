package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.TravelPackage;
import com.example.demo.service.TravelPackageService;

@RestController
@RequestMapping("/travel-packages")
public class TravelPackageController {
	
	private TravelPackageService travelPackageService;
	public TravelPackageController(TravelPackageService travelPackageService) {
		super();
		this.travelPackageService = travelPackageService;
	}
	
	
	@GetMapping
	public List<TravelPackage> findAll() {
		return (List<TravelPackage>) travelPackageService.findAll();
	}
	
	@GetMapping("/{travelPackageId}")
	public TravelPackage findById(@PathVariable("travelPackageId") int travelPackageId) {
		return travelPackageService.findById(travelPackageId);
	}
	
	@PostMapping
	public List<TravelPackage> saveTravelPackage(@RequestBody List<TravelPackage> travelPackages) {
		return travelPackageService.saveTravelPackage(travelPackages);
	}
	
	@PutMapping
	public List<TravelPackage> updateTravelPackage(@RequestBody List<TravelPackage> travelPackages) {
		return travelPackageService.updateTravelPackage(travelPackages);
	}
	
	@PutMapping("/{travelPackageId}")
	public TravelPackage updateTravelPackageById(@PathVariable("travelPackageId") int travelPackageId) {
		return travelPackageService.updateTravelPackageById(travelPackageId);
	}
	
	@DeleteMapping
	public void deleteTravelPackageList(@RequestBody List<TravelPackage> travelPackages) {
		travelPackageService.deleteTravelPackages(travelPackages);
	}
	
}
