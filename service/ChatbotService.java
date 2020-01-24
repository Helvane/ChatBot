package ai.king.chatbot.service;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;
import org.alicebot.ab.History;
import org.alicebot.ab.MagicBooleans;
import org.alicebot.ab.MagicStrings;
import org.alicebot.ab.utils.IOUtils;
import org.springframework.stereotype.Service;

import ai.king.chatbot.model.Chatmessage;



@Service
public class ChatbotService {
	
	private List<Chatmessage> listmsg;

	private static final boolean TRACE_MODE = false;
    static String botName = "king";
    private Chatmessage robotMessage cm = new Chatmessage(); 
    
    this.listmsg = new ArrayList<>();
    
    
    
    public List<Chatmessage> getListmsg() {
		return listmsg;
	}

	public void setListmsg(List<Chatmessage> listmsg) {
		this.listmsg = listmsg;
	}

	public static String getBotName() {
		return botName;
	}

	public static void setBotName(String botName) {
		ChatbotService.botName = botName;
	}

	public Chatmessage getRobotMessage() {
		return robotMessage;
	}

	public void setRobotMessage(Chatmessage robotMessage) {
		this.robotMessage = robotMessage;
	}

	public static boolean isTraceMode() {
		return TRACE_MODE;
	}

	private static String getResourcesPath() {
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        path = path.substring(0, path.length() - 2);
        System.out.println(path);
        String resourcesPath = path + File.separator + "src" + File.separator + "main" + File.separator + "resources";
        return resourcesPath;
        
        this.robotMessage.setMessage(response);
        date today = new Date();
        this.robotMessage.setDate(today);
    }
    
    public Chatmessage talk(Chatmessage chatmsg) {
    	try {
			 
    		
            String resourcesPath = getResourcesPath();
            System.out.println(resourcesPath);
            MagicBooleans.trace_mode = TRACE_MODE;
            Bot bot = new Bot("super", resourcesPath);
            Chat chatSession = new Chat(bot);
            bot.brain.nodeStats();
            String textLine = chatmsg.getMessage();
 
            
                
                    String request = textLine;
                    if (MagicBooleans.trace_mode)
                        System.out.println("STATE=" + request + ":THAT=" + ((History) chatSession.thatHistory.get(0)).get(0) + ":TOPIC=" + chatSession.predicates.get("topic"));
                    String response = chatSession.multisentenceRespond(request);
                    while (response.contains("&lt;"))
                        response = response.replace("&lt;", "<");
                    while (response.contains("&gt;"))
                        response = response.replace("&gt;", ">");
                    System.out.println("Robot : " + response);
                    chatmsg.setMessage(response);
                    chatmsg.setNickname("Robot");
                    Date today = new Date();
                    chatmsg.setDate(today);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
	
    	
    	return chatmsg;
    }
}
