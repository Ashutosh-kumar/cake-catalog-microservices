package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.CakeEntity;
import com.example.repo.CakeRepository;
@Service
public class CakeService {
	@Autowired
    private CakeRepository repository;
	
	public List <CakeEntity> getAllCakesFromCatalog() {
		return repository.getAllCakeCatalogFromRepo();
		
	}
	
	public boolean addCakeTotheCatalog(CakeEntity cakeEntity) {
		return repository.addCake(cakeEntity);
	}

}
