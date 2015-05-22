package com.ragency.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ragency.dao.LangDao;
import com.ragency.entity.Lang;

@Service
public class LangManagerImpl implements LangManager {

	@Autowired
	LangDao langDao;
	
	@Override
	public void addLang(Lang lang) {
		this.langDao.addLang(lang);
	}

	@Override
	public void updateLang(Lang lang) {
		this.langDao.updateLang(lang);
	}

	@Override
	public void deleteLang(Lang lang) {
		this.langDao.deleteLang(lang);
	}

	@Override
	public Lang getLangById(int id) {
		return this.langDao.getLangById(id);
	}

	@Override
	public List<Lang> getAllLangs() {
		return this.langDao.getAllLangs();
	}

	@Override
	public Lang addLangIfNotExists(String langname) {
		return this.langDao.addLangIfNotExists(langname);
	}

}
