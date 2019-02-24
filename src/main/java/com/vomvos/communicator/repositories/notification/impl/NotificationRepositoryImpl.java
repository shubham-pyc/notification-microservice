package com.vomvos.communicator.repositories.notification.impl;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.vomvos.communicator.config.constants.TableNames;
import com.vomvos.communicator.models.notification.Notification;
import com.vomvos.communicator.repositories.notification.interfaces.INotificationRepository;
import com.vomvos.communicator.repositories.support.impl.CrudRepositoryImpl;

@Repository
public class NotificationRepositoryImpl extends CrudRepositoryImpl<Notification> implements INotificationRepository{

	@Override
	public Notification findById(UUID id) {
		try {
			Select select = QueryBuilder.select().from(TableNames.NOTIFICATIONS);
			select.where(QueryBuilder.eq("id", id));//..			
			return  cassandraTemplate.selectOne(select, Notification.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
