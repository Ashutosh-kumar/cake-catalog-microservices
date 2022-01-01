package com.example.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.CakeEntity;
import com.example.service.CakeService;

@RestController 
@RequestMapping("/")
public class CakeCatalogRestApi {
	
	@Autowired
    private CakeService cakeService;
	
@RequestMapping(value="/cakes" ,produces = {"application/json" }  )

	List <CakeEntity> getCatalogItem(String userId){
	
		return cakeService.getAllCakesFromCatalog();	
	
	}



@RequestMapping(value="/cakes", method = RequestMethod.POST
)
@ResponseBody

ResponseEntity<Object> addCatalogItem(@RequestBody  CakeEntity cakeEntity){
	
	
	Boolean flag = cakeService.getAllCakesFromCatalog().stream().anyMatch(cake -> cake.getId().equals(cakeEntity.getId() ) );
	if (flag) {
		ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, "Duplicate id cannot add", "error occurred while adding");
		return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}
	
	cakeService.addCakeTotheCatalog(cakeEntity);
	
	
	return new ResponseEntity<Object>(cakeService.getAllCakesFromCatalog(), new HttpHeaders(), HttpStatus.OK);


}

}
