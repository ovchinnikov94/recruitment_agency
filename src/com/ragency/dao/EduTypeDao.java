package com.ragency.dao;

import java.util.List;

import com.ragency.entity.Educationtype;

public interface EduTypeDao {
	public void addEduType(Educationtype type);
	public void updateEduType(Educationtype type);
	public void deleteEduType(Educationtype type);
	public Educationtype getEduTypeById(int id);
	public List<Educationtype> getAllEduTypes();
	public Educationtype addEduTypeIfNotExists(String typename);
}
