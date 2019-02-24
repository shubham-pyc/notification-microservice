package com.vomvos.communicator.models.user;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vomvos.communicator.config.Config;
import com.vomvos.communicator.config.constants.TableNames;
import com.vomvos.communicator.models.support.IdBoSupport;

@Table(value = TableNames.USERS_BY_EMAIL)
public class UserByEmail extends IdBoSupport{
	
	private UUID id;
		
	@PrimaryKey
	private String email;
	
	private String fullname;
	
	private String password;	
	
	private String profilePic = Config.defaultProfilePic;
	
	private boolean isCreator = false;//..

	private boolean isProfileCompleted = false;//..
	
	private long updatedAt = System.currentTimeMillis();
	
	private long createdAt = System.currentTimeMillis();
	

	protected String role;
	
	protected Boolean isPresent;
	  
	
	private int badgeCount = 0;
		
	public UserByEmail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserByEmail(UUID id, String email, String fullname, String password, String profilePic, boolean isCreator,
			boolean isProfileCompleted, long updatedAt, long createdAt, String role, Boolean isPresent,
			int badgeCount) {
		super();
		this.id = id;
		this.email = email;
		this.fullname = fullname;
		this.password = password;
		this.profilePic = profilePic;
		this.isCreator = isCreator;
		this.isProfileCompleted = isProfileCompleted;
		this.updatedAt = updatedAt;
		this.createdAt = createdAt;
		this.role = role;
		this.isPresent = isPresent;
		this.badgeCount = badgeCount;
	}

	public UserByEmail(User user) {
		super();
		this.id = user.getId();
		this.email = user.getEmail();
		this.fullname = user.getFullname();
		this.password = user.getPassword();
		this.profilePic = user.getProfilePic();
		this.isCreator = user.getIsCreator();
		this.isProfileCompleted = user.getIsProfileCompleted();
		this.updatedAt = user.getUpdatedAt();
		this.createdAt = user.getCreatedAt();
		this.role = user.getRole();
		this.isPresent = user.getIsPresent();
		this.badgeCount = user.getBadgeCount();
	}

	@Override
	public String toString() {
		return "UserByEmail [id=" + id + ", password=" + password + ", email=" + email + ", fullname=" + fullname
				+ ", isCreator=" + isCreator + ", isProfileCompleted=" + isProfileCompleted + ", profilePic="
				+ profilePic + ", updatedAt=" + updatedAt + ", createdAt=" + createdAt + "]";
	}

	public long getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(long updatedAt) {
		this.updatedAt = updatedAt;
	}

	public long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(long createdAt) {
		this.createdAt = createdAt;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
		
	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	@JsonProperty(value="isCreator")
	public boolean getIsCreator() {
		return isCreator;
	}

	public void setIsCreator(boolean isCreator) {
		this.isCreator = isCreator;
	}
	
	@JsonProperty(value="isProfileCompleted")
	public boolean getIsProfileCompleted() {
		return isProfileCompleted;
	}

	public void setIsProfileCompleted(boolean isProfileCompleted) {
		this.isProfileCompleted = isProfileCompleted;
	}
	
	public int getBadgeCount() {
		return badgeCount;
	}


	public void setBadgeCount(int badgeCount) {
		this.badgeCount = badgeCount;
	}
	
	public Boolean getIsPresent() {
		return isPresent;
	}


	public void setIsPresent(Boolean isPresent) {
		this.isPresent = isPresent;
	}
}