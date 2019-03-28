import java.io.BufferedReader;
import java.io.DataOutputStream;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientReader extends Thread{
	
	BufferedReader inFromServer;
	String temp;
	JTextArea chatArea;
	
	ClientReader(JTextArea chatArea,DataOutputStream outToServer,BufferedReader inFromServer){
		
		this.inFromServer = inFromServer;
		this.chatArea = chatArea;
		
	}
	
	public void run(){
		
		try {
			init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void init() throws Exception{
		
		while(true){
				
			temp = inFromServer.readLine();
			chatArea.append(temp + "\n");
			
		}
		
	}
	
}
