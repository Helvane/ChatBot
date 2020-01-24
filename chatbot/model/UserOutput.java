package ai.king.chatbot.model;

import java.util.List;

public class UserOutput {

	private Boolean result;
	private String message;
	private List<ChatUser> users;
	public Boolean getResult() {
		return result;
	}
	public void setResult(Boolean result) {
		this.result = result;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<ChatUser> getUsers() {
		return users;
	}
	public void setUsers(List<ChatUser> users) {
		this.users = users;
	}
	
	
	
}
