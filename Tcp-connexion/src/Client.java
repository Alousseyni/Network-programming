import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Client {

	public static void main(String[] args) {
		// creating a connection
		try {
			Socket s = new Socket("localhost",1234);
			InputStream is = s.getInputStream();
			OutputStream os= s.getOutputStream();
			// get a number from the console
			Scanner sc =new Scanner(System.in);
			System.out.print("Entre un nombre:");
			int num = sc.nextInt();
			
			os.write(num);
			int rep = is.read();
			System.out.println("resultat:"+rep);
			s.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
	}

  }
}