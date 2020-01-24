package ai.king.chatbot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ai.king.chatbot.model.Chatmessage;
import ai.king.chatbot.service.ChatbotService;

@Controller
public class MainCtrl {
	
	@Autowired
	private ChatbotService chatbotService;
	
	@GetMapping("/")
	@PostMapping("/chatroom")
	
	this.listMessage = this.chatbotService.getListmsg();
	
	public String postIndex(@ModelAttribute("Chatmessage") Chatmessage chatmsg,
			BindingResult result, ModelMap model){
		
			this.userMessage.setNickname(chatmsg, getNickname());
			this.listMessage.add(chatmsg); 
		
		this.userMessage = chatmsg;
		this.userMessage.setMessage(chatmsg.getMessage());
		Date today = new Date();
		this.userMessage.setDate(today);
		this.listMessage.add(this.userMessage);
		private Chatmessage userMessage;
		private Chatmessage robotMessage;
		private List<Chatmessage> listMessage = new ArrayList<ChatMessage>
		
		// chatmsg = this.chatbotService.talk(chatmsg);
		model.addAttribute("result",msg);
		
		return "chatroom";
		
		System.out.println("*** the message starts here ***");
		System.out.println(chatmsg.getNickname());
		System.out.println(chatmsg.getMessage());
		System.out.println(chatmsg.getDate());
		
	
		
		try {
			this.listMessage.add(this.robotMessage);
			this.chatbotService.setListmsg(listMessage);
			Chatmessage msg = this.chatbotService.talk(chatmsg)
					model.addAttribute("listmsg", this.chatbotService.getListmsg());
					model.addAttribute("user",this.userMessage);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		}
		
		return "index";
	}

}
