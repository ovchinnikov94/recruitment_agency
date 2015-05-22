package com.ragency.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ragency.dao.SkillDao;
import com.ragency.entity.Skill;

@Service
public class SkillManagerImpl implements SkillManager {

	@Autowired
	private SkillDao skillDao;
	
	@Override
	public void addSkill(Skill skill) {
		this.skillDao.addSkill(skill);
	}

	@Override
	public void updateSkill(Skill skill) {
		this.skillDao.updateSkill(skill);
	}

	@Override
	public void deleteSkill(Skill skill) {
		this.skillDao.deleteSkill(skill);
	}

	@Override
	public Skill getSkillById(int id) {
		return this.skillDao.getSkillById(id);
	}

	@Override
	public List<Skill> getAllSkills() {
		return this.skillDao.getAllSkills();
	}

	@Override
	public Skill addSkillIfNotExists(String skillname) {
		return this.skillDao.addSkillIfNotExists(skillname);
	}

}
