import java.util.*;
import java.io.*;
import java.net.*;
import java.sql.*;

public class TCPServer {

	private ServerSocket TCPSocket;
	
	public TCPServer(int port)throws IOException{
		TCPSocket = new ServerSocket(port);
		TCPSocket.setSoTimeout(2147483647);
	}
	
	public void retrieveEmployee(){
		while(true)
	      {
	         try
	         {
	            System.out.println("\n\nWaiting for client on port " + TCPSocket.getLocalPort() + "...");
	            Socket server = TCPSocket.accept();
	            System.out.println("\n\nJust connected to "+ server.getRemoteSocketAddress());
	            DataInputStream in = new DataInputStream(server.getInputStream());
	            int x = in.readInt();
	            System.out.println("\n\nClient Requested for employee "+x);
	            
	            Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeDB","root", "pass");
				PreparedStatement stmt=con.prepareStatement("SELECT *FROM EMPLOYEE WHERE Eid = ?");
				stmt.setInt(1,x);
				List<Employee> details = new ArrayList<Employee>();
				ResultSet rs = stmt.executeQuery();
				while(rs.next()){
					Employee E = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5));
					details.add(E);
				}
				String str = null;
	            for(Employee E : details){
	            	str = "\n\n\nEMPLOYEE ID : "+Integer.toString(E.getEid())+"\nEMPLOYEE NAME : "+E.getName()+"\nPOST : "+E.getPost()+"\nDEPT ID : "+Integer.toString(E.getDid())
	            			+"\nSALARY : "+Integer.toString(E.getSalary())+"\n\n\n";
	            }
	            
				DataOutputStream out = new DataOutputStream(server.getOutputStream());
				out.writeUTF(str);
				
				server.close();
	            
	            
	         }
	         catch(Exception e){
	        	 System.out.println("Server side Retrieval problem : ");
                 e.printStackTrace();
	         }
	      }
	}
	
	public static void main(String[] args) {
		int port  = 6666;
		try{
			TCPServer t = new TCPServer(port);
			t.retrieveEmployee();
			
		}catch(Exception e){
			System.out.println("Server main method problem : "+e);
		}

	}

}
