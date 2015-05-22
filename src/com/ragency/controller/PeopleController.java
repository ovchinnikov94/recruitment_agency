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
import com.ragency.entity.People;
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
public class PeopleController {
	
	@Autowired
	private PeopleManager peopleManager;
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
	private VacancyManager vacancyManager;
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(Lang.class, new LangEditor(langManager));
		binder.registerCustomEditor(Skill.class, new SkillEditor(skillManager));
	}
	
	@RequestMapping(value = "people.do", method = RequestMethod.GET)
	public String listPeople(ModelMap map){
		map.addAttribute("page_name","people_list");
		map.addAttribute("hasParametres", false);
		map.addAttribute("peopleList", peopleManager.getAllPeople(false));
		return "listPeople";
	}
	@RequestMapping(value = "showMan{id}.do", method = RequestMethod.GET)
	public String detail(ModelMap map, @PathVariable int id){
		map.addAttribute("page_name","people");
		map.addAttribute("man", this.peopleManager.getById(id));
		return "detailPeople";
	}
	@RequestMapping(value = "editPeople{id}.do", method = RequestMethod.GET)
	public String edit(ModelMap map, @PathVariable int id){
		People man = peopleManager.getById(id);
		map.addAttribute("page_name","edit_people_page");
		map.addAttribute("action", "saveUpdateMan"+id+".do");
		map.addAttribute("postList", this.postManager.getAllPosts());
		map.addAttribute("sphereList", this.sphereManager.getAllSpheres());
		map.addAttribute("typeList", this.eduTypeManager.getAllEduTypes());
		map.addAttribute("specList", this.specManager.getAllSpecs());	
		map.addAttribute("langList", this.langManager.getAllLangs());
		map.addAttribute("skillList", this.skillManager.getAllSkills());
		map.addAttribute("man", man);
		return "editPeople";
	}
	
	@RequestMapping(value = "saveUpdateMan{id}.do", method = RequestMethod.POST)
	public String save(@ModelAttribute("man") People people, @PathVariable int id, BindingResult result){
		if (result.hasErrors()) {
			return "errorPage";
		}
		people.setIdpeople(id);
		this.peopleManager.updatePeople(people);
		return "redirect:showMan"+people.getIdpeople()+".do";
	}
	
	@RequestMapping(value = "addMan.do", method = RequestMethod.GET)
	public String add(ModelMap map){
		map.addAttribute("page_name","edit_people_page");
		map.addAttribute("action", "saveMan.do");
		map.addAttribute("postList", this.postManager.getAllPosts());
		map.addAttribute("sphereList", this.sphereManager.getAllSpheres());
		map.addAttribute("typeList", this.eduTypeManager.getAllEduTypes());
		map.addAttribute("specList", this.specManager.getAllSpecs());
		map.addAttribute("langList", this.langManager.getAllLangs());
		map.addAttribute("skillList", this.skillManager.getAllSkills());
		map.addAttribute("man", new People());
		return "editPeople";
	}
	
	@RequestMapping(value = "saveMan.do", method = RequestMethod.POST)
	public String addCommit(@ModelAttribute("man") People people,
			BindingResult result){
		if (result.hasErrors()){
			return "errorPage";
		}
		this.peopleManager.addPeople(people);
		return "redirect:showMan"+people.getIdpeople()+".do";
	}
	
	@RequestMapping(value = "deleteMan{id}.do")
	public String delete(@PathVariable int id){
		this.peopleManager.deletePeople(id);
		return "redirect:people.do";
	}
	
	@RequestMapping(value = "peopleByVacancy{id}.do")
	public String peopleByVacancy(@PathVariable int id, ModelMap map){
		map.addAttribute("page_name","people_list");
		map.addAttribute("hasParametres", false);
		map.addAttribute("peopleList", this.peopleManager.getPeopleByVacancy(this.vacancyManager.getVacancyById(id)));
		return "listPeople";
	}
	
}
