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
import com.ragency.entity.History;
import com.ragency.entity.Lang;
import com.ragency.entity.People;
import com.ragency.entity.SearchQueryForm;
import com.ragency.entity.Skill;
import com.ragency.service.CompanyManager;
import com.ragency.service.EduTypeManager;
import com.ragency.service.HistoryManager;
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
	@Autowired
	private HistoryManager historyManager;
	@Autowired
	private CompanyManager companyManager;
	
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
	
	@RequestMapping(value = "showHist{id}.do")
	public String showHist(@PathVariable int id, ModelMap map){
		People people = this.peopleManager.getById(id);
		map.addAttribute("page_name","history");
		map.addAttribute("listHistory", this.historyManager.getHistoryByPeople(id));
		map.addAttribute("name", people.getName());
		map.addAttribute("middlename", people.getMiddlename());
		map.addAttribute("surname", people.getSurname());
		map.addAttribute("idpeople", id);
		map.addAttribute("postList", this.postManager.getAllPosts());
		map.addAttribute("companyList", this.companyManager.getAllCompanies());
		map.addAttribute("hist", new History());
		return "listHistory";
	}
	
	@RequestMapping(value = "deleteHistory{id}.do")
	public String deleteHistory(@PathVariable int id){
		History hist = this.historyManager.getHistoryById(id);
		int idpeople = hist.getPeople().getIdpeople();
		this.historyManager.deleteHistory(hist);
		return "redirect:showHist"+idpeople+".do";
	}
	
	@RequestMapping(value = "addHist{id}.do")
	public String addHist(@PathVariable int id, @ModelAttribute(value = "hist") History history, BindingResult result){
		People p = new People();
		p.setIdpeople(id);
		history.setPeople(p);
		this.historyManager.addHistory(history);
		return "redirect:showHist"+id+".do";
	}
	
	
	
	
}
