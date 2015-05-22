package com.ragency.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ragency.entity.Company;
import com.ragency.entity.Vacancy;
import com.ragency.hibernate.HibernateUtil;

@Repository
public class CompanyDaoImpl implements CompanyDao {
	
	@Override
	public void addCompany(Company company) {
		Session session = null;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		session.save(company);
		company = (Company)session.merge(company);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void updateCompany(Company company) {
		Session session = null;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		session.update(company);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void deleteCompany(int id) {
		Session session = null;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		session.createSQLQuery("delete from company where idcompany="+id+";").executeUpdate();
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Company getCompanyById(int id) {
		Session session = null;
		Company company = new Company();
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		company = (Company)session.get(Company.class, id);
		session.getTransaction().commit();
		session.close();
		return company;
	}

	@Override
	public List<Company> getAllCompanies() {
		Session session = null;
		List<Company> companies = new ArrayList<Company>();
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		for (Object o : session.createCriteria(Company.class).list()) companies.add((Company)o);
		session.getTransaction().commit();
		session.close();
		return companies;
	}

	@Override
	public Company getCompanyByVacancy(Vacancy vacancy) {
		Session session = null;
		Company company = new Company();
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		company = (Company)session.get(Company.class, vacancy.getCompany().getIdcompany());
		session.getTransaction().commit();
		session.close();
		return company;
	}

}
