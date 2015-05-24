package com.ragency.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "history")
public class History {
	@Id
	@Column(name = "idhistory")
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int idhistory;
	
	@Column(name = "salary")
	private float salary;
	
	@Column(name = "dateFrom")
	private Date dateFrom;
	
	@Column(name = "dateTo")
	private Date dateTo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idpost", nullable = false)
	private Post post;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idcompany", nullable = false)
	private Company company;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idpeople", nullable = false)
	private People people;

	public int getIdhistory() {
		return idhistory;
	}

	public void setIdhistory(int idhistory) {
		this.idhistory = idhistory;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public People getPeople() {
		return people;
	}

	public void setPeople(People people) {
		this.people = people;
	}
	
	
}
