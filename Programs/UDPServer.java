import java.net.*;
import java.util.HashMap;
public class UDPServer {
public static void main(String[] args) throws Exception {
DatagramSocket serverSocket = new DatagramSocket(9876);
// Store some countries and their capitals in a HashMap
HashMap<String, String> countryCapitals = new HashMap<>();
countryCapitals.put("India", "New Delhi");
countryCapitals.put("USA", "Washington, D.C.");
countryCapitals.put("Germany", "Berlin");
countryCapitals.put("France", "Paris");
byte[] receiveData = new byte[1024];
byte[] sendData = new byte[1024];
System.out.println("Server is running and waiting for client request...");
while (true) {
DatagramPacket receivePacket = new DatagramPacket(receiveData,
receiveData.length);
serverSocket.receive(receivePacket);
String country = new String(receivePacket.getData(), 0,
receivePacket.getLength());
System.out.println("Received country: " + country);// Find the capital of the country
String capital = countryCapitals.getOrDefault(country, "Capital not found");
sendData = capital.getBytes();
InetAddress clientIPAddress = receivePacket.getAddress();
int port = receivePacket.getPort();
DatagramPacket sendPacket = new DatagramPacket(sendData,
sendData.length, clientIPAddress, port);
serverSocket.send(sendPacket);
}
}
}
