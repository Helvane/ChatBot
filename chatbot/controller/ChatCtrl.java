package ai.king.chatbot.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ai.king.chatbot.model.Chatmessage;
import ai.king.chatbot.model.Listchatmessage;
import ai.king.chatbot.service.ChatbotService;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
public class ChatCtrl {
	
	@Autowired
	private ChatbotService chatbotService;

	@PostMapping("/send")
	public Flux<Chatmessage> sendMessage(@RequestBody Chatmessage chatmsg) {
		
		
	
		Date today = new Date();
		chatmsg.setDate(today);
	
		
		
		Chatmessage cm = this.chatbotService.talk(chatmsg);
		
	
		Flux<Chatmessage> myFlux  = Flux.just(chatmsg,cm);
		
		return myFlux;
		
		
	
	}
	
}
