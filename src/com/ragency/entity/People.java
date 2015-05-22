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
@Table (name = "people")
public class People {
	@Id 
	@Column (name = "idpeople")
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int idpeople;
	
	@Column (name = "name")
	private String name;
	
	@Column (name = "surname")
	private String surname;
	
	@Column (name = "middlename")
	private String middlename;
	
	@Column (name = "age")
	private int age;
	
	@Column (name = "salary")
	private float salary;
	
	@Column (name = "contacts")
	private String contacts;
	
	@Column (name = "studyplace")
	private String studyplace;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idtype", nullable = false)
	private Educationtype type;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idspec", nullable = false)
	private Specialization spec;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idpost", nullable = false)
	private Post post;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idsphere", nullable = false)
	private Sphere sphere;
	
	@ManyToMany(targetEntity = Lang.class, cascade = CascadeType.MERGE)
	@JoinTable(name = "people_has_lang", joinColumns=@JoinColumn(name = "people_idpeople"),
			inverseJoinColumns = @JoinColumn(name = "lang_idlang"))
	private Set<Lang> langs = new HashSet<Lang>(0);
	
	@ManyToMany(targetEntity = Skill.class, cascade = CascadeType.MERGE)
	@JoinTable(name = "people_has_skill", joinColumns=@JoinColumn(name = "people_idpeople"),
			inverseJoinColumns = @JoinColumn(name = "skill_idskill"))
	private Set<Skill> skills = new HashSet<Skill>(0);

	
	public int getIdpeople() {
		return idpeople;
	}

	public void setIdpeople(int idpeople) {
		this.idpeople = idpeople;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getStudyplace() {
		return studyplace;
	}

	public void setStudyplace(String studyplace) {
		this.studyplace = studyplace;
	}

	public Educationtype getType() {
		return type;
	}

	public void setType(Educationtype type) {
		this.type = type;
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

	public Sphere getSphere() {
		return sphere;
	}

	public void setSphere(Sphere sphere) {
		this.sphere = sphere;
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
