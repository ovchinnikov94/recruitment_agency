package com.ragency.service;

import java.util.Collection;

import com.ragency.entity.Company;
import com.ragency.entity.Vacancy;

public interface CompanyManager {
	public void addCompany(Company company);
	public void updateCompany(Company company);
	public void deleteCompany(int id);
	public Company getCompanyById(int id);
	public Collection<Company> getAllCompanies();
	public Company getCompanyByVacancy(Vacancy vacancy);
}
