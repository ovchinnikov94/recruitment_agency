package com.ragency.service;

import java.util.List;

import com.ragency.entity.Post;

public interface PostManager {
	public void addPost(Post post);
	public void updatePost(Post post);
	public void deletePost(Post post);
	public Post getPostById(int id);
	public List<Post> getAllPosts();
	public Post addPostIfNotExists(String postname);
}
