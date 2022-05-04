import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Principal_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			ServerSocket ss= new  ServerSocket(123); // create a server 
			System.out.println("server demarre sur le port 123");
			Socket s = ss.accept();// c'est lorsque le server accepte qu'on pourra etablir la connexion
			System.out.println("Une connexion est etablie avec :"+ss.getLocalPort());
			InputStream iStream =s.getInputStream(); //capturer le flux entrant
			int num =iStream.read();// lire un octet
			int rep= num*5;
			OutputStream os = s.getOutputStream() ;
			os.write(rep);
			os.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
