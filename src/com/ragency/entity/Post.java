package com.ragency.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="post")
public class Post {
	@Id
	@Column (name="idpost")
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int idpost;
	
	@Column (name = "postname")
	private String postname;

	public Post(){
		
	}
	
	public Post(String postname) {
		super();
		this.postname = postname;
	}

	public int getIdpost() {
		return idpost;
	}

	public void setIdpost(int idpost) {
		this.idpost = idpost;
	}

	public String getPostname() {
		return postname;
	}

	public void setPostname(String postname) {
		this.postname = postname;
	}
	
	
}
