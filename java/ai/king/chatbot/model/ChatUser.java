package ai.king.chatbot.model;

import java.util.Date;

public class ChatUser {

	private String nickname;
	private Date logindate;
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Date getLogindate() {
		return logindate;
	}
	public void setLogindate(Date logindate) {
		this.logindate = logindate;
	}
	
	
}
