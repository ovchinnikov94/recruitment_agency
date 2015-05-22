package com.ragency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ragency.editor.LangEditor;
import com.ragency.editor.SkillEditor;
import com.ragency.entity.Lang;
import com.ragency.entity.SearchQueryForm;
import com.ragency.entity.Skill;
import com.ragency.service.EduTypeManager;
import com.ragency.service.LangManager;
import com.ragency.service.PeopleManager;
import com.ragency.service.PostManager;
import com.ragency.service.SkillManager;
import com.ragency.service.SpecManager;
import com.ragency.service.SphereManager;
import com.ragency.service.VacancyManager;

@Controller
public class MainController {
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
	private PeopleManager peopleManager;
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(Lang.class, new LangEditor(langManager));
		binder.registerCustomEditor(Skill.class, new SkillEditor(skillManager));
	}
	
	@RequestMapping(value="search.do", method = RequestMethod.GET)
	public String search(ModelMap map){
		map.addAttribute("page_name", "search_page");
		map.addAttribute("searchQueryForm", new SearchQueryForm());
		map.addAttribute("sphereList", this.sphereManager.getAllSpheres());
		map.addAttribute("langList", this.langManager.getAllLangs());
		map.addAttribute("skillList", this.skillManager.getAllSkills());
		map.addAttribute("typeList", this.eduTypeManager.getAllEduTypes());
		return "search";
	}
	
	@RequestMapping(value="implSearch.do", method = RequestMethod.POST)
	public String implSearch(@ModelAttribute(value="searchQueryForm") SearchQueryForm form, ModelMap map){
		if (form.getPlace().equals("vacancy")) {
			map.addAttribute("page_name","vacancy_list");
			map.addAttribute("hasParametres", true);
			map.addAttribute("parametres", form);
			map.addAttribute("vacancyList", this.vacancyManager.getVacancyByForm(form));
			return "listVacancies";
		}
		else {
			map.addAttribute("page_name","people_list");
			map.addAttribute("hasParametres", true);
			map.addAttribute("parametres", form);
			map.addAttribute("peopleList", this.peopleManager.getPeopleByForm(form));
			return "listPeople";
		}
	}
}
