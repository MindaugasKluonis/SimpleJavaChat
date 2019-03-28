import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.net.Socket;

public class CustomSocket {
	
	private Socket socket;
	private BufferedReader inFromClient;
	private DataOutputStream outToClient;
	
	public CustomSocket(Socket socket, BufferedReader inFromClient, DataOutputStream outToClient) {

		this.socket = socket;
		this.inFromClient = inFromClient;
		this.outToClient = outToClient;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public BufferedReader getInFromClient() {
		return inFromClient;
	}

	public void setInFromClient(BufferedReader inFromClient) {
		this.inFromClient = inFromClient;
	}

	public DataOutputStream getOutToClient() {
		return outToClient;
	}

	public void setOutToClient(DataOutputStream outToClient) {
		this.outToClient = outToClient;
	}
	


}
