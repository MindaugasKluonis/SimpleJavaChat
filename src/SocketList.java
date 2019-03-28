import java.net.Socket;
import java.util.ArrayList;

public class SocketList {
	
	
	ArrayList<CustomSocket> client_List;
	
	
	SocketList(){
		
		client_List = new ArrayList<CustomSocket>();
		
	}
	
	public synchronized void addToList(CustomSocket s){
		
		System.out.println("ADDING NEW CLIENT");
		client_List.add(s);
		
	}
	
	public synchronized ArrayList<CustomSocket> getAllClients(){
		
		return client_List;
		
	}
	
	public synchronized CustomSocket getClientByIndex(int index){
		
		return client_List.get(index);
		
	}

}
