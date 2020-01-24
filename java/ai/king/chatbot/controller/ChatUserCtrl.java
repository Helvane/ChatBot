package ai.king.chatbot.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ai.king.chatbot.model.ChatUser;
import ai.king.chatbot.model.UserOutput;
import ai.king.chatbot.service.UserService;

@RestController
@RequestMapping("/api")

public class ChatUserCtrl {

	@Autowired
	private UserService userService;
	
	@Async
	@PostMapping("/join")
	public UserOutput postLogin(@RequestBody ChatUser user) {
		UserOutput userOutput = new UserOutput();
		List<ChatUser> users = this.userService.getUsers();
		boolean found = false;
		for(int i=0; i < users.size(); i++) {
			ChatUser u = users.get(i);
			if(u.getNickname().contains(user.getNickname())) { 
				found = true;
				i = users.size();
			}
		}
		if(found == true){
			userOutput.setResult(false);
			userOutput.setMessage("This is already taken");
	} else {
		Date today = new Date();
		user.setLogindate(today);
		userOutput.setResult(true);
		userOutput.setMessage("Welcome to chat room");
		users.add(user);
		this.userService.setUsers(users);
		userOutput.setUsers(users);
	
		}
		
		return userOutput;
	}
	
}
