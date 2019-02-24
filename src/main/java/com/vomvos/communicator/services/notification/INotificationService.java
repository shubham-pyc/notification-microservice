package com.vomvos.communicator.services.notification;

import java.util.List;
import java.util.UUID;

import com.vomvos.communicator.dto.NotificationDto;
import com.vomvos.communicator.models.notification.Notification;

public interface INotificationService {
	public boolean sendNotificationToUsers(NotificationDto notifications);
	public List<Notification> getNotificationForUser(UUID userId);

}
