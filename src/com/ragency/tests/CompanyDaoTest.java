package com.ragency.tests;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ragency.dao.CompanyDaoImpl;
import com.ragency.dao.EduTypeDaoImpl;
import com.ragency.dao.PostDaoImpl;
import com.ragency.dao.SpecDaoImpl;
import com.ragency.dao.SphereDaoImpl;
import com.ragency.dao.VacancyDaoImpl;
import com.ragency.entity.Company;
import com.ragency.entity.Educationtype;
import com.ragency.entity.Post;
import com.ragency.entity.Specialization;
import com.ragency.entity.Sphere;
import com.ragency.entity.Vacancy;

public class CompanyDaoTest {
	
  @Test
  public void companyDaoTest() throws SQLException {
	  CompanyDaoImpl dao = new CompanyDaoImpl();                              
	  VacancyDaoImpl vDao = new VacancyDaoImpl();								
	  
	  Company cm = null;
	  List<Company> cs = new ArrayList<Company>();
	  List<Integer> ids = new ArrayList<Integer>();
	  List<Integer> ids1 = new ArrayList<Integer>();
	  int id = 0;
	  for (int i = 1; i <= 10; i++) {
		  cm = new Company();
		  cm.setName("Company"+i);
		  cm.setContacts("+7211211111"+i);
		  dao.addCompany(cm);
		  cs.add(cm);
		  ids.add(cm.getIdcompany());
		  if (i == 5) id = cm.getIdcompany();
	  }
	  for (Company co : dao.getAllCompanies()) ids1.add(co.getIdcompany());
	  
	  Assert.assertTrue(ids1.containsAll(ids));									//GetAllCompany
	  
	  Assert.assertEquals(id, dao.getCompanyById(id).getIdcompany()); 			//Id's must be the same
	  
	  cm = cs.get(0);
	  String update = "Company_updated";
	  cm.setName(update);
	  dao.updateCompany(cm);

	  Assert.assertTrue(cm.getName().equals(dao.getCompanyById(cm.getIdcompany()).getName())); // update-method
	  
	  SpecDaoImpl specDao = new SpecDaoImpl();
	  PostDaoImpl postDao = new PostDaoImpl();
	  EduTypeDaoImpl typeDao = new EduTypeDaoImpl();
	  SphereDaoImpl sphereDao = new SphereDaoImpl();
	  
	  Specialization spec = new Specialization("Spec1");
	  Post post = new Post("Java-engineer");
	  Educationtype type = new Educationtype("Bachelor");
	  Sphere sphere = new Sphere("IT industry");
	  
	  specDao.addSpec(spec);
	  postDao.addPost(post);
	  typeDao.addEduType(type);
	  sphereDao.addSphere(sphere);
	  
	  
	  Vacancy v = new Vacancy();
	  v.setSalary(70000);
	  v.setSpec(spec);
	  v.setPost(post);
	  v.setType(type);
	  v.setSphere(sphere);
	  v.setCompany(dao.getCompanyById(id));
	  
	  vDao.addVacancy(v);
	  
	  Assert.assertEquals(id, dao.getCompanyByVacancy(v).getIdcompany()); 		//Getting Company by Vacancy 
	  
	  vDao.deleteVacancy(v);													//
	  specDao.deleteSpec(spec);													//  DELETING GARBAGE IN DB
	  postDao.deletePost(post);													//
	  typeDao.deleteEduType(type);												//
	  sphereDao.delete(sphere);													//
	
	  for (Company c : cs) dao.deleteCompany(c.getIdcompany());								// GETTING BACK OLD INFORMATION
	  
  }
}
