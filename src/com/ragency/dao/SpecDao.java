package com.ragency.dao;

import java.util.List;

import com.ragency.entity.Specialization;

public interface SpecDao {
	public void addSpec(Specialization spec);
	public void updateSpec(Specialization spec);
	public void deleteSpec(Specialization spec);
	public Specialization getSpecById(int id);
	public List<Specialization> getAllSpecs();
	public Specialization addSpecIfNotExists(String specname);
}
