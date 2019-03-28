import java.io.DataOutputStream;
import java.io.IOException;

public class ServerWriter extends Thread {
	
	DataOutputStream outToClient;
	
	ServerWriter(DataOutputStream outToClient){
		
		this.outToClient = outToClient;
		
	}
	
	public void run(){
		
		
		init();
		
		
	}
	
	public void init(){
		
		
		
		
	}
	
	public void test(String s) throws IOException{
		
		System.out.println("WRITER: " + s);
		
		for(int i = 0; i < Server.list.getAllClients().size();i++){
			
			
			Server.list.getClientByIndex(i).getOutToClient().writeBytes(s + "\n");
			
		}
		
		System.out.println("WROTE");
		
	}

}
