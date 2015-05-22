package com.ragency.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ragency.entity.Educationtype;
import com.ragency.hibernate.HibernateUtil;

@Repository
public class EduTypeDaoImpl implements EduTypeDao {

	@Override
	public void addEduType(Educationtype type) {
		Session session = null;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		session.save(type);
		type = (Educationtype)session.merge(type); 
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void updateEduType(Educationtype type) {
		Session session = null;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		session.update(type);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void deleteEduType(Educationtype type) {
		Session session = null;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		session.delete(type);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Educationtype getEduTypeById(int id) {
		Session session = null;
		Educationtype type = null;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		type = (Educationtype)session.get(Educationtype.class, id);
		session.getTransaction().commit();
		session.close();
		return type;
	}

	@Override
	public List<Educationtype> getAllEduTypes() {
		Session session = null;
		List<Educationtype> types = new ArrayList<Educationtype>();
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		for (Object o : session.createCriteria(Educationtype.class).list()) types.add((Educationtype)o);
		session.getTransaction().commit();
		session.close();
		return types;
	}

	@Override
	public Educationtype addEduTypeIfNotExists(String typename) {
		Session session = null;
		Educationtype type = null;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(Educationtype.class);
		cr.add(Restrictions.like("typename", typename));
		if (cr.list().isEmpty()) {
			type = new Educationtype();
			type.setTypename(typename);
			session.save(type);
		}
		else 
			type = (Educationtype)cr.list().get(0);
		type = (Educationtype)session.merge(type);
		session.getTransaction().commit();
		session.close();
		return type;
	}

}
