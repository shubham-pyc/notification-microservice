package com.vomvos.communicator.models.notification;

import java.util.UUID;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import com.datastax.driver.core.DataType;
import com.vomvos.communicator.config.constants.TableNames;
import com.vomvos.communicator.models.support.IdBoSupport;

@Table(TableNames.NOTIFICATIONS)
public class Notification extends IdBoSupport{
	
	@PrimaryKeyColumn(name="touserid",ordinal=0,type=PrimaryKeyType.PARTITIONED)
	@CassandraType(type = DataType.Name.UUID)
	private UUID toUserId;
	
	@PrimaryKeyColumn(name="createdon",ordinal=1,type=PrimaryKeyType.CLUSTERED)
	private long createdOn = System.currentTimeMillis();
	
	private UUID fromUserId;
	
	private String content;
	
	public Notification() {
		super();
	}

	public Notification(UUID toUserId, long createdOn, UUID fromUserId, String content) {
		super();
		this.toUserId = toUserId;
		this.createdOn = createdOn;
		this.fromUserId = fromUserId;
		this.content = content;
	}
	

	public Notification(UUID toUserId, UUID fromUserId, String content) {
		super();
		this.toUserId = toUserId;
		this.fromUserId = fromUserId;
		this.content = content;
		this.createdOn = System.currentTimeMillis();
	}

	@Override
	public String toString() {
		return "Notification [toUserId=" + toUserId + ", createdOn=" + createdOn + ", fromUserId=" + fromUserId
				+ ", content=" + content + "]";
	}

	public UUID getToUserId() {
		return toUserId;
	}

	public Notification setToUserId(UUID toUserId) {
		this.toUserId = toUserId;
		return this;
	}

	public long getCreatedOn() {
		return createdOn;
	}

	public Notification setCreatedOn(long createdOn) {
		this.createdOn = createdOn;
		return this;
	}

	public UUID getFromUserId() {
		return fromUserId;
	}

	public Notification setFromUserId(UUID fromUserId) {
		this.fromUserId = fromUserId;
		return this;
	}

	public String getContent() {
		return content;
	}

	public Notification setContent(String content) {
		this.content = content;
		return this;
	}
		
}
