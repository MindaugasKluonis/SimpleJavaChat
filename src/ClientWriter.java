import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientWriter extends Thread implements ActionListener{
	
	DataOutputStream outToServer;
	BufferedReader inFromUser;
	BufferedReader inFromServer;
	String sentence;
	JButton sendButton;
	JTextField userInput;
	
	ClientWriter(JButton sendButton,JTextField userInput,DataOutputStream outToServer,BufferedReader inFromServer){
		
		this.outToServer = outToServer;
		this.inFromServer = inFromServer;
		this.sendButton = sendButton;
		this.userInput = userInput;
		sendButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == sendButton){
		
			try {
				sendMessage();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

	private void sendMessage() throws Exception{
		
		outToServer.writeBytes(userInput.getText() + '\n');
		userInput.setText("");
		
	}

}
