package com.ragency.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ragency.entity.Specialization;
import com.ragency.hibernate.HibernateUtil;

@Repository
public class SpecDaoImpl implements SpecDao {

	public void addSpec(Specialization spec) {
		Session session = null;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		session.save(spec);
		spec = (Specialization)session.merge(spec);
		session.getTransaction().commit();
		session.close();
	}

	public void updateSpec(Specialization spec) {
		Session session = null;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		session.update(spec);
		session.getTransaction().commit();
		session.close();
	}

	public void deleteSpec(Specialization spec) {
		Session session = null;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		session.delete(spec);
		session.getTransaction().commit();
		session.close();
	}

	public Specialization getSpecById(int id) {
		Session session = null;
		Specialization spec = null;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		spec = (Specialization)session.get(Specialization.class, id);
		session.getTransaction().commit();
		session.close();
		return spec;
	}

	public List<Specialization> getAllSpecs() {
		List<Specialization> specs = new ArrayList<Specialization>();
		Session session = null;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		for (Object o : session.createCriteria(Specialization.class).list()) 
			specs.add((Specialization)o);
		session.getTransaction().commit();
		session.close();
		return specs;
	}

	public Specialization addSpecIfNotExists(String specname){
		Specialization spec = null;
		Session session = null;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(Specialization.class);
		cr.add(Restrictions.like("specname", specname));
		if (cr.list().isEmpty()) {
			spec = new Specialization();
			spec.setSpecname(specname);
			session.save(spec);
		}
		else spec = (Specialization)cr.list().get(0);
		spec = (Specialization)session.merge(spec);
		session.getTransaction().commit();
		session.close();
		return spec;
	}

}
