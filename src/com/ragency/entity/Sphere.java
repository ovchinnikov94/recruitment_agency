package com.ragency.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="sphere")
public class Sphere {
	@Id
	@Column (name="idsphere")
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int idsphere;
	
	@Column (name="spherename")
	private String spherename;
	
	public Sphere(){
		
	}
	
	public Sphere(String spherename) {
		super();
		this.spherename = spherename;
	}

	public int getIdsphere() {
		return idsphere;
	}

	public void setIdsphere(int idsphere) {
		this.idsphere = idsphere;
	}

	public String getSpherename() {
		return spherename;
	}
	public void setSpherename(String spherename) {
		this.spherename = spherename;
	}
	
}
