package com.ragency.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ragency.entity.People;
import com.ragency.entity.SearchQueryForm;
import com.ragency.entity.Vacancy;
import com.ragency.hibernate.HibernateUtil;

@Repository
public class PeopleDaoImpl implements PeopleDao {
	
	@Override
	public void addPeople(People people) {
		Session session = null;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		session.save(people);
		people = (People)session.merge(people);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void updatePeople(People people) {
		Session session = null;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		session.update(people);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public People getById(int id) {
		Session session = null;
		People people = null;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		people = (People)session.get(People.class, id);
		Hibernate.initialize(people.getPost());
		Hibernate.initialize(people.getSpec());
		Hibernate.initialize(people.getSphere());
		Hibernate.initialize(people.getType());
		Hibernate.initialize(people.getLangs());
		Hibernate.initialize(people.getSkills());
		session.getTransaction().commit();
		session.close();
		return people;
	}

	@Override
	public void deletePeople(People people) {
		Session session = null;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		session.delete(people);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<People> getAllPeople(boolean initialize) {
		Session session = null;
		List<People> people = new ArrayList<People>();
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(People.class);
		people = cr.list();
		if (initialize){
			for (People p : people) {
				Hibernate.initialize(p.getLangs());
				Hibernate.initialize(p.getSkills());
			}
		}
		session.getTransaction().commit();
		session.close();
		return people;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<People> getPeopleByQueryForm(SearchQueryForm form){
		List<People> people = null;
		Session session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(People.class);
		List<Criterion> crs = new ArrayList<Criterion>();
		if (form.getMinSal() > 0) crs.add(Restrictions.ge("salary", form.getMinSal()));
		if(form.getMaxSal() > 0) crs.add(Restrictions.le("salary", form.getMaxSal()));
		if(form.getIdsphere() > 0) crs.add(Restrictions.sqlRestriction("idsphere="+form.getIdsphere()));
		if(form.getIdtype() > 0) crs.add(Restrictions.sqlRestriction("idtype="+form.getIdtype()));
		if(!form.getSearchQuery().isEmpty()) crs.add(Restrictions.or(Restrictions.eq("name", form.getSearchQuery()),
				Restrictions.eq("surname", form.getSearchQuery())));
		
		while (crs.size() > 1) {
			List<Criterion> tmp = new ArrayList<Criterion>();
			int i = 0;
			while (i < crs.size()) {
				if (i+1 < crs.size()) {tmp.add(Restrictions.and(crs.get(i), crs.get(i+1))); i+=2;}
				else {tmp.add(crs.get(i)); i++;}
			}
			crs = tmp;
		}
		
		if (!crs.isEmpty())
			cr.add(crs.get(0));
		people = cr.list();
		if (!people.isEmpty())
			if (form.getLangs() != null) 
				if (!form.getLangs().isEmpty())
					for (int i = 0; i < people.size();) {
						if(!people.get(i).getLangs().containsAll(form.getLangs())) {people.remove(i); continue;}
						i++;
					}
		if (!people.isEmpty())
			if(form.getSkills() != null)
				if (!form.getSkills().isEmpty())
					for (int i = 0; i < people.size();) {
						if (!people.get(i).getSkills().containsAll(form.getSkills())){people.remove(i); continue;}
						i++;
					}
		
		session.getTransaction().commit();
		session.close();
		return people;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<People> getPeopleByVacancy(Vacancy vacancy){
		List<People> people = null;
		Session session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(People.class);
		Criterion post = Restrictions.eq("post", vacancy.getPost());
		Criterion sphere = Restrictions.eq("sphere", vacancy.getSphere());
		Criterion type = Restrictions.eq("type", vacancy.getType());

		Criterion and1 = Restrictions.and(post, sphere);
		
		cr.add(Restrictions.and(and1, type)); 
		
		people = cr.list();
		if (vacancy.getLangs() != null) 
			if (!vacancy.getLangs().isEmpty())
				for (int i = 0; i < people.size();) {
					if(!people.get(i).getLangs().containsAll(vacancy.getLangs())) {people.remove(i); continue;}
					i++;
				}
		if(vacancy.getSkills() != null)
			if (!vacancy.getSkills().isEmpty())
				for (int i = 0; i < people.size();) {
					if (!people.get(i).getSkills().containsAll(vacancy.getSkills())){people.remove(i); continue;}
					i++;
				}
		session.getTransaction().commit();
		session.close();
		return people;
	}
	
}
