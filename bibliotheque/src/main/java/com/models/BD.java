package com.models;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class BD extends Livre {
	
	private String serie;
	
	protected BD() {}
	
	
}
