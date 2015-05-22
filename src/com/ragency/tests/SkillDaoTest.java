package com.ragency.tests;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ragency.dao.SkillDaoImpl;
import com.ragency.entity.Skill;

public class SkillDaoTest {
  @Test
  public void skillDaoTest() throws SQLException {
	  SkillDaoImpl sDao = new SkillDaoImpl();
	  Skill skill = sDao.addSkillIfNotExists("skill_for_SkillDaoTest");
	  
	  Assert.assertTrue(skill.getIdskill() == sDao.addSkillIfNotExists("skill_for_SkillDaoTest").getIdskill());
	  
	  Assert.assertTrue(skill.getIdskill() == sDao.getSkillById(skill.getIdskill()).getIdskill()); // getById()-method test
	  sDao.deleteSkill(skill);

	  List<Integer> ids = new ArrayList<Integer>();
	  for (Skill s : sDao.getAllSkills()) ids.add(s.getIdskill());
	  
	  Assert.assertTrue(!ids.contains(skill.getIdskill()));
	 
	  skill = new Skill("Skill_for_tests");
	  sDao.addSkill(skill);
	  ids.clear();
	  for (Skill s : sDao.getAllSkills()) ids.add(s.getIdskill());
	  
	  Assert.assertTrue(ids.contains(skill.getIdskill()));   // addSkill() method test
	  
	  String str = "Skill_updated";
	  skill.setSkillname(str);
	  sDao.updateSkill(skill);
	  
	  Assert.assertTrue(str.equals(sDao.getSkillById(skill.getIdskill()).getSkillname())); // update method test
	  
	  sDao.deleteSkill(skill);
  }
}
