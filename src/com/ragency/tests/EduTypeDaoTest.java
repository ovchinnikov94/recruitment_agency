package com.ragency.tests;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ragency.dao.EduTypeDaoImpl;
import com.ragency.entity.Educationtype;

public class EduTypeDaoTest {
  @Test
  public void edutypetest() throws SQLException {
	  EduTypeDaoImpl eduDao = new EduTypeDaoImpl();
	  Educationtype type = eduDao.addEduTypeIfNotExists("Magister");;
	  
	  Assert.assertTrue(type.getTypename().equals(eduDao.getEduTypeById(type.getIdtype()).getTypename()));
	  List<Integer> ids = new ArrayList<Integer>();
	  for (Educationtype t : eduDao.getAllEduTypes()) ids.add(t.getIdtype()); 							//
	  Assert.assertTrue(ids.contains(type.getIdtype()));												// CHECLING GET_ALL_EDU_TYPES
	  Assert.assertTrue(type.getIdtype() == eduDao.addEduTypeIfNotExists("Magister").getIdtype()); 		// CHECKING ADD_IF_NOT_EXISTS
	  
	  String update = "Bachelor_update";
	  
	  type.setTypename(update);
	  
	  eduDao.updateEduType(type);
	  
	  Assert.assertTrue(type.getTypename().equals( eduDao.getEduTypeById(type.getIdtype()).getTypename() )); // Update check
	  
	  eduDao.deleteEduType(type);
	  Assert.assertTrue(!eduDao.getAllEduTypes().contains(type)); 										//Checking DELETING
  }
}
