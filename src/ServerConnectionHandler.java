import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerConnectionHandler extends Thread{
	
	
	ServerConnectionHandler(){
		
		start();
		System.out.println("Starting Server");
		
	}
	
	public void run(){
		
		try (ServerSocket welcomeSocket = new ServerSocket(Server.SERVER_PORT)) {
			
            while (true) {
            	
           	  Socket connectionSocket = welcomeSocket.accept();
              new ClientHandler(connectionSocket).start();
              
            }
            
          } catch (IOException ex) {
            ex.printStackTrace();
          }
		
	}

}