package com.ragency.entity;

import java.util.ArrayList;
import java.util.List;

public class SearchQueryForm {
	private String searchQuery;
	private String place;
	private int idsphere;
	private int idtype;
	private float minSal;
	private float maxSal;
	private List<Lang> langs = new ArrayList<Lang>(0);
	private List<Skill> skills = new ArrayList<Skill>(0);
	
	
	
	public String getSearchQuery() {
		return searchQuery;
	}
	public void setSearchQuery(String searchQuery) {
		this.searchQuery = searchQuery;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public int getIdsphere() {
		return idsphere;
	}
	public void setIdsphere(int idsphere) {
		this.idsphere = idsphere;
	}
	public int getIdtype() {
		return idtype;
	}
	public float getMinSal() {
		return minSal;
	}
	public void setMinSal(float minSal) {
		this.minSal = minSal;
	}
	public float getMaxSal() {
		return maxSal;
	}
	public void setMaxSal(float maxSal) {
		this.maxSal = maxSal;
	}
	public void setIdtype(int idtype) {
		this.idtype = idtype;
	}
	public List<Lang> getLangs() {
		return langs;
	}
	public void setLangs(List<Lang> langs) {
		this.langs = langs;
	}
	public List<Skill> getSkills() {
		return skills;
	}
	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
	
}
