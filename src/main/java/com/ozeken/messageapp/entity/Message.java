package com.ozeken.messageapp.entity;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * メッセージエンティティ
 */
	
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
	
	// メッセージID
	private Long messageId;
	// メッセージ内容
	
	private String content;
	//作成日時
	private Timestamp createdAt;
	//更新日時
	private Timestamp updatedAt;

}
