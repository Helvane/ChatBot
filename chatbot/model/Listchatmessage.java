package ai.king.chatbot.model;

import java.util.ArrayList;
import java.util.List;

public class Listchatmessage {

	private List<Chatmessage> listmessage;

	public Listchatmessage() {
		super();
		listmessage = new ArrayList<>();
	}

	public List<Chatmessage> getListmessage() {
		return listmessage;
	}

	public void setListmessage(List<Chatmessage> listmessage) {
		this.listmessage = listmessage;
	}
	
	public List<Chatmessage> setChatmessage(Chatmessage msg) {
		this.listmessage.add(msg);
		return this.listmessage; 
		
	}
}
