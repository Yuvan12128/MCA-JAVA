

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class DateClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// Create a socket to connect to the server on localhost and port 6789
			Socket clientSocket = new Socket("localhost", 6789);
			// Get the input stream from the server
			BufferedReader inFromServer = new BufferedReader(new
			InputStreamReader(clientSocket.getInputStream()));
			// Read the date and time sent by the server
			String serverResponse = inFromServer.readLine();
			// Print the response from the server
			System.out.println("From Server: " + serverResponse);
			// Close the connection
			clientSocket.close();
			} catch (IOException e) {
			e.printStackTrace();
	}

	}
	
}

