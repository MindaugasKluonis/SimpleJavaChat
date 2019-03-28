import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientHandler extends Thread{
	
	Socket s;
	
	ClientHandler(Socket s){
		
		this.s = s;
		
	}
	
	public void run(){
		
		try {
			confirmHandshake();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void confirmHandshake() throws Exception{
		
		String clientSentence = null;
        String handshake = "handshake";
		
		BufferedReader inFromClient = null;
		try {
			inFromClient = new BufferedReader(new InputStreamReader(s.getInputStream()));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    DataOutputStream outToClient = null;
		try {
			outToClient = new DataOutputStream(s.getOutputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		clientSentence = inFromClient.readLine();
	
	    System.out.println("Received: " + clientSentence);
	    handshake = handshake.toUpperCase() + '\n';
	       
	    outToClient.writeBytes(handshake);
	    
	    Server.list.addToList(new CustomSocket(s,inFromClient,outToClient));
	    
	    new ServerReader(inFromClient, outToClient).start();
	    
	}

}
