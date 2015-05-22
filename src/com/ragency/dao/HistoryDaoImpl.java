package com.ragency.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ragency.entity.Company;
import com.ragency.entity.History;
import com.ragency.entity.People;
import com.ragency.hibernate.HibernateUtil;

@Repository
public class HistoryDaoImpl implements HistoryDao {

	public void addHistory(History history) {
		Session session = null;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		session.save(history);
		history = (History)session.merge(history);
		session.getTransaction().commit();
		session.close();
	}

	public void updateHistory(History history) {
		Session session = null;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		session.update(history);
		session.getTransaction().commit();
		session.close();
	}

	public void deleteHistory(History history) {
		Session session = null;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		session.delete(history);
		session.getTransaction().commit();
		session.close();
	}

	public History getHistoryById(int id) {
		History history = null;
		Session session = null;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		history = (History)session.get(History.class, id);
		session.getTransaction().commit();
		session.close();
		return history;
	}

	public List<History> getHistoryByPeople(People people){
		List<History> history = new ArrayList<History>();
		Session session = null;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(History.class);
		cr.add(Restrictions.sqlRestriction("idpeople = "+people.getIdpeople())); //eq("idpeople", people.getIdpeople()));
		for (Object o : cr.list()) history.add((History)o);
		session.getTransaction().commit();
		session.close();
		return history;
	}
	
	public List<History> getAllHistory() {
		List<History> history = new ArrayList<History>();
		Session session = null;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(History.class);
		for (Object o : cr.list()) history.add((History)o);
		session.getTransaction().commit();
		session.close();
		return history;
	}

	@SuppressWarnings("unchecked")
	public List<History> getHistoryByCompany(Company company) {
		List<History> history = new ArrayList<History>();
		Session session = null;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(History.class);
		cr.add(Restrictions.eq("company = ",company)); 			
		history = cr.list();
		session.getTransaction().commit();
		session.close();
		return history;
	}

}
