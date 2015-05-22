package com.ragency.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ragency.dao.SpecDao;
import com.ragency.entity.Specialization;

@Service
public class SpecManagerImpl implements SpecManager {
	@Autowired
	private SpecDao specDao;
	
	@Override
	public void addSpec(Specialization spec) {
		this.specDao.addSpec(spec);
	}

	@Override
	public void updateSpec(Specialization spec) {
		this.specDao.updateSpec(spec);
	}

	@Override
	public void deleteSpec(Specialization spec) {
		this.specDao.deleteSpec(spec);
	}

	@Override
	public Specialization getSpecById(int id) {
		return this.specDao.getSpecById(id);
	}

	@Override
	public List<Specialization> getAllSpecs() {
		return this.specDao.getAllSpecs();
	}

	@Override
	public Specialization addSpecIfNotExists(String specname) {
		return this.specDao.addSpecIfNotExists(specname);
	}

}
