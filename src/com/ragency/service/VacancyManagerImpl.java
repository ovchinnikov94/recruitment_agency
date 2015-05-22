package com.ragency.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ragency.dao.VacancyDao;
import com.ragency.entity.Company;
import com.ragency.entity.People;
import com.ragency.entity.SearchQueryForm;
import com.ragency.entity.Vacancy;

@Service
public class VacancyManagerImpl implements VacancyManager {
	
	@Autowired
	private VacancyDao vacancyDao;
		
	@Override
	public void addVacancy(Vacancy vacancy) {
		this.vacancyDao.addVacancy(vacancy);
	}

	@Override
	public void updateVacancy(Vacancy vacancy) {
		this.vacancyDao.updateVacancy(vacancy);
	}

	@Override
	public void deleteVacancy(int id) {
		this.vacancyDao.deleteVacancy(this.vacancyDao.getVacancyById(id));
	}

	@Override
	public Vacancy getVacancyById(int id){
		return this.vacancyDao.getVacancyById(id);
	}
	
	@Override
	public List<Vacancy> getAllVacancies(boolean init) {
		return this.vacancyDao.getAllVacancies(init);
	}

	@Override
	public List<Vacancy> getVacancyByPeople(People people){
		return this.vacancyDao.getVacancyByPeople(people);
	}
	
	@Override
	public List<Vacancy> getVacancyByForm(SearchQueryForm form){
		return this.vacancyDao.getVacancyByQueryForm(form);
	}

	@Override
	public List<Vacancy> getVacancyByCompany(Company company, boolean init) {
		return this.vacancyDao.getVacancyByCompany(company,init);
	}

}
