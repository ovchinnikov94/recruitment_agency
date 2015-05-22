package com.ragency.editor;

import java.beans.PropertyEditorSupport;

import com.ragency.entity.Skill;
import com.ragency.service.SkillManager;

public class SkillEditor extends PropertyEditorSupport {
	private SkillManager skillManager;
	
	public SkillEditor(SkillManager skillManager){
		this.skillManager = skillManager;
	}
	@Override
	public String getAsText(){
		return ((Skill)getValue()).getSkillname();
	}
	
	@Override
	public void setAsText(String str) {
		Integer id = new Integer(str);
		Skill skill = this.skillManager.getSkillById(id);
		setValue(skill);
	}
	
}
