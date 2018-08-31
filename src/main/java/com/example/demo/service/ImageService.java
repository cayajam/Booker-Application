package com.example.demo.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Image;
import com.example.demo.repository.ImageRepository;

public class ImageService {
	
	private ImageRepository imageRepository;

	public ImageService(ImageRepository imageRepository) {
		super();
		this.imageRepository = imageRepository;
	}
	
	@Transactional
	public Image saveImage(Image image) {
		return imageRepository.save(image);
	}
	
	@Transactional
	public void deleteImages(List<Image> images) {
		imageRepository.deleteAll(images);
	}
	
}
