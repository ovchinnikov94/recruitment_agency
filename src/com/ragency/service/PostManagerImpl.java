package com.ragency.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ragency.dao.PostDao;
import com.ragency.entity.Post;

@Service
public class PostManagerImpl implements PostManager {

	@Autowired
	PostDao postDao;
	
	@Override
	public void addPost(Post post) {
		this.postDao.addPost(post);
	}

	@Override
	public void updatePost(Post post) {
		this.postDao.updatePost(post);
	}

	@Override
	public void deletePost(Post post) {
		this.postDao.deletePost(post);
	}

	@Override
	public Post getPostById(int id) {
		return this.postDao.getPostById(id);
	}

	@Override
	public List<Post> getAllPosts() {
		return this.postDao.getAllPosts();
	}

	@Override
	public Post addPostIfNotExists(String postname) {
		return this.postDao.addPostIfNotExists(postname);
	}

}
