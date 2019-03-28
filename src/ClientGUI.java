import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientGUI extends JFrame implements ActionListener{
	
	
	private JPanel leftPanel;
	private JPanel rightPanel;
	
	private JButton connectButton;
	private JButton sendButton;
	private JTextArea chatArea;
	private JLabel username;
	private JTextField userInput;
	
	
	ClientGUI(){
		
		super("Client");
		
		setLayout(new FlowLayout());
		
		leftPanel = new JPanel();
		rightPanel = new JPanel();
		
		leftPanel.setPreferredSize(new Dimension(200,500));
		rightPanel.setPreferredSize(new Dimension(300,500));
		
		connectButton = new JButton("Connect");
		connectButton.setPreferredSize(new Dimension(150,50));
		sendButton = new JButton("Send");
		userInput = new JTextField(20);
		
		connectButton.addActionListener(this);
		
		chatArea = new JTextArea(25,25); 
		
		leftPanel.add(connectButton);
		
		rightPanel.add(chatArea);
		rightPanel.add(userInput);
		rightPanel.add(sendButton);
		
		add(leftPanel);
		add(rightPanel);
		
		setSize(600,500);
		setVisible(true);
		
	}
	
	
	private void setUpSocket() throws Exception{
		
		new Client().connect(sendButton,chatArea,userInput);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == connectButton){
			
			try {
				setUpSocket();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}


}
