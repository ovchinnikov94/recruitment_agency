package com.ragency.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="lang")
public class Lang {
	@Id
	@Column (name="idlang")
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int idlang;
	
	@Column (name = "langname")
	private String langname;
	
	public Lang(){
		
	}
	
	public Lang(int idlang, String langname){
		this.idlang = idlang;
		this.langname = langname;
	}
	
	public Lang(String langname) {
		super();
		this.langname = langname;
	}

	public int getIdlang() {
		return idlang;
	}

	public void setIdlang(int idlang) {
		this.idlang = idlang;
	}

	public String getLangname() {
		return langname;
	}

	public void setLangname(String langname) {
		this.langname = langname;
	}
	
	@Override
	public boolean equals(Object obj){
		return (obj != null) && (obj instanceof Lang) && (((Lang)obj).getIdlang() == this.idlang);
	}
	@Override
	public int hashCode(){
		return Integer.hashCode(this.idlang);	
	}
}
