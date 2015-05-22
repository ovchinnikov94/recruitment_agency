package com.ragency.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ragency.entity.Skill;
import com.ragency.hibernate.HibernateUtil;

@Repository
public class SkillDaoImpl implements SkillDao {

	public void addSkill(Skill skill) {
		Session session = null;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		session.save(skill);
		session.getTransaction().commit();
		session.close();
	}

	public void updateSkill(Skill skill) {
		Session session = null;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		session.update(skill);
		session.getTransaction().commit();
		session.close();
	}

	public void deleteSkill(Skill skill) {
		Session session = null;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		session.delete(skill);
		session.getTransaction().commit();
		session.close();
	}

	public Skill getSkillById(int id) {
		Session session = null;
		Skill skill = null;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		skill = (Skill)session.get(Skill.class, id);
		session.getTransaction().commit();
		session.close();
		return skill;
	}

	public List<Skill> getAllSkills() {
		Session session = null;
		List<Skill> skills = new ArrayList<Skill>();
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		for (Object o : session.createCriteria(Skill.class).list()) skills.add((Skill)o);
		session.getTransaction().commit();
		session.close();
		return skills;
	}

	public Skill addSkillIfNotExists(String skillname) {
		Skill skill = null;
		Session session = null;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(Skill.class);
		cr.add(Restrictions.like("skillname", skillname));
		if (cr.list().isEmpty()) {
			skill = new Skill();
			skill.setSkillname(skillname);
			session.save(skill);
		}
		else skill = (Skill)cr.list().get(0);
		session.getTransaction().commit();
		session.close();
		return skill;
	}

}
