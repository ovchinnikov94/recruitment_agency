package com.ragency.service;

import java.util.List;

import com.ragency.entity.Skill;

public interface SkillManager {
	public void addSkill(Skill skill);
	public void updateSkill(Skill skill);
	public void deleteSkill(Skill skill);
	public Skill getSkillById(int id);
	public List<Skill> getAllSkills();
	public Skill addSkillIfNotExists(String skillname);
}
