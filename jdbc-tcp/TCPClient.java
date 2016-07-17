import java.io.*;
import java.net.*;

public class TCPClient {
	
	public static void main(String[] args) {
		String serverName = "localhost";
		int port = 6666;
		try{
			System.out.println("\n\nConnecting to " + serverName + " on port " + port);
	        Socket client = new Socket(serverName, port);
	        System.out.println("\n\nJust connected to " + client.getRemoteSocketAddress());
	        
	        System.out.print("\n\n\nEnter Employee ID : ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int idInput = Integer.parseInt(br.readLine());
			
			OutputStream outToServer = client.getOutputStream();
	        DataOutputStream out = new DataOutputStream(outToServer);
	        out.writeInt(idInput);
	        
	         InputStream inFromServer = client.getInputStream();
	         DataInputStream in = new DataInputStream(inFromServer);
	         System.out.print("\n\n\n\n\nBelow details were returned by the server : "+in.readUTF());
	         
	         client.close();
		}
		catch(Exception e){
			System.out.println("Client Side problem : "+e);
		}

	}

}
