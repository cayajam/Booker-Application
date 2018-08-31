package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ImageService;
import com.example.demo.service.TravelServiceService;

@RestController
@RequestMapping("travel-packages/{travelPackageId}/services")
public class ServiceController {

	private TravelServiceService travelService;
	private ImageService imageService;

	public ServiceController(TravelServiceService travelService) {
		super();
		this.travelService = travelService;
	}
	
	
	
}
