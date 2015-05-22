package com.ragency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ragency.entity.Educationtype;
import com.ragency.entity.Lang;
import com.ragency.entity.Post;
import com.ragency.entity.Skill;
import com.ragency.entity.Specialization;
import com.ragency.entity.Sphere;
import com.ragency.service.EduTypeManager;
import com.ragency.service.LangManager;
import com.ragency.service.PostManager;
import com.ragency.service.SkillManager;
import com.ragency.service.SpecManager;
import com.ragency.service.SphereManager;

@Controller
public class OtherEntityController {
	
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
	
	@RequestMapping(value="other.do", method = RequestMethod.GET)
	public String otherEdit(ModelMap map){
		map.addAttribute("page_name","edit_other_page");
		map.addAttribute("post", new Post());
		map.addAttribute("sphere", new Sphere());
		map.addAttribute("type", new Educationtype());
		map.addAttribute("spec", new Specialization());
		map.addAttribute("lang", new Lang());
		map.addAttribute("skill", new Skill());
		return "editOther";
	}
	
	@RequestMapping(value = "addNewPost.do", method = RequestMethod.POST)
	public String addNewPost(@ModelAttribute("post") Post post, BindingResult result){
		if (result.hasErrors())
			return "errorPage";
		this.postManager.addPostIfNotExists(post.getPostname());
		return "redirect:other.do";
	}
	
	@RequestMapping(value = "addNewSphere.do", method = RequestMethod.POST)
	public String addNewSphere(@ModelAttribute("sphere") Sphere sphere, BindingResult result){
		if (result.hasErrors())
			return "errorPage";
		this.sphereManager.addSphereIfNotExists(sphere.getSpherename());
		return "redirect:other.do";
	}
	
	@RequestMapping(value = "addNewType.do", method = RequestMethod.POST)
	public String addNewType(@ModelAttribute("type") Educationtype type, BindingResult result){
		if (result.hasErrors())
			return "errorPage";
		this.eduTypeManager.addEduTypeIfNotExists(type.getTypename());
		return "redirect:other.do";
	}
	
	@RequestMapping(value = "addNewSpec.do", method = RequestMethod.POST)
	public String addNewSpec(@ModelAttribute("spec") Specialization spec, BindingResult result){
		if (result.hasErrors())
			return "errorPage";
		this.specManager.addSpecIfNotExists(spec.getSpecname());
		return "redirect:other.do";
	}
	@RequestMapping(value = "addNewLang.do", method = RequestMethod.POST)
	public String addNewLang(@ModelAttribute("lang") Lang lang, BindingResult result){
		if (result.hasErrors())
			return "errorPage";
		this.langManager.addLangIfNotExists(lang.getLangname());
		return "redirect:other.do";
	}
	@RequestMapping(value = "addNewSkill.do", method = RequestMethod.POST)
	public String addNewSkill(@ModelAttribute("skill") Skill skill, BindingResult result){
		if (result.hasErrors())
			return "errorPage";
		this.skillManager.addSkillIfNotExists(skill.getSkillname());
		return "redirect:other.do";
	}
}
