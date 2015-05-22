package com.ragency.tests;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ragency.dao.SphereDaoImpl;
import com.ragency.entity.Sphere;

public class SphereDaoTest {
  @Test
  public void sphereDaoTest() throws SQLException {
	  SphereDaoImpl sDao = new SphereDaoImpl();
	  Sphere sphere = sDao.addSphereIfNotExists("Sphere_for_SphereDaoTEst");
	  
	  Assert.assertTrue(sphere.getIdsphere() == sDao.addSphereIfNotExists("Sphere_for_SphereDaoTEst").getIdsphere());
	  
	  Assert.assertTrue(sphere.getIdsphere() == sDao.getSphereById(sphere.getIdsphere()).getIdsphere()); //get by id test
	  
	  String update = "Sphere_forSphereTest_updated";
	  sphere.setSpherename(update);
	  sDao.updateSphere(sphere);
	  
	  Assert.assertTrue(sphere.getSpherename().equals(sDao.getSphereById(sphere.getIdsphere()).getSpherename())); //update test
	  
	  sDao.delete(sphere);
	  
	  List<Integer> ids = new ArrayList<Integer>();
	  for (Sphere s : sDao.getAllSpheres()) ids.add(s.getIdsphere());
	  
	  Assert.assertTrue(!ids.contains(sphere.getIdsphere()));	  
  }
}
