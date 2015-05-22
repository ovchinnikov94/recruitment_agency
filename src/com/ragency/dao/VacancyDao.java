package com.ragency.dao;

import java.util.List;

import com.ragency.entity.Company;
import com.ragency.entity.People;
import com.ragency.entity.SearchQueryForm;
import com.ragency.entity.Vacancy;

public interface VacancyDao {
	public void addVacancy(Vacancy vacancy);
	public void updateVacancy(Vacancy vacancy);
	public void deleteVacancy(Vacancy vacancy);
	public Vacancy getVacancyById(int id);
	public List<Vacancy> getVacancyByPeople(People people);
	public List<Vacancy> getAllVacancies(boolean init);
	public List<Vacancy> getVacancyByQueryForm(SearchQueryForm form);
	public List<Vacancy> getVacancyByCompany(Company company,boolean init);
}
