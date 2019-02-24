package com.vomvos.communicator.services.notification;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

import com.vomvos.communicator.dto.NotificationDto;
import com.vomvos.communicator.models.notification.Notification;
import com.vomvos.communicator.repositories.notification.impl.NotificationRepositoryImpl;


@Service
public class NotificationService implements INotificationService{

	@Autowired
	private NotificationRepositoryImpl notificationRepository;
	
	@Autowired
	private SimpMessageSendingOperations messageTemplate;
	
	public static final Logger logger = LoggerFactory.getLogger(NotificationService.class);
	
	@Override
	public boolean sendNotificationToUsers(NotificationDto notification) {
		try {
			List<UUID> recievers = notification.getToUserids();
			UUID fromUserId = notification.getFromUserId();
			Notification userNotification = new Notification();
			String content = notification.getBody();
			
			userNotification.setFromUserId(fromUserId).setContent(content);
			
			for(UUID toUserId:recievers) {
				userNotification.setToUserId(toUserId);
				notificationRepository.save(userNotification);
				messageTemplate.convertAndSendToUser(toUserId.toString(),"/notifications",userNotification);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.warn("Exception in sendNotificationToRecievers method in NotificationService",e);
		}
		return false;
	}
	
	public List<Notification> getNotificationForUser(UUID id){
		//List<Notification> notificationList = notificationRepository.findById(id)
		return null;
	}
	

}
