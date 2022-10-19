package com.janettewallace.comments.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

//tracks changes made by user 
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Audit {

	@Temporal(TemporalType.DATE) //add date stamp to created comments
	@CreatedDate
	@Column(name = "create_date", nullable=false, updatable=false)
	private Date createdDate;
	
	@Temporal(TemporalType.DATE) //add date to updated comments
	@LastModifiedDate
	@Column(name = "update_date", nullable=false)
	private Date updateDate;

	//getter, setter, and toString methods
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "Audit [createdDate=" + createdDate + ", updateDate=" + updateDate + "]";
	}
	
	
}
