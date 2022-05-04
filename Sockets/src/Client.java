import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		try {
			Socket s= new Socket("127.0.0.1",123);
			OutputStream os = s.getOutputStream();
			//----------
			//Scanner clav = new Scanner(System.in);
			//System.out.println("Entre un nombre: ");
			//int nbr = clav.nextInt();
			//int req= nbr;
			//----------
			int req= 5;
			os.write(req);
			InputStream is = s.getInputStream();
			int rep = is.read();
			System.out.println("Le server a repondu :"+ rep);
			s.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
