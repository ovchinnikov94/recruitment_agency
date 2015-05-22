package com.ragency.tests;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ragency.dao.CompanyDaoImpl;
import com.ragency.dao.EduTypeDaoImpl;
import com.ragency.dao.LangDaoImpl;
import com.ragency.dao.PostDaoImpl;
import com.ragency.dao.SkillDaoImpl;
import com.ragency.dao.SpecDaoImpl;
import com.ragency.dao.SphereDaoImpl;
import com.ragency.dao.VacancyDaoImpl;
import com.ragency.entity.Company;
import com.ragency.entity.Educationtype;
import com.ragency.entity.Lang;
import com.ragency.entity.Post;
import com.ragency.entity.Skill;
import com.ragency.entity.Specialization;
import com.ragency.entity.Sphere;
import com.ragency.entity.Vacancy;

public class VacancyDaoTest {
  @Test
  public void vacancyDaoTest() throws SQLException {
	  CompanyDaoImpl dao = new CompanyDaoImpl();                              
	  VacancyDaoImpl vDao = new VacancyDaoImpl();	
	  SpecDaoImpl specDao = new SpecDaoImpl();
	  PostDaoImpl postDao = new PostDaoImpl();
	  EduTypeDaoImpl typeDao = new EduTypeDaoImpl();
	  SphereDaoImpl sphereDao = new SphereDaoImpl();
	  
	  Company cm = new Company();
	  cm.setName("Company_for_VacancyDaoTest");
	  cm.setContacts("+7211211111");
	  dao.addCompany(cm);
	  
	  Specialization spec = new Specialization("Spec_for VacancyDaoTest");
	  Post post = new Post("Java-engineer_for VacancyDaoTest");
	  Educationtype type = new Educationtype("Bachelor_for VacancyDaoTest");
	  Sphere sphere = new Sphere("IT_industry_for VacancyDaoTest");
	  
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
	  v.setCompany(cm);
	  
	  vDao.addVacancy(v);
	  
	  int id = v.getIdvacancy();
	  List<Integer> ids = new ArrayList<Integer>();
	  

	  for (Vacancy vc : vDao.getVacancyByCompany(cm, false)) ids.add(vc.getIdvacancy());
	  Assert.assertTrue(ids.contains(id));
	  ids.clear();

	  
	  List<Lang> langs = new ArrayList<Lang>();
	  LangDaoImpl lDao = new LangDaoImpl();
	  for (int i = 0; i < 4; i++) langs.add(lDao.addLangIfNotExists("Lang"+i));
	  for (Lang l : langs) v.getLangs().add(l);
	  vDao.updateVacancy(v);


	  v.getLangs().clear();
	  vDao.updateVacancy(v);
	  for (Lang l : langs) lDao.deleteLang(l);
	  
	  List<Skill> skills = new ArrayList<Skill>();
	  SkillDaoImpl sDao = new SkillDaoImpl();
	  for (int i = 0; i < 4; i++) skills.add(sDao.addSkillIfNotExists("Skill"+i));
	  for (Skill l : skills) v.getSkills().add(l);
	  vDao.updateVacancy(v);


	  v.getSkills().clear();
	  vDao.updateVacancy(v);
	  for (Skill l : skills) sDao.deleteSkill(l);
	  
	  
	  
	  vDao.deleteVacancy(v);													//
	  specDao.deleteSpec(spec);													//  DELETING GARBAGE IN DB
	  postDao.deletePost(post);													//
	  typeDao.deleteEduType(type);												//
	  sphereDao.delete(sphere);			
	  dao.deleteCompany(cm.getIdcompany());
	  
	  for (Vacancy vc : vDao.getAllVacancies(false)) ids.add(vc.getIdvacancy());
	  Assert.assertTrue(!ids.contains(id));
	  ids.clear();
  }
}
