package com.ozeken.messageapp.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ozeken.messageapp.entity.Message;
import com.ozeken.messageapp.form.MessageForm;
import com.ozeken.messageapp.helper.MessageHelper;
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
	
	//メッセージフォームを表示する
	@GetMapping("/form")
	public String newMessage(Model model) {
	    model.addAttribute("messageForm", new MessageForm());
	    return "messages/form";
	}

	//メッセージ登録処理
	@PostMapping("/save")
	public String createMessage(
	    @Valid MessageForm messageForm,
	    BindingResult result,
	    RedirectAttributes redirectAttributes,
	    Model model) {
		
		//バリデーションエラーがある場合はフォームに戻る
	    if (result.hasErrors()) {
	        model.addAttribute("messageForm",messageForm);
	        return "messages/form";
	    }
	    
	    //エンティティクラスへの変換
	    Message message = MessageHelper.convertMessage(messageForm);
	    //保存処理
	    messageService.insertMessage(message);
	    //フラッシュメッセージ
	    redirectAttributes.addFlashAttribute("successMessage", "メッセージを送信しました!");
	    
	    return "redirect:/messages";
	}
	
}
