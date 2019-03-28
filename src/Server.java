
public class Server {
	
	public final static int SERVER_PORT = 1234;
	public final static String SERVER_NAME = "localhost";
	public static SocketList list;
	
	public static void main(String[] args){
		
		list = new SocketList();
		new ServerConnectionHandler();
		
	}

}
