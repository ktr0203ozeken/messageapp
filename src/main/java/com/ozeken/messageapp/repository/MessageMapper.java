package com.ozeken.messageapp.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ozeken.messageapp.entity.Message;

@Mapper
public interface MessageMapper {
	
	// メッセージを全件取得
	List<Message> selectAll();
	
	// メッセージをIDで取得
	Message selectById(Long messageId);
	
	// メッセージを新規登録
	void insert(Message message);
	
	// メッセージを更新
	void update(Message message);
	
	// メッセージを削除
	void delete(Long messageId);

}
