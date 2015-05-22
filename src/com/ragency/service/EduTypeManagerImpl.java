package com.ragency.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ragency.dao.EduTypeDao;
import com.ragency.entity.Educationtype;

@Service
public class EduTypeManagerImpl implements EduTypeManager {

	@Autowired
	private EduTypeDao eduTypeDao;
	
	@Override
	public void addEduType(Educationtype type) {
		this.eduTypeDao.addEduType(type);
	}

	@Override
	public void updateEduType(Educationtype type) {
		this.eduTypeDao.updateEduType(type);
	}

	@Override
	public void deleteEduType(Educationtype type) {
		this.eduTypeDao.deleteEduType(type);
	}

	@Override
	public Educationtype getEduTypeById(int id) {
		return this.eduTypeDao.getEduTypeById(id);
	}

	@Override
	public List<Educationtype> getAllEduTypes() {
		return this.eduTypeDao.getAllEduTypes();
	}

	@Override
	public Educationtype addEduTypeIfNotExists(String typename) {
		return this.eduTypeDao.addEduTypeIfNotExists(typename);
	}

}
