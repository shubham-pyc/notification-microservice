//package com.vomvos.communicator.models.notification;
//
//import java.util.List;
//import java.util.UUID;
//
//public class PostNotificationBody implements NotificationBody{
//	
//	private UUID id;
//	
//	private String title;
//	
//	private String description;
//	
//	private UUID rewardId;
//	
//	private UUID rewardName;
//	
//	private String type; // post type if reward or normal post
//	
//	private UUID commentId; // in case of comment on post 
//
//	public PostNotificationBody() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public PostNotificationBody(UUID id, String title, String description,  UUID rewardId,
//			UUID rewardName, String type, UUID commentId) {
//		super();
//		this.id = id;
//		this.title = title;
//		this.description = description;
//		this.rewardId = rewardId;
//		this.rewardName = rewardName;
//		this.type = type;
//		this.commentId = commentId;
//	}
//
//	@Override
//	public String toString() {
//		return "PostNotificationBody [id=" + id + ", title=" + title + ", description=" + description + ", medias="
//				+  ", rewardId=" + rewardId + ", rewardName=" + rewardName + ", type=" + type + ", commentId="
//				+ commentId + "]";
//	}
//
//	public UUID getId() {
//		return id;
//	}
//
//	public void setId(UUID id) {
//		this.id = id;
//	}
//
//	public String getTitle() {
//		return title;
//	}
//
//	public void setTitle(String title) {
//		this.title = title;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//
//	public UUID getRewardId() {
//		return rewardId;
//	}
//
//	public void setRewardId(UUID rewardId) {
//		this.rewardId = rewardId;
//	}
//
//	public UUID getRewardName() {
//		return rewardName;
//	}
//
//	public void setRewardName(UUID rewardName) {
//		this.rewardName = rewardName;
//	}
//
//	public String getType() {
//		return type;
//	}
//
//	public void setType(String type) {
//		this.type = type;
//	}
//
//	public UUID getCommentId() {
//		return commentId;
//	}
//
//	public void setCommentId(UUID commentId) {
//		this.commentId = commentId;
//	}
//	
//}
