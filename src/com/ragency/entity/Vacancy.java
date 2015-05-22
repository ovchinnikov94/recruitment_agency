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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "vacancy")
public class Vacancy {
	@Id
	@Column (name = "idvacancy")
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int idvacancy;
	
	@Column (name = "salary")
	private float salary;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idspec", nullable = false)
	private Specialization spec;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idpost", nullable = false)
	private Post post;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idtype", nullable = false)
	private Educationtype type;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idsphere", nullable = false)
	private Sphere sphere;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idcompany", nullable = false)
	private Company company;
	
	@ManyToMany(targetEntity = Lang.class, cascade = CascadeType.MERGE)
	@JoinTable(name = "vacancy_has_lang", joinColumns=@JoinColumn(name = "vacancy_idvacancy"),
	inverseJoinColumns = @JoinColumn(name = "lang_idlang"))
	private Set<Lang> langs = new HashSet<Lang>(0);
	
	@ManyToMany(targetEntity = Skill.class, cascade = CascadeType.MERGE)
	@JoinTable(name = "vacancy_has_skill", joinColumns=@JoinColumn(name = "vacancy_idvacancy"),
	inverseJoinColumns = @JoinColumn(name = "skill_idskill"))
	private Set<Skill> skills = new HashSet<Skill>(0);

	public int getIdvacancy() {
		return idvacancy;
	}

	public void setIdvacancy(int idvacancy) {
		this.idvacancy = idvacancy;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public Specialization getSpec() {
		return spec;
	}

	public void setSpec(Specialization spec) {
		this.spec = spec;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Educationtype getType() {
		return type;
	}

	public void setType(Educationtype type) {
		this.type = type;
	}

	public Sphere getSphere() {
		return sphere;
	}

	public void setSphere(Sphere sphere) {
		this.sphere = sphere;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Set<Lang> getLangs() {
		return langs;
	}

	public void setLangs(Set<Lang> langs) {
		this.langs = langs;
	}

	public Set<Skill> getSkills() {
		return skills;
	}

	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}

	
	
	
}
