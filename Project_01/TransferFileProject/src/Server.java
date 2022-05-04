import java.io.*;
import java.net.*;

public class Server {

	public static void main(String[] args) throws Exception
	{
		ServerSocket ss = new ServerSocket(1234);
		System.out.println("The server is in listening mode ...");
		Socket s =ss.accept();
		System.out.println("A host has been successfuly connected");

		FileInputStream f_input = new FileInputStream("send.txt");
		DataOutputStream data_out = new DataOutputStream(s.getOutputStream());
		int r;
		while((r=f_input.read())!=-1) {
			data_out.write(r);
		}
		System.out.println("*****File transfer completed !!!*****");
		s.close();
		ss.close();
		
	}

}
