package com.ozeken.messageapp.entity;

import java.sql.Timestamp;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
	
	// メッセージID
	private Long messageId;
	// メッセージ内容
	@NotBlank(message = "メッセージは必須です")
	@Pattern(regexp = ".*[^\\s　].*", message = "空白だけの入力はできません")
	private String content;
	//作成日時
	private Timestamp createdAt;
	//更新日時
	private Timestamp updatedAt;

}
