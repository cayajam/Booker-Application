package com.example.demo.service;

import org.springframework.stereotype.Component;

import com.example.demo.model.Image;
import com.example.demo.repository.ImageRepository;

public class ImageService {
	
	private ImageRepository imageRepository;

	public ImageService(ImageRepository imageRepository) {
		super();
		this.imageRepository = imageRepository;
	}
	
	public Image saveImage(Image image) {
		return imageRepository.save(image);
	}
	
}
