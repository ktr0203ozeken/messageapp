package com.ozeken.messageapp.form;

import java.sql.Timestamp;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * メッセージフォーム
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageForm {
	
	/** メッセージID */
	private Long id;
	
	/** メッセージ内容 */
	@NotBlank(message = "メッセージは必須です")
	@Pattern(regexp = ".*[^\\s　].*", message = "空白だけの入力はできません")
	private String content;
	
	/** メッセージ作成日 */
	private Timestamp createdAt;
	
	/** メッセージ更新日 */
	private Timestamp updatedAt;

}
