package com.zy.test.serviceImp;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.zy.test.domain.Message;
import com.zy.test.service.MessageStorage;


@Component
public class MemoryMessageStorage implements MessageStorage {
	
	private static final Logger LOG = LoggerFactory.getLogger(MemoryMessageStorage.class);
	
	private Map<Long, Message> messages;

	private AtomicLong newID;

	private MessageStorage storageDelegate;

	public MemoryMessageStorage() {
		messages = Collections.synchronizedMap(new HashMap<Long, Message>());
		newID = new AtomicLong(0);
	}
	
	@Override
	public void setDelegate(MessageStorage storageDelegate) {
		this.storageDelegate = storageDelegate;
	}
	
	@PostConstruct
	public void initialize() {
		// add some messages
		addMessage(new Message("user:1", "content-1"));
		addMessage(new Message("user:2", "content-2"));
		addMessage(new Message("user:3", "content-3"));
		addMessage(new Message("user:4", "content-4"));
		addMessage(new Message("user:5", "content-5"));
	}
	
	@Override
	@Cacheable("messageCache")
	public Message findMessage(long id) {
		LOG.debug("== find message by id={}", id);
		if(storageDelegate != null)
			storageDelegate.findMessage(id);
		return messages.get(id);
	}

	@Override
	@Cacheable("messagesCache")
	public Collection<Message> findAllMessages() {
		
		Collection<Message> values = messages.values();
		Set<Message> messages = new HashSet<Message>();
		synchronized (messages) {
			Iterator<Message> iterator = values.iterator();
			while (iterator.hasNext()) {
				messages.add(iterator.next());
			}
		}
		LOG.debug("== got all messages, size={}", messages.size());
		if(storageDelegate != null)
			storageDelegate.findAllMessages();
		return Collections.unmodifiableCollection(messages);
	}

	@Override
	public void addMessage(Message message) {
		// TODO Auto-generated method stub
		
	}

	
}
