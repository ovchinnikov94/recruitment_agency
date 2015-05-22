package com.ragency.service;

import java.util.List;

import com.ragency.entity.Sphere;

public interface SphereManager {
	public void addSphere(Sphere sphere);
	public void updateSphere(Sphere sphere);
	public void delete(Sphere sphere);
	public Sphere getSphereById(int id);
	public List<Sphere> getAllSpheres();
	public Sphere addSphereIfNotExists(String spherename);
}
