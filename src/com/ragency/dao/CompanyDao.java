package com.ragency.dao;

import java.util.List;

import com.ragency.entity.Company;
import com.ragency.entity.Vacancy;

public interface CompanyDao {
	public void addCompany(Company company);
	public void updateCompany(Company company);
	public void deleteCompany(int id);
	public Company getCompanyById(int id);
	public List<Company> getAllCompanies();
	public Company getCompanyByVacancy(Vacancy vacancy);
}
