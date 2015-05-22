package com.ragency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ragency.entity.Company;
import com.ragency.service.CompanyManager;
import com.ragency.service.VacancyManager;

@Controller
public class CompanyController {
	@Autowired
	private CompanyManager companyManager;
	@Autowired
	private VacancyManager vacancyManager;
	
	@RequestMapping(value = "companies.do")
	public String listCompany(ModelMap map){
		map.addAttribute("page_name", "company_list");
		map.addAttribute("companyList", this.companyManager.getAllCompanies());
		map.addAttribute("newCompany", new Company());
		return "listCompany";
	}
	
	@RequestMapping(value = "addCompany.do", method = RequestMethod.POST)
	public String addCompany(@ModelAttribute(value = "newCompany") Company company, BindingResult result){
		if (result.hasErrors()) return "errorPage";
		this.companyManager.addCompany(company);
		return "redirect: companies.do";
	}
	
	@RequestMapping(value = "deleteCompany{id}.do")
	public String deleteCompany(@PathVariable int id){
		this.companyManager.deleteCompany(id);
		return "redirect: companies.do";
	}
	
	@RequestMapping(value = "showVacByCompany{id}.do")
	public String showVacanciesByCompany(@PathVariable int id, ModelMap map){
		Company company = this.companyManager.getCompanyById(id);
		//company.setIdcompany(id);
		map.addAttribute("page_name", "vacancy_list");
		map.addAttribute("vacancyList", this.vacancyManager.getVacancyByCompany(company, false));
		map.addAttribute("hasParametres", false);
		return "listVacancies";
	}
	
}
