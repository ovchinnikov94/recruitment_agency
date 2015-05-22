package com.ragency.tests;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ragency.dao.PostDaoImpl;
import com.ragency.entity.Post;

public class PostDaoTest {
  @Test
  public void postDaoTests() throws SQLException {
	  PostDaoImpl pDao = new PostDaoImpl(); 
	  Post post = pDao.addPostIfNotExists("post_for_PostDaoTest");
	  
	  Assert.assertTrue(post.getIdpost() == pDao.addPostIfNotExists("post_for_PostDaoTest").getIdpost());
	  
	  Assert.assertTrue(post.getIdpost() == pDao.getPostById(post.getIdpost()).getIdpost()); // getById() method test
	  
	  String update_test  = "post_updated";
	  post.setPostname(update_test);
	  pDao.updatePost(post);
	  
	  Assert.assertTrue(update_test.equals(pDao.getPostById(post.getIdpost()).getPostname())); // Update() method test
	  
	  pDao.deletePost(post);
	  
	  List<Integer> ids = new ArrayList<Integer>();
	  for (Post p : pDao.getAllPosts()) ids.add(p.getIdpost());
	  
	  Assert.assertTrue(!ids.contains(post.getIdpost()));
  }
}
