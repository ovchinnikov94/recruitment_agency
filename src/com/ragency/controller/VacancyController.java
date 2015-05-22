package com.ragency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ragency.editor.LangEditor;
import com.ragency.editor.SkillEditor;
import com.ragency.entity.Lang;
import com.ragency.entity.Skill;
import com.ragency.entity.Vacancy;
import com.ragency.service.CompanyManager;
import com.ragency.service.EduTypeManager;
import com.ragency.service.LangManager;
import com.ragency.service.PeopleManager;
import com.ragency.service.PostManager;
import com.ragency.service.SkillManager;
import com.ragency.service.SpecManager;
import com.ragency.service.SphereManager;
import com.ragency.service.VacancyManager;

@Controller
public class VacancyController {
	@Autowired
	private VacancyManager vacancyManager;
	@Autowired
	private PostManager postManager;
	@Autowired
	private SphereManager sphereManager;
	@Autowired 
	private EduTypeManager eduTypeManager;
	@Autowired
	private SpecManager specManager;
	@Autowired 
	private LangManager langManager;
	@Autowired
	private SkillManager skillManager;
	@Autowired
	private CompanyManager companyManager;
	@Autowired
	private PeopleManager peopleManager;
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(Lang.class, new LangEditor(langManager));
		binder.registerCustomEditor(Skill.class, new SkillEditor(skillManager));
	}
	
	@RequestMapping(value = "vacancies.do", method = RequestMethod.GET)
	public String listVacancies(ModelMap map){
		map.addAttribute("page_name", "vacancy_list");
		map.addAttribute("vacancyList", vacancyManager.getAllVacancies(false));
		map.addAttribute("hasParametres", false);
		return "listVacancies";
	}
	
	@RequestMapping(value="addVacancy.do", method = RequestMethod.GET)
	public String addVacancy(ModelMap map){
		map.addAttribute("action", "saveVacancy.do");
		map.addAttribute("page_name", "edit_vacancy_page");
		map.addAttribute("vacancy", new Vacancy());
		map.addAttribute("skillList", this.skillManager.getAllSkills());
		map.addAttribute("langList", this.langManager.getAllLangs());
		map.addAttribute("postList", this.postManager.getAllPosts());
		map.addAttribute("typeList", this.eduTypeManager.getAllEduTypes());
		map.addAttribute("specList", this.specManager.getAllSpecs());
		map.addAttribute("sphereList", this.sphereManager.getAllSpheres());
		map.addAttribute("companyList", this.companyManager.getAllCompanies());
		return "editVacancy";
	}
	
	@RequestMapping(value="editVacancy{id}.do", method = RequestMethod.GET)
	public String editVacancy(@PathVariable int id, ModelMap map){
		Vacancy v = this.vacancyManager.getVacancyById(id);
		map.addAttribute("page_name", "edit_vacancy_page");
		map.addAttribute("action", "saveUpdateVacancy"+id+".do");
		map.addAttribute("vacancy", v);
		map.addAttribute("skillList", this.skillManager.getAllSkills());
		map.addAttribute("langList", this.langManager.getAllLangs());
		map.addAttribute("postList", this.postManager.getAllPosts());
		map.addAttribute("typeList", this.eduTypeManager.getAllEduTypes());
		map.addAttribute("specList", this.specManager.getAllSpecs());
		map.addAttribute("sphereList", this.sphereManager.getAllSpheres());
		map.addAttribute("companyList", this.companyManager.getAllCompanies());
		map.addAttribute("titleVacancy", v.getPost().getPostname());
		return "editVacancy";
	}
	
	@RequestMapping(value = "showVacancy{id}.do")
	public String showVacancy(@PathVariable int id, ModelMap map){
		map.addAttribute("page_name", "detail_vacancy");
		map.addAttribute("vacancy", this.vacancyManager.getVacancyById(id));
		return "detailVacancy";
	}
	
	@RequestMapping(value = "deleteVacancy{id}.do")
	public String deleteVacancy(@PathVariable int id){
		this.vacancyManager.deleteVacancy(id);
		return "redirect: vacancies.do";
	}
	
	@RequestMapping(value = "saveVacancy.do", method = RequestMethod.POST)
	public String saveVacancy(@ModelAttribute(value = "vacancy") Vacancy vacancy, BindingResult result){
		this.vacancyManager.addVacancy(vacancy);
		return "redirect: showVacancy"+vacancy.getIdvacancy()+".do";
	}
	
	@RequestMapping(value = "saveUpdateVacancy{id}.do", method = RequestMethod.POST)
	public String saveUpdateVacancy(@ModelAttribute(value = "vacancy") Vacancy vacancy, @PathVariable int id, BindingResult result){
		vacancy.setIdvacancy(id);
		this.vacancyManager.updateVacancy(vacancy);
		return "redirect: showVacancy"+vacancy.getIdvacancy()+".do";
	}
	
	@RequestMapping(value = "vacanciesByPeople{id}.do")
	public String vacanciesByPeople(@PathVariable int id, ModelMap map){
		map.addAttribute("page_name", "vacancy_list");
		map.addAttribute("vacancyList", vacancyManager.getVacancyByPeople(this.peopleManager.getById(id)));
		map.addAttribute("hasParametres", false);
		return "listVacancies";
	}
}
