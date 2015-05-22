package com.ragency.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ragency.entity.Post;
import com.ragency.hibernate.HibernateUtil;

@Repository
public class PostDaoImpl implements PostDao {

	public void addPost(Post post) {
		Session session = null;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		session.save(post);
		session.getTransaction().commit();
		session.close();
	}

	public void updatePost(Post post) {
		Session session = null;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		session.update(post);
		session.getTransaction().commit();
		session.close();
	}

	public void deletePost(Post post) {
		Session session = null;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		session.delete(post);
		session.getTransaction().commit();
		session.close();
	}

	public Post getPostById(int id) {
		Post post = null;
		Session session = null;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		post = (Post)session.get(Post.class, id);
		session.getTransaction().commit();
		session.close();
		return post;
	}

	public List<Post> getAllPosts() {
		List<Post> posts = new ArrayList<Post>();
		Session session = null;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		for (Object o : session.createCriteria(Post.class).list()) posts.add((Post)o);
		session.getTransaction().commit();
		session.close();
		return posts;
	}

	public Post addPostIfNotExists(String postname) {
		Post post = null;
		Session session = null;
		session = HibernateUtil.getSession().openSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(Post.class);
		cr.add(Restrictions.like("postname",postname));
		if (cr.list().isEmpty()) {
			post = new Post();
			post.setPostname(postname);
			session.save(post);
		}
		else {
			post = (Post)cr.list().get(0);
		}
		session.getTransaction().commit();
		session.close();
		return post;
	}

}
