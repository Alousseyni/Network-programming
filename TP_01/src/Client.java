import java.net.*;
import java.io.*;
import java.util.Scanner;


public class Client
{

	public static void main(String[] args) throws Exception
	{
			//-------------------------------------------------------------------------
				Socket client = new Socket("127.0.0.1",1234);
				//tools for sending 
				InputStream is=client.getInputStream();
				OutputStream os=client.getOutputStream();
			
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				
				Scanner key = new Scanner(System.in);
				System.out.print("Enter an information: ");
				String str = key.next();
				
				//send the information to the server
				PrintWriter pw = new PrintWriter(os,true);
				pw.println(str);
				String iP_addClient=client.getInetAddress().toString();
				String iP_addServer=client.getRemoteSocketAddress().toString();
				System.out.println(iP_addClient+" has just sent :"+str+" to "+iP_addServer);
				String rep = br.readLine();
				System.out.println(rep);
				
				System.out.println("End of connection");
				
				//Script use to know which are port(reserver) available 
				
				int i=0;
				int nombrePortUtilisable=0;
				int nombrePortNonUtilisable=0;
				while (i<65_565) {
					i++;
					try {
						Socket cl = new Socket("127.0.0.1",i);
						nombrePortNonUtilisable++;
						System.out.println("le port :"+i+" est libre");
					} catch (Exception e) {
						//System.out.println("Le port :"+i+" est utiliser ");
						++nombrePortUtilisable;
						
					}
				
				}
				System.out.println("le nombre de port utiliser est:"+nombrePortUtilisable+"le nombre de port non utiliser ou libre est:"+nombrePortNonUtilisable);
				// sending an objet
				
				ObjectOutputStream oos = new ObjectOutputStream(os);
				Ville bko = new Ville(15_000_000,"Mali","Bamako");
				oos.writeObject(bko);
				oos.flush();
			//-------------------------------------------------------------------------
				client.close();

	}
	


}
