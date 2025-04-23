package com.ozeken.messageapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ozeken.messageapp.entity.Message;
import com.ozeken.messageapp.service.MessageService;

import lombok.RequiredArgsConstructor;

/**
 * メッセージコントローラー
 */

@Controller
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessageController {
	
	/**DI*/
	private final MessageService messageService;
	
	//メッセージ一覧を取得する
	@GetMapping
	public String getMessages(Model model) {
		List<Message> messages = messageService.getAllMessages();
		if (messages.isEmpty()) {
			model.addAttribute("emptymessage", "メッセージはありません");
		} else {
			model.addAttribute("messages", messages);
		}
		return "messages/list";
	}
}
