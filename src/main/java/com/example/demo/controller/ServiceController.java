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
import com.example.demo.model.TravelService;
import com.example.demo.service.TravelPackageService;
import com.example.demo.service.TravelServiceService;

@RestController
@RequestMapping("travel-packages")
public class ServiceController {

	private TravelServiceService travelServiceService;
	private TravelPackageService travelPackageService;

	public ServiceController(TravelServiceService travelService, TravelPackageService travelPackageService) {
		super();
		this.travelServiceService = travelService;
		this.travelPackageService = travelPackageService;
	}

	@GetMapping("/{travelPackageId}/services")
	public List<TravelService> getServicesList(@PathVariable("travelPackageId") int travelPackageId) {
		return travelPackageService.findById(travelPackageId).getAvailableServiceList();
	}

	@GetMapping("/{travelPackageId}/services/{serviceId}")
	public TravelService getTravelService(@PathVariable("travelPackageId") int travelPackageId,
			@PathVariable("serviceId") int serviceId) {
		TravelPackage travelPackage = travelPackageService.findById(travelPackageId);
		List<TravelService> availedServices = travelPackage.getAvailableServiceList();
		return travelServiceService.findById(serviceId, availedServices);
	}

	@PostMapping("/{travelPackageId}/services")
	public List<TravelService> saveServices(@PathVariable("travelPackageId") int travelPackageId,
			@RequestBody List<TravelService> availedServicesList) {
		List<TravelService> availedServices = travelServiceService.saveAvailedServices(availedServicesList);
		TravelPackage travelPackage = travelPackageService.findById(travelPackageId);
		for(TravelService availedService : availedServices) {
			availedService.setTravelPackage(travelPackage);
		}
		travelServiceService.saveAvailedServices(availedServicesList);

		return travelPackage.getAvailableServiceList();
	}

	@PutMapping("/{travelPackageId}/services")
	public List<TravelService> updateServices(@PathVariable("travelPackageId") int travelPackageId,
			@RequestBody List<TravelService> availedServicesList) {
		List<TravelService> availedServices = travelServiceService.saveAvailedServices(availedServicesList);
		TravelPackage travelPackage = travelPackageService.findById(travelPackageId);
		for (TravelService availedService : availedServices) {
			availedService.setTravelPackage(travelPackage);
		}
		travelServiceService.saveAvailedServices(availedServicesList);

		return travelPackage.getAvailableServiceList();
	}
	
	@PutMapping("/{travelPackageId}/services/{serviceId}")
	public TravelService updateTravelService(@PathVariable("travelPackageId") int travelPackageId,
			@PathVariable("serviceId") int serviceId, @RequestBody TravelService travelService) {
		TravelPackage travelPackage = travelPackageService.findById(travelPackageId);
		List<TravelService> availedServices = travelPackage.getAvailableServiceList();
		TravelService newTravelService = travelServiceService.findById(serviceId, availedServices);
	}

	@DeleteMapping("/{travelPackageId}/services")
	public void deleteServices(@PathVariable("travelPackageId") int travelPackageId) {
		TravelPackage travelPackage = travelPackageService.findById(travelPackageId);
		List<TravelService> availedServices = travelPackage.getAvailableServiceList();
		travelServiceService.deleteTravelServices(availedServices);
	}
	
	@DeleteMapping("/{travelPackageId}/services/{serviceId}")
	public void deleteServiceById(@PathVariable("travelPackageId") int travelPackageId,
			@PathVariable("serviceId") int serviceId) {
		TravelPackage travelPackage = travelPackageService.findById(travelPackageId);
		List<TravelService> availedServices = travelPackage.getAvailableServiceList();
		TravelService travelService = travelServiceService.findById(serviceId, availedServices);
		travelServiceService.deleteTravelService(travelService);
	}

}
