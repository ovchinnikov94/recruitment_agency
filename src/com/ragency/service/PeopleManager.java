package com.ragency.service;

import java.util.List;

import com.ragency.entity.People;
import com.ragency.entity.SearchQueryForm;
import com.ragency.entity.Vacancy;

public interface PeopleManager {
	public void addPeople(People people);
	public void updatePeople(People people);
	public People getById(int id);
	public void deletePeople(int id);
	public List<People> getPeopleByVacancy(Vacancy vacancy);
	public List<People> getAllPeople(boolean init);
	public List<People> getPeopleByForm(SearchQueryForm form);	
}
