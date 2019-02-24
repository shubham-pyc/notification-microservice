package com.vomvos.communicator.controllers;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.MessagingException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vomvos.communicator.dto.NotificationDto;
import com.vomvos.communicator.models.notification.Notification;
import com.vomvos.communicator.repositories.notification.impl.NotificationRepositoryImpl;
import com.vomvos.communicator.services.notification.NotificationService;

@RestController
public class NotificationController {

	@Autowired
	NotificationService notificationService;
	
	
	@RequestMapping(value="/sendnotification")
	public ResponseEntity sendNotificationToUsers(@RequestBody NotificationDto notifications) {
		
		boolean isNotificationSent = notificationService.sendNotificationToUsers(notifications);
		if(isNotificationSent == true) {
			return new ResponseEntity(HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.CONFLICT);
		
	}
	@RequestMapping(value="/getnotifications")
	public ResponseEntity getNotificationForUserId(@RequestBody UUID userId) {
		try {
			List<Notification> notificationsForUser = notificationService.getNotificationForUser(userId);
			
		} catch (Exception e) {
			
		}
		return null;
	}
	
}
