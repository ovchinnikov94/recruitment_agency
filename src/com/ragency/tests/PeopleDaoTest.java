package com.ragency.tests;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ragency.dao.EduTypeDaoImpl;
import com.ragency.dao.LangDaoImpl;
import com.ragency.dao.PeopleDaoImpl;
import com.ragency.dao.PostDaoImpl;
import com.ragency.dao.SkillDaoImpl;
import com.ragency.dao.SpecDaoImpl;
import com.ragency.dao.SphereDaoImpl;
import com.ragency.entity.Educationtype;
import com.ragency.entity.Lang;
import com.ragency.entity.People;
import com.ragency.entity.Post;
import com.ragency.entity.Skill;
import com.ragency.entity.Specialization;
import com.ragency.entity.Sphere;

public class PeopleDaoTest {
  @Test
  public void peopleDaoTest() throws SQLException {
	  PostDaoImpl pDao = new PostDaoImpl();
	  Post post = new Post("Post_for_PeopleDaoTest");
	  PeopleDaoImpl pplDao = new PeopleDaoImpl();
	  People people = new People();

	  SpecDaoImpl spDao = new SpecDaoImpl();
	  Specialization spec = new Specialization("C++-programming");
	  EduTypeDaoImpl typeDao = new EduTypeDaoImpl();
	  Educationtype type = new Educationtype("PhD");
	  SphereDaoImpl sphDao = new SphereDaoImpl();
	  Sphere sphere = new Sphere("Service_for_PeopleDaoTest");
	  
	  pDao.addPost(post);
	  typeDao.addEduType(type);
	  spDao.addSpec(spec);
	  sphDao.addSphere(sphere);
	  
	  people.setSpec(spec);
	  people.setType(type);
	  people.setStudyplace("MSU_for_PeopleDaoTest");
	  
	  people.setName("Ivan");
	  people.setMiddlename("Ivanovic");
	  people.setSurname("Ivanov");
	  people.setAge(28);
	  people.setContacts("+9123456789");
	  people.setPost(post);
	  people.setSalary(50000);
	  people.setSphere(sphere);
	  
	  pplDao.addPeople(people);
	  
	  //PLACE FOR TESTS
	  
	  int id = people.getIdpeople();
	  List<Integer> ids = new ArrayList<Integer>();
	  
	  Assert.assertTrue(id == pplDao.getById(id).getIdpeople());  //get By ID check
	  
	  for (People p : pplDao.getAllPeople(false)) ids.add(p.getIdpeople());
	  Assert.assertTrue(ids.contains(id));
	  ids.clear();

	  
	  List<Lang> langs = new ArrayList<Lang>();
	  LangDaoImpl lDao = new LangDaoImpl();
	  for (int i = 0; i < 4; i++) langs.add(lDao.addLangIfNotExists("Lang"+i));
	  for (Lang l : langs) people.getLangs().add(l);
	  pplDao.updatePeople(people);

	  people.getLangs().clear();
	  pplDao.updatePeople(people);
	  for (Lang l : langs) lDao.deleteLang(l);
	  
	  List<Skill> skills = new ArrayList<Skill>();
	  SkillDaoImpl sDao = new SkillDaoImpl();
	  for (int i = 0; i < 4; i++) skills.add(sDao.addSkillIfNotExists("Skill"+i));
	  for (Skill l : skills) people.getSkills().add(l);
	  pplDao.updatePeople(people);

	  people.getSkills().clear();
	  pplDao.updatePeople(people);
	  for (Skill l : skills) sDao.deleteSkill(l);
	  
	  pplDao.deletePeople(people);
	  sphDao.delete(sphere);																		//
	  spDao.deleteSpec(spec);																		//
	  typeDao.deleteEduType(type);																														//
	  pDao.deletePost(post);
  }
}
