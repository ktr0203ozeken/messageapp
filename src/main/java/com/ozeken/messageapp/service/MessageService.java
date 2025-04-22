package com.ozeken.messageapp.service;

import java.util.List;

import com.ozeken.messageapp.entity.Message;

public interface MessageService {
	
	/**
	 * サービスインターフェース
	 */
	
	// すべてのメッセージを取得
	List<Message> getAllMessages();
	
	// IDでメッセージを取得
	Message getMessageById(Long messageId);
	
	// メッセージを登録
	void insertMessage(Message message);
	
	// メッセージを更新
	void updateMessage(Message message);
	
	// メッセージを削除
	void deleteMessage(Long messageId);
}
