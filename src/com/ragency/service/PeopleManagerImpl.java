package com.ragency.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ragency.dao.PeopleDao;
import com.ragency.entity.People;
import com.ragency.entity.SearchQueryForm;
import com.ragency.entity.Vacancy;

@Service
public class PeopleManagerImpl implements PeopleManager {
	
	@Autowired
	private PeopleDao peopleDao;
	
	@Override
	public void addPeople(People people) {
		this.peopleDao.addPeople(people);
	}

	@Override
	public void updatePeople(People people) {
		this.peopleDao.updatePeople(people);
	}

	@Override
	public People getById(int id) {
		return this.peopleDao.getById(id);
	}

	@Override
	public void deletePeople(int id) {
		this.peopleDao.deletePeople(this.peopleDao.getById(id));
	}

	@Override
	public List<People> getAllPeople(boolean init) {
		return this.peopleDao.getAllPeople(init);
	}

	@Override
	public List<People> getPeopleByVacancy(Vacancy vacancy){
		return this.peopleDao.getPeopleByVacancy(vacancy);
	}
	
	@Override
	public List<People> getPeopleByForm(SearchQueryForm form){
		return this.peopleDao.getPeopleByQueryForm(form);
	}

}
