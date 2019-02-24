package com.vomvos.communicator.models.support;


import java.io.Serializable;

import org.springframework.data.cassandra.core.mapping.Column;

import com.fasterxml.jackson.annotation.JsonProperty;


public class IdBoSupport implements Serializable {

	//protected long createdOn = System.currentTimeMillis();

	//protected long updatedOn = System.currentTimeMillis();
	
	protected boolean isDeleted = false;

	protected long deletedOn;
	
	@JsonProperty(value="isDeleted")    
	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public long getDeletedOn() {
		return deletedOn;
	}

	public void setDeletedOn(long deletedOn) {
		this.deletedOn = deletedOn;
	}	
}