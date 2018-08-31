package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.ImageRepository;
import com.example.demo.repository.TravelPackageRepository;
import com.example.demo.repository.TravelServiceRepository;
import com.example.demo.service.CustomerService;
import com.example.demo.service.ImageService;
import com.example.demo.service.TravelPackageService;
import com.example.demo.service.TravelServiceService;

@Configuration
public class BookerConfig {
	
	@Bean
	public CustomerService customerService(CustomerRepository customerRepository) {
		return new CustomerService(customerRepository);
	}
	
	@Bean
	public ImageService imageService(ImageRepository imageRepository) {
		return new ImageService(imageRepository);
	}
	
	@Bean
	public TravelPackageService travelPackageService(TravelPackageRepository travelPackageRepository, ImageService imageService,
			TravelServiceService travelServiceService) {
		return new TravelPackageService(travelPackageRepository, imageService, travelServiceService);
	}
	
	@Bean
	public TravelServiceService travelServiceService(TravelServiceRepository travelServiceRepository) {
		return new TravelServiceService(travelServiceRepository);
	}

}
