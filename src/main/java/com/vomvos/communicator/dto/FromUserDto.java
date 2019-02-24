package com.vomvos.communicator.dto;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FromUserDto {
	
	private UUID id;
	
	private String name;
	
	private String profilePic;
	
	private boolean isCreator;
	
	private int friendStatus;

	public FromUserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FromUserDto(UUID id, String name, String profilePic, boolean isCreator, int friendStatus) {
		super();
		this.id = id;
		this.name = name;
		this.profilePic = profilePic;
		this.isCreator = isCreator;
		this.friendStatus = friendStatus;
	}

	@Override
	public String toString() {
		return "FromUserDto [id=" + id + ", name=" + name + ", profilePic=" + profilePic + ", isCreator=" + isCreator
				+ ", friendStatus=" + friendStatus + "]";
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public boolean isCreator() {
		return isCreator;
	}
	
	@JsonProperty(value = "isCreator")
	public void setCreator(boolean isCreator) {
		this.isCreator = isCreator;
	}

	public int getFriendStatus() {
		return friendStatus;
	}

	public void setFriendStatus(int friendStatus) {
		this.friendStatus = friendStatus;
	}
	
}
