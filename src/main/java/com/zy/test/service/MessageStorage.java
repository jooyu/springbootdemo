package com.zy.test.service;
import java.util.Collection;

import com.zy.test.domain.Message;

public interface MessageStorage {

	Message findMessage(long id);

	Collection<Message> findAllMessages();

	void addMessage(Message message);

	void setDelegate(MessageStorage storageDelegate);
}
