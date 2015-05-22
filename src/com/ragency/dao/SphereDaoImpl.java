package com.ragency.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ragency.entity.Sphere;
import com.ragency.hibernate.HibernateUtil;

@Repository
public class SphereDaoImpl implements SphereDao {

	public void addSphere(Sphere sphere) {
		Session session = null;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		session.save(sphere);
		sphere = (Sphere)session.merge(sphere);
		session.getTransaction().commit();
		session.close();
	}

	public void updateSphere(Sphere sphere) {
		Session session = null;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		session.update(sphere);
		session.getTransaction().commit();
		session.close();
	}

	public void delete(Sphere sphere) {
		Session session = null;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		session.delete(sphere);
		session.getTransaction().commit();
		session.close();
	}

	public Sphere getSphereById(int id) {
		Sphere sphere = null;
		Session session = null;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		sphere = (Sphere)session.get(Sphere.class, id);
		session.getTransaction().commit();
		session.close();
		return sphere;
	}

	public List<Sphere> getAllSpheres() {
		List<Sphere> spheres = new ArrayList<Sphere>();
		Session session = null;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		for (Object o : session.createCriteria(Sphere.class).list()) spheres.add((Sphere)o);
		session.getTransaction().commit();
		session.close();
		return spheres;
	}

	public Sphere addSphereIfNotExists(String spherename) {
		Sphere sphere = null;
		Session session = null;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(Sphere.class);
		cr.add(Restrictions.like("spherename", spherename));
		if (cr.list().isEmpty()) {
			sphere = new Sphere(spherename);
			session.save(sphere);
		}
		else sphere = (Sphere)cr.list().get(0);
		sphere = (Sphere)session.merge(sphere);
		session.getTransaction().commit();
		session.close();
		return sphere;
	}

}
