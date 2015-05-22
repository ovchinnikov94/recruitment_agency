package com.ragency.editor;

import java.beans.PropertyEditorSupport;

import com.ragency.entity.Lang;
import com.ragency.service.LangManager;

public class LangEditor extends PropertyEditorSupport{
	private LangManager langManager;
	
	public LangEditor(LangManager langManager){
		this.langManager = langManager;
	}
	@Override
	public String getAsText(){
		return ((Lang)getValue()).getLangname();
	}
	@Override
	public void setAsText(String incomingId)  {
		Integer id = new Integer(incomingId);
		Lang lang = this.langManager.getLangById(id);
		setValue(lang);
	}
}
