import java.net.*;
import java.io.*;

public class Server {

	public static void main(String[] args) throws Exception
	{
		DatagramSocket server = new DatagramSocket(1234);
		// getting client information
		byte receivedData[] = new byte[1024];
		DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length);
		server.receive(receivedPacket);
		String dataFromClient = new String(receivedPacket.getData());
		InetAddress ipAddress =InetAddress.getLocalHost();
		System.out.println(ipAddress+" received :"+dataFromClient);
		//send to the client
		int clientPacketSize = dataFromClient.length();
		String	dataToClient = "ACK "+clientPacketSize;
		byte data[] = new byte[1024];
		data = dataToClient.getBytes();
		// for getting ip address and the port of client in the way to send him
		int clientPort = receivedPacket.getPort(); 
		InetAddress clientIpAddress = receivedPacket.getAddress();
		DatagramPacket packet1 = new DatagramPacket(data,data.length,clientIpAddress,clientPort);
		server.send(packet1);
		System.out.println("acknowledgement message has been sent");
		System.out.println("\n------End of connection-----");
	}

}
