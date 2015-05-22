package com.ragency.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table (name = "company")
public class Company {
	@Id 
	@Column (name = "idcompany")
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int idcompany;
	
	@Column (name = "name")
	private String name;
	
	@Column (name = "contacts")
	private String contacts;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
	private Set<History> histories = new HashSet<History>(0);
	
	@OneToMany(mappedBy = "company", cascade = CascadeType.REMOVE)
	private Set<Vacancy> vacancies = new HashSet<Vacancy>(0);

	
	public Set<History> getHistories() {
		return histories;
	}

	public void setHistories(Set<History> histories) {
		this.histories = histories;
	}

	public Set<Vacancy> getVacancies() {
		return vacancies;
	}

	public void setVacancies(Set<Vacancy> vacancies) {
		this.vacancies = vacancies;
	}

	public int getIdcompany() {
		return idcompany;
	}

	public void setIdcompany(int idcompany) {
		this.idcompany = idcompany;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	
	
}
