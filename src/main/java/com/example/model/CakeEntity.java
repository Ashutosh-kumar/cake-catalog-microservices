package com.example.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CakeEntity implements Serializable {
	
	private static final long serialVersionUID = -1798070786993154676L;

    private Integer id;


    private String title;


    private String description;


    
    public CakeEntity (Integer id , String title , String desc ){
    	this.id = id;
    	this.title = title;
    	this.description = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

    

}
