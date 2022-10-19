package com.janettewallace.comments.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity //generate table in MariaDB based on annotation specifications
@Table(name = "comments")
public class Comments extends Audit{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //this could also be set to auto
	private int id;
	
	@Column(nullable = false)
	private String topic;
	
	@Column(nullable = false)
	private String content;
	
	@ManyToOne(fetch = FetchType.LAZY)// Doesn't load the relationships unless explicitly “asked for” via getter
	@JoinColumn(name="user_id", nullable=false)//user comments are linked to their user id
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;
	
	public Comments() {
		
	}
	
	//getter, setter, and toString methods
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Comments [id=" + id + ", topic=" + topic + ", content=" + content + ", user=" + user + "]";
	}

	

	
	
	
}
