package com.ragency.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ragency.entity.Company;
import com.ragency.entity.People;
import com.ragency.entity.SearchQueryForm;
import com.ragency.entity.Vacancy;
import com.ragency.hibernate.HibernateUtil;

@Repository
public class VacancyDaoImpl implements VacancyDao {

	@Override
	public void addVacancy(Vacancy vacancy) {
		Session session = null;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		session.save(vacancy);
		vacancy = (Vacancy)session.merge(vacancy);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void updateVacancy(Vacancy vacancy) {
		Session session = null;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		session.update(vacancy);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void deleteVacancy(Vacancy vacancy) {
		Session session = null;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		session.delete(vacancy);
		session.getTransaction().commit();
		session.close();
	}
	
	@Override
	public Vacancy getVacancyById(int id){
		Session session = null;
		Vacancy vacancy = null;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		vacancy = (Vacancy)session.load(Vacancy.class, id);
		Hibernate.initialize(vacancy.getPost());
		Hibernate.initialize(vacancy.getSpec());
		Hibernate.initialize(vacancy.getCompany());
		Hibernate.initialize(vacancy.getSphere());
		Hibernate.initialize(vacancy.getType());
		Hibernate.initialize(vacancy.getLangs());
		Hibernate.initialize(vacancy.getSkills());
		session.getTransaction().commit();
		session.close();
		return vacancy;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Vacancy> getVacancyByPeople(People people){
		List<Vacancy> vacancies = null;
		Session session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(Vacancy.class);
		Criterion post = Restrictions.eq("post", people.getPost());
		Criterion sphere = Restrictions.eq("sphere", people.getSphere());
		Criterion type = Restrictions.eq("type", people.getType());
		
		Criterion and1 = Restrictions.and(post, sphere);

		cr.add(Restrictions.and(and1, type));

		vacancies = cr.list();
		
		if (!vacancies.isEmpty())
			if (people.getLangs() != null) 
				if (!people.getLangs().isEmpty())
					for (int i = 0; i < vacancies.size();) {
						if(!vacancies.get(i).getLangs().containsAll(people.getLangs())) {vacancies.remove(i); continue;}
						i++;
					}
		if (!vacancies.isEmpty())
			if(people.getSkills() != null)
				if (!people.getSkills().isEmpty())
					for (int i = 0; i < vacancies.size();) {
						if (!vacancies.get(i).getSkills().containsAll(people.getSkills())){vacancies.remove(i); continue;}
						i++;
					}
		session.getTransaction().commit();
		session.close();
		return vacancies;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Vacancy> getAllVacancies(boolean init) {
		Session session = null;
		List<Vacancy> vacancies = new ArrayList<Vacancy>();
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		vacancies = session.createCriteria(Vacancy.class).list();
		if (init) {
			for(Vacancy v : vacancies){
				Hibernate.initialize(v.getLangs());
				Hibernate.initialize(v.getSkills());
			}
		}
		session.getTransaction().commit();
		session.close();
		return vacancies;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Vacancy> getVacancyByQueryForm(SearchQueryForm form){
		List<Vacancy> vacancies = null;
		Session session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(Vacancy.class);
		List<Criterion> crs = new ArrayList<Criterion>();
		if (form.getMinSal() > 0) crs.add(Restrictions.ge("salary", form.getMinSal()));
		if(form.getMaxSal() > 0) crs.add(Restrictions.le("salary", form.getMaxSal()));
		if(form.getIdsphere() > 0) crs.add(Restrictions.sqlRestriction("idsphere="+form.getIdsphere()));
		if(form.getIdtype() > 0) crs.add(Restrictions.sqlRestriction("idtype="+form.getIdtype()));
		
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
		vacancies = cr.list();
		
		if (form.getLangs() != null) 
			if (!form.getLangs().isEmpty())
				for (int i = 0; i < vacancies.size();) {
					if(!vacancies.get(i).getLangs().containsAll(form.getLangs())) {vacancies.remove(i); continue;}
					i++;
				}
		if(form.getSkills() != null)
			if (!form.getSkills().isEmpty())
				for (int i = 0; i < vacancies.size();) {
					if (!vacancies.get(i).getSkills().containsAll(form.getSkills())){vacancies.remove(i); continue;}
					i++;
				}
		
		session.getTransaction().commit();
		session.close();
		return vacancies;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Vacancy> getVacancyByCompany(Company company, boolean init) {
		Session session = null;
		List<Vacancy> vacancies = new ArrayList<Vacancy>();;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(Vacancy.class);
		cr.add(Restrictions.eq("company", company));
		vacancies = cr.list();
		if (init) {
			for(Vacancy v : vacancies){
				Hibernate.initialize(v.getLangs());
				Hibernate.initialize(v.getSkills());
			}
		}
		session.getTransaction().commit();
		session.close();
		return vacancies;
	}


	
}
