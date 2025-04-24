package com.ozeken.messageapp.helper;

import java.sql.Timestamp;

import com.ozeken.messageapp.entity.Message;
import com.ozeken.messageapp.form.MessageForm;

/**
 * メッセージヘルパークラス
 */

public class MessageHelper {

	/**
	 * MessageFormをMessageに変換する
	 */
	public static Message convertMessage(MessageForm messageForm) {
	    Message message = new Message();
	    message.setMessageId(messageForm.getId());
	    message.setContent(messageForm.getContent());

	    // 時刻を現在時刻に設定（createdAt / updatedAt）
	    Timestamp now = new Timestamp(System.currentTimeMillis());
	    message.setCreatedAt(now);
	    message.setUpdatedAt(now);

	    return message;
	}

	
	/**
	 * MessageをMessageFormに変換する
	 */
	public static MessageForm convertMessageForm (Message message) {
		MessageForm messageForm = new MessageForm();
		messageForm.setId(message.getMessageId());
		messageForm.setContent(message.getContent());
		messageForm.setCreatedAt(message.getCreatedAt());
		messageForm.setUpdatedAt(message.getUpdatedAt());
		return messageForm;
	}
}
