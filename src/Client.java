import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client{
	
	private final static int SERVER_PORT = 1234;
	private final static String SERVER_NAME = "localhost";
	
	public void connect(JButton sendButton,JTextArea chatArea,JTextField userInput) throws Exception{
		
		String sentence = "handshake";
		String modifiedSentence;
		
		Socket clientSocket = new Socket(SERVER_NAME,SERVER_PORT);
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		outToServer.writeBytes(sentence + '\n');
		modifiedSentence = inFromServer.readLine();
		System.out.println("FROM SERVER: " + modifiedSentence);
		
		//success on connection
		
		if(modifiedSentence.equals("HANDSHAKE")){
			
			//open writer thread and reader thread
			System.out.println("SUCCESS");
			new ClientWriter(sendButton,userInput,outToServer,inFromServer).start();
			new ClientReader(chatArea,outToServer,inFromServer).start();
			
		}
		
		
		
	}

}
