package com.ragency.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="skill")
public class Skill {
	@Id
	@Column (name="idskill")
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int idskill;
	
	@Column (name="skillname")
	private String skillname;
	
	public Skill(){
		
	}
	
	public Skill(int idskill, String skillname){
		super();
		this.idskill = idskill;
		this.skillname = skillname;
	}
	
	public Skill(String skillname) {
		super();
		this.skillname = skillname;
	}
	public int getIdskill() {
		return idskill;
	}
	public void setIdskill(int idskill) {
		this.idskill = idskill;
	}
	public String getSkillname() {
		return skillname;
	}
	public void setSkillname(String skillname) {
		this.skillname = skillname;
	}
	
	@Override 
	public boolean equals(Object obj){
		return (obj != null) && (obj instanceof Skill) && (this.idskill == ((Skill)obj).getIdskill());
	}
	
	@Override 
	public int hashCode(){
		return Integer.hashCode(this.idskill);
	}
	
}
