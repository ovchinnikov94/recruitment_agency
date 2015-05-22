package com.ragency.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ragency.dao.SphereDao;
import com.ragency.entity.Sphere;

@Service
public class SphereManagerImpl implements SphereManager {

	@Autowired
	SphereDao sphereDao;
	
	@Override
	public void addSphere(Sphere sphere) {
		this.sphereDao.addSphere(sphere);
	}

	@Override
	public void updateSphere(Sphere sphere) {
		this.sphereDao.updateSphere(sphere);
	}

	@Override
	public void delete(Sphere sphere) {
		this.sphereDao.delete(sphere);
	}

	@Override
	public Sphere getSphereById(int id) {
		return this.sphereDao.getSphereById(id);
	}

	@Override
	public List<Sphere> getAllSpheres() {
		return this.sphereDao.getAllSpheres();
	}

	@Override
	public Sphere addSphereIfNotExists(String spherename) {
		return this.sphereDao.addSphereIfNotExists(spherename);
	}

}
