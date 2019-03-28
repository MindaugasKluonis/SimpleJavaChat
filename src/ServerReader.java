import java.io.BufferedReader;
import java.io.DataOutputStream;

public class ServerReader extends Thread{
	
	BufferedReader inFromClient;
	String temp;
	ServerWriter writer;
	
	ServerReader(BufferedReader inFromClient,DataOutputStream outToClient){
		
		this.inFromClient = inFromClient;
		writer = new ServerWriter(outToClient);
		writer.start();
		
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
			
			System.out.println("Reading value");
			temp = inFromClient.readLine();
			System.out.println("Client says: " + temp);
			//calling method in writer
			writer.test(temp);
			
			
		}
		
	}

}
