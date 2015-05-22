package com.ragency.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "specialization")
public class Specialization {
	@Id
	@Column (name = "idspec")
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int idspec;
	
	@Column (name = "specname")
	private String specname;

	public Specialization(){
		
	}
	
	public Specialization(String specname) {
		super();
		this.specname = specname;
	}

	public int getIdspec() {
		return idspec;
	}

	public void setIdspec(int idspec) {
		this.idspec = idspec;
	}

	public String getSpecname() {
		return specname;
	}

	public void setSpecname(String specname) {
		this.specname = specname;
	}
}
