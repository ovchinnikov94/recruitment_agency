package com.ragency.tests;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ragency.dao.CompanyDaoImpl;
import com.ragency.dao.EduTypeDaoImpl;
import com.ragency.dao.HistoryDaoImpl;
import com.ragency.dao.PeopleDaoImpl;
import com.ragency.dao.PostDaoImpl;
import com.ragency.dao.SpecDaoImpl;
import com.ragency.dao.SphereDaoImpl;
import com.ragency.entity.Company;
import com.ragency.entity.Educationtype;
import com.ragency.entity.History;
import com.ragency.entity.People;
import com.ragency.entity.Post;
import com.ragency.entity.Specialization;
import com.ragency.entity.Sphere;

public class HistoryDaoTest {
  @SuppressWarnings("deprecation")
@Test
  public void historyDaoTest() throws SQLException {
	  HistoryDaoImpl hDao = new  HistoryDaoImpl();
	  List<History> oldHistory = hDao.getAllHistory();												// SAVE OLD HISTORY
	  for (History h : oldHistory) hDao.deleteHistory(h);											// CLEAN HISTORY
	  
	  Assert.assertTrue(hDao.getAllHistory().isEmpty());											// TEST deleteHistory()
	  
	  PostDaoImpl pDao = new PostDaoImpl();
	  Post post = new Post("Post_for_HistoryDaoTest");
	  CompanyDaoImpl cDao = new CompanyDaoImpl();
	  Company company = new Company();
	  company.setName("Comp_for_HistoryDaoTest");
	  company.setContacts("+71000000000");
	  
	  PeopleDaoImpl pplDao = new PeopleDaoImpl();
	  People people = new People();
	  SpecDaoImpl spDao = new SpecDaoImpl();
	  Specialization spec = new Specialization("Java-programming");
	  EduTypeDaoImpl typeDao = new EduTypeDaoImpl();
	  Educationtype type = new Educationtype("PhD");
	  SphereDaoImpl sphDao = new SphereDaoImpl();
	  Sphere sphere = new Sphere("IT-ind_for_HistDaoTest");
	  
	  pDao.addPost(post);
	  cDao.addCompany(company);
	  typeDao.addEduType(type);
	  spDao.addSpec(spec);
	  sphDao.addSphere(sphere);
	  
	  people.setSpec(spec);
	  people.setType(type);
	  people.setStudyplace("MSU_for_HistoryDaoTest");
	  
	  people.setName("Petr");
	  people.setMiddlename("Petrovic");
	  people.setSurname("Petrov");
	  people.setAge(28);
	  people.setContacts("+874222222222");
	  people.setPost(post);
	  people.setSalary(50000);
	  people.setSphere(sphere);
	  
	  pplDao.addPeople(people);
	  
	  History hist = new History();
	  hist.setSalary(50000);
	  hist.setDateFrom(new Date(10, 12,2010));
	  hist.setDateTo(new Date(10, 12, 2012));
	  hist.setCompany(company);
	  hist.setPost(post);
	  hist.setPeople(people);
	  
	  hDao.addHistory(hist);																		
	  
	  //System.out.println("History: "+hist.getIdhistory()+"=="+hist.getCompany().getIdcompany());
	  //System.out.println("Company:"+company.getIdcompany()+"=="+company.getName());
	  
	  int id = hist.getIdhistory();
	  Assert.assertTrue(id == hDao.getHistoryById(id).getIdhistory()); 								// TEST addHistory()
	  Assert.assertTrue(id == hDao.getHistoryByCompany(company).get(0).getIdhistory()); 			// TEST  getHistoryByCompany()
	  Assert.assertTrue(id == hDao.getHistoryByPeople(people).get(0).getIdhistory()); 				// TEST getHistoryByPeople()
	  
	  
	  
	  for (History h : hDao.getAllHistory()) hDao.deleteHistory(h);									// REMOVE GARBAGE IN DB
	  pplDao.deletePeople(people);																	//
	  sphDao.delete(sphere);																		//
	  spDao.deleteSpec(spec);																		//
	  typeDao.deleteEduType(type);																	//
	  cDao.deleteCompany(company.getIdcompany());																	//
	  pDao.deletePost(post);
	  
	  for (History h : oldHistory) hDao.addHistory(h);												//	GET BACK OLD HISTORY
  }
}
