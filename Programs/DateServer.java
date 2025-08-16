

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket serverSoclet=new ServerSocket(6789);
			System.out.println("Server is waiting for client on port 6789...");
			
			Socket connectionSocket = serverSoclet.accept();
			DataOutputStream outToClient=new DataOutputStream(connectionSocket.getOutputStream());
			String currentTime = new SimpleDateFormat("(yyyy/MM/dd)(HH:mm:ss)").format(new Date());
			outToClient.writeBytes("Current Date and Time: " + currentTime + "\n");
			connectionSocket.close();
			serverSoclet.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}

