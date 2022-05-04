import java.io.*;
import java.net.*;

public class Client {

	public static void main(String[] args) throws Exception	
	{
		Socket clientSocket = new Socket("127.0.0.1",1234);
		if(clientSocket.isConnected()) {
			System.out.println("Connection to the server successly");
		}
		
		FileOutputStream f_out = new FileOutputStream("received.txt");
		DataInputStream data_in =new DataInputStream(clientSocket.getInputStream());
		int r;
		while((r=data_in.read())!=-1) {
			f_out.write(r);
		}
		System.out.println("***File received and saved successfuly***");
		clientSocket.close();
	}

}
