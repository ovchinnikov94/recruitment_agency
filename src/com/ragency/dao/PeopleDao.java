package com.ragency.dao;

import java.util.List;

import com.ragency.entity.People;
import com.ragency.entity.SearchQueryForm;
import com.ragency.entity.Vacancy;

public interface PeopleDao {
	public void addPeople(People people);
	public void updatePeople(People people);
	public People getById(int id);
	public void deletePeople(People people);
	public List<People> getPeopleByVacancy(Vacancy vacancy);
	public List<People> getAllPeople(boolean initialize);
	public List<People> getPeopleByQueryForm(SearchQueryForm form);
}
