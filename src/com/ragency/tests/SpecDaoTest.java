package com.ragency.tests;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ragency.dao.SpecDaoImpl;
import com.ragency.entity.Specialization;

public class SpecDaoTest {
  @Test
  public void specDaoTest() throws SQLException {
	  SpecDaoImpl sDao = new SpecDaoImpl();
	  Specialization spec = sDao.addSpecIfNotExists("Spec_for_SpecDaoTest");
	  
	  Assert.assertTrue(spec.getIdspec() == sDao.addSpecIfNotExists("Spec_for_SpecDaoTest").getIdspec());
	  
	  Assert.assertTrue(spec.getIdspec() == sDao.getSpecById(spec.getIdspec()).getIdspec()); // getById method
	  
	  String update_test = "Spec_for_test_updated";
	  spec.setSpecname(update_test);
	  sDao.updateSpec(spec);
	  
	  Assert.assertTrue(update_test.equals(sDao.getSpecById(spec.getIdspec()).getSpecname())); // update method
	  
	  sDao.deleteSpec(spec);
	  
	  List<Integer> ids = new ArrayList<Integer>();
	  for (Specialization s : sDao.getAllSpecs()) ids.add(s.getIdspec());
	  
	  Assert.assertTrue(!ids.contains(spec.getIdspec()));  
  }
}
