package com.ragency.service;

import java.util.List;

import com.ragency.entity.Company;
import com.ragency.entity.People;
import com.ragency.entity.SearchQueryForm;
import com.ragency.entity.Vacancy;

public interface VacancyManager {
	public void addVacancy(Vacancy vacancy);
	public void updateVacancy(Vacancy vacancy);
	public void deleteVacancy(int id);
	public Vacancy getVacancyById(int id);
	public List<Vacancy> getAllVacancies(boolean init);
	public List<Vacancy> getVacancyByPeople(People people);
	public List<Vacancy> getVacancyByForm(SearchQueryForm form);
	public List<Vacancy> getVacancyByCompany(Company company, boolean init);
}
