package com.ragency.tests;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ragency.dao.LangDaoImpl;
import com.ragency.entity.Lang;

public class LandDaoTest {
  @Test
  public void landDaoTest() throws SQLException {
	  LangDaoImpl lDao = new LangDaoImpl();
	  String langname = "Lang_for_LangDaoTest";
	  Lang lang = lDao.addLangIfNotExists(langname);
	  Assert.assertTrue(lang.getIdlang() == lDao.getLangById(lang.getIdlang()).getIdlang());
	  Assert.assertTrue(lang.getIdlang() == (lDao.addLangIfNotExists(langname)).getIdlang());
	  lDao.deleteLang(lang);
	  List<Integer> ids = new ArrayList<Integer>();
	  for (Lang l : lDao.getAllLangs()) ids.add(l.getIdlang());
	  
	  Assert.assertFalse(ids.contains(lang.getIdlang()));
	  
	  lang = new Lang("Lang_for_tests");
	  lDao.addLang(lang);
	  
	  Assert.assertTrue(lang.getIdlang() == lDao.getLangById(lang.getIdlang()).getIdlang()); // AddLang Test
	  
	  langname = "Lang_updated";
	  lang.setLangname(langname);
	  lDao.updateLang(lang);
	  
	  Assert.assertTrue(langname.equals(lDao.getLangById(lang.getIdlang()).getLangname())); //Update test  
	  
	  lDao.deleteLang(lang);
  }
}
