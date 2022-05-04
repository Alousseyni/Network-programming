import java.net.*;
import java.io.*;

public class Client {

	public static void main(String[] args) throws Exception
	{
		// asking user to the keyboard
		BufferedReader user_input = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter an information which has to be sent to the server");
		String str =user_input.readLine();
		
		// set up a connection for that youmay need some tools
		DatagramSocket client = new DatagramSocket();
		byte data[] = new byte[1024];
		data =str.getBytes();
		InetAddress iP_Address = InetAddress.getByName("localhost");
		DatagramPacket packet1=new DatagramPacket(data, data.length,iP_Address,1234);
		client.send(packet1);
		System.out.println("information has been sent successfully");
		
		//receiving data from the server
		byte dataReceived[] = new byte[1024];
		DatagramPacket packetReceived=new DatagramPacket(dataReceived, dataReceived.length);
		client.receive(packetReceived);
		String dataFromServer = new String(packetReceived.getData());
		InetAddress ipServerAddress= packetReceived.getAddress();
		System.out.println(iP_Address+" client receive from server"+ipServerAddress+" the mesage:"+dataFromServer);
		System.out.println("-----End of client connection-----");
	}

}
