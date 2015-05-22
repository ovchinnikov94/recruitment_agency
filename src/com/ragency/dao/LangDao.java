package com.ragency.dao;

import java.util.List;

import com.ragency.entity.Lang;

public interface LangDao {
	public void addLang(Lang lang);
	public void updateLang(Lang lang);
	public void deleteLang(Lang lang);
	public Lang getLangById(int id);
	public List<Lang> getAllLangs();
	public Lang addLangIfNotExists(String langname);
}
