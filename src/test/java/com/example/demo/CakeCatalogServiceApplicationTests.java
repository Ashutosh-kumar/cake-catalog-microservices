package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.model.CakeEntity;
import com.example.repo.CakeRepository;
import com.example.rest.CakeCatalogRestApi;
import com.example.service.CakeService;

@SpringBootTest
class CakeCatalogServiceApplicationTests {
	

    @Autowired
    private CakeService cakeService;
    
    @MockBean
    private CakeRepository cakeRepository;

	@Test
	void contextLoads() {
	
	}
	
	@Test
	void testGetCurrentLisFormCatalog() {
		
		List <CakeEntity> cake_catalog_list = new ArrayList <CakeEntity> ();
		
		cake_catalog_list.add(new CakeEntity(1, "Pineapple Cake", "Cake with pinapple and jam"));
		cake_catalog_list.add(new CakeEntity(2, "Victoria Cake", "Cake with venila flavour and white cream") );
		cake_catalog_list.add(new CakeEntity(3, "Carrot Cake", "Cake with carrot flavour") );

       Mockito.when(cakeRepository.getAllCakeCatalogFromRepo())
	      .thenReturn(cake_catalog_list);
		 
       
       List <CakeEntity> list = cakeService.getAllCakesFromCatalog();
       assertEquals(3, list.size());
       
		
	}
	
	@Test
	void testAddtoCurrentLisFromCatalog() {
		
		List <CakeEntity> cake_catalog_list = new ArrayList <CakeEntity> ();
		
		cake_catalog_list.add(new CakeEntity(1, "Pineapple Cake", "Cake with pinapple and jam"));
		cake_catalog_list.add(new CakeEntity(2, "Victoria Cake", "Cake with venila flavour and white cream") );
		cake_catalog_list.add(new CakeEntity(3, "Carrot Cake", "Cake with carrot flavour") );

     
		 
       CakeEntity newToadd = new CakeEntity(4, "Forest Cake", "Cake with coco flavour");
       
       Mockito.when(cakeRepository.addCake(newToadd))
	      .thenReturn(cake_catalog_list.add(newToadd));
      
       
       boolean b = cakeService.addCakeTotheCatalog(newToadd);
        // list = cakeService.getAllCakesFromCatalog();
       
      // 
       
       assertEquals(4, cake_catalog_list.size());
       
		
	}

	
	
}
