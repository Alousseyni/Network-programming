
import java.io.*;
import java.net.*;

public class Server 
{

	public static void main(String[] args) 
	{
		
		try {
		//-------------------------------------------------------------------------
			ServerSocket ss = new ServerSocket(1234);

			
			System.out.println("Listenning for a connexion....");
			Socket s= ss.accept();

			System.out.println("---- Connection succcessful to a client ----");
			System.out.println("Waiting for information");
			// tools for fetching information
			InputStream is= s.getInputStream();
			OutputStream os = s.getOutputStream();
			
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String str  = br.readLine();
			System.out.println("message received:"+str);
			PrintWriter pw = new PrintWriter(os,true);
			pw.println("message "+str+" received succelly by the server");

			
			//receiving the objet
			ObjectInputStream ois = new ObjectInputStream(is);
			Ville bko =(Ville)ois.readObject();
			 System.out.println(bko.toString());
			System.out.println("End of connection");
		//-------------------------------------------------------------------------	
			s.close();
			ss.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
