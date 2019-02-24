package com.vomvos.communicator.dto;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;


public class NotificationDto implements Serializable{
	
	
	private List<UUID> toUserids;
	
	private UUID fromUserId;
	
	private String body;
	
	private String type; // notification type
	
	
	
	public NotificationDto(List<UUID> toUserids, UUID fromUserId, String body, String type) {
		super();
		this.toUserids = toUserids;
		this.fromUserId = fromUserId;
		this.body = body;
		this.type = type;
	}


	public NotificationDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public List<UUID> getToUserids() {
		return toUserids;
	}


	public void setToUserids(List<UUID> toUserids) {
		this.toUserids = toUserids;
	}


	public UUID getFromUserId() {
		return fromUserId;
	}


	public void setFromUserId(UUID fromUserId) {
		this.fromUserId = fromUserId;
	}


	public String getBody() {
		return body;
	}


	public void setBody(String body) {
		this.body = body;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return "NotificationDto [toUserids=" + toUserids + ", fromUserId=" + fromUserId + ", body=" + body + ", type="
				+ type + "]";
	}
	
	
}
