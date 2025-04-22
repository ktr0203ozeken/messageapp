package com.ozeken.messageapp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ozeken.messageapp.entity.Message;
import com.ozeken.messageapp.repository.MessageMapper;
import com.ozeken.messageapp.service.MessageService;

import lombok.RequiredArgsConstructor;

/**
 * サービス実装クラス
 */

@Service
@Transactional
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
	
	//DI
	private final MessageMapper messageMapper;

	@Override
	public List<Message> getAllMessages() {
		return messageMapper.selectAll();
	}

	@Override
	public Message getMessageById(Long messageId) {
		return messageMapper.selectById(messageId);
	}

	@Override
	public void insertMessage(Message message) {
		messageMapper.insert(message);

	}

	@Override
	public void updateMessage(Message message) {
		messageMapper.update(message);
	}

	@Override
	public void deleteMessage(Long messageId) {
		messageMapper.delete(messageId);

	}

}
