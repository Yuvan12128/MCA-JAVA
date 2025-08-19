import java.net.*;
import java.util.Scanner;
public class UDPClient {
public static void main(String[] args) throws Exception {
DatagramSocket clientSocket = new DatagramSocket();
InetAddress IPAddress = InetAddress.getByName("localhost");
byte[] sendData = new byte[1024];
byte[] receiveData = new byte[1024];
Scanner scanner = new Scanner(System.in);
System.out.print("Enter the name of a country: ");
String country = scanner.nextLine();
sendData = country.getBytes();
DatagramPacket sendPacket = new DatagramPacket(sendData,
sendData.length, IPAddress, 9876);clientSocket.send(sendPacket);
DatagramPacket receivePacket = new DatagramPacket(receiveData,
receiveData.length);
clientSocket.receive(receivePacket);
String capital = new String(receivePacket.getData(), 0,
receivePacket.getLength());
System.out.println("Capital of " + country + " is: " + capital);
clientSocket.close();
scanner.close();
}
}
