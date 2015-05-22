package com.ragency.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ragency.dao.CompanyDao;
import com.ragency.entity.Company;
import com.ragency.entity.Vacancy;

@Service
public class CompanyManagerImpl implements CompanyManager {

	@Autowired
	private CompanyDao companyDao;
	
	@Override
	public void addCompany(Company company) {
		this.companyDao.addCompany(company);
	}

	@Override
	public void updateCompany(Company company) {
		this.companyDao.updateCompany(company);
	}

	@Override
	public void deleteCompany(int id) {
		this.companyDao.deleteCompany(id);
	}

	@Override
	public Company getCompanyById(int id) {
		return this.companyDao.getCompanyById(id);
	}

	@Override
	public List<Company> getAllCompanies() {
		return this.companyDao.getAllCompanies();
	}

	@Override
	public Company getCompanyByVacancy(Vacancy vacancy) {
		return this.companyDao.getCompanyByVacancy(vacancy);
	}

}
