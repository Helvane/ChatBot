package ai.king.chatbot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ai.king.chatbot.model.ChatUser;

@Service
public class UserService {

	private List<ChatUser> users;

	public UserService() {
		super();
		this.users = new ArrayList<>();
		
	}

	public List<ChatUser> getUsers() {
		return users;
	}

	public void setUsers(List<ChatUser> users) {
		this.users = users;
	}
	

}
