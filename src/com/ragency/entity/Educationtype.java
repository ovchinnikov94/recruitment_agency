package com.ragency.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "educationtype")
public class Educationtype {
	
	@Id 
	@Column (name = "idtype")
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int idtype;
	
	@Column (name = "typename")
	private String typename;
	
	public Educationtype(){
		
	}
	
	public Educationtype(String typename) {
		super();
		this.typename = typename;
	}

	public int getIdtype() {
		return idtype;
	}

	public void setIdtype(int idtype) {
		this.idtype = idtype;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	
}
