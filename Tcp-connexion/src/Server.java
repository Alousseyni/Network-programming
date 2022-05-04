import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(234);
			System.out.println("Listening for connexion ...");
			Socket s = ss.accept();
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			System.out.println("Connection succeful Wait for a number or information...");
			int num=is.read();
			int rep=num*5;
			System.out.println("result has been send to the client");
			//os.write(rep);
			//-------Reading a string----------//

			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
