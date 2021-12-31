package com.example.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.model.CakeEntity;
@Repository
public class CakeRepository {
	
	
    static List <CakeEntity> cake_catalog_list = new ArrayList <CakeEntity> ();
	
	
	
	public static void loadInitialdata(){
		cake_catalog_list.add(new CakeEntity(1, "Pineapple Cake", "Cake with pinapple and jam"));
		cake_catalog_list.add(new CakeEntity(2, "Victoria Cake", "Cake with venila flavour and white cream") );
	}
	
	static {
		loadInitialdata();
	}
	
	public List <CakeEntity> getAllCakeCatalogFromRepo(){
		return cake_catalog_list;
	}

	public boolean addCake(CakeEntity cakeEntity) {
		return cake_catalog_list.add(cakeEntity);
		
	}
	
}
