package com.ragency.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ragency.entity.Lang;
import com.ragency.hibernate.HibernateUtil;

@Repository
public class LangDaoImpl implements LangDao {

	public void addLang(Lang lang) {
		Session session = null;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		session.save(lang);
		lang = (Lang)session.merge(lang);
		session.getTransaction().commit();
		session.close();
	}

	public void updateLang(Lang lang) {
		Session session = null;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		session.update(lang);
		session.getTransaction().commit();
		session.close();
	}

	public void deleteLang(Lang lang) {
		Session session = null;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		session.delete(lang);
		session.getTransaction().commit();
		session.close();
	}

	public Lang getLangById(int id) {
		Session session = null;
		Lang lang = null;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		lang = (Lang)session.get(Lang.class, id);
		session.getTransaction().commit();
		session.close();
		return lang;
	}

	public List<Lang> getAllLangs() {
		Session session = null;
		List<Lang> langs = new ArrayList<Lang>();
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		for (Object o : session.createCriteria(Lang.class).list()) langs.add((Lang)o);
		session.getTransaction().commit();
		session.close();
		return langs;
	}

	public Lang addLangIfNotExists(String langname) {
		Session session = null;
		Lang lang = null;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(Lang.class);
		cr.add(Restrictions.like("langname", langname));
		if (cr.list().isEmpty()) {
			lang = new Lang();
			lang.setLangname(langname);
			session.save(lang);
			lang = (Lang)session.merge(lang);
		}
		else { 
			lang = (Lang)cr.list().get(0);
			lang = (Lang)session.merge(lang);
		}
		session.getTransaction().commit();
		session.close();
		return lang;
	}

}
