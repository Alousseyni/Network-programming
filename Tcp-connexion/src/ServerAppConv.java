import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerAppConv extends Thread{
	int nombreClients;
	
	@Override
	public void run() 
	{
		try {
			ServerSocket ss = new ServerSocket(234);
			//pour que les server sois capable de connecter les client a n'import quelle moment il faut un boucle
			while(true) 
			{
				Socket s = ss.accept();
				++nombreClients;
				Conversation client =new Conversation(s,nombreClients);
				client.start(); 
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// class conversation
	public class Conversation extends Thread{
		private Socket socket;
		private int numeroClient;
		public Conversation(Socket socket,int num) {
			super();
			this.socket = socket;
			this.numeroClient =num;
		}

		@Override
		public void run() {
			// code de conversation
			try {
					//objet utiliser pour lire les caracter
					InputStream is = socket.getInputStream();
					InputStreamReader isr = new InputStreamReader(is);
					BufferedReader br = new BufferedReader(isr);
					// les objet pour envoyer
					OutputStream os = socket.getOutputStream();
					PrintWriter pw = new PrintWriter(os,true);
					 
					// afficher au niveau du server les info sur le client
					String clientDetails = socket.getRemoteSocketAddress().toString();
					System.out.println("Connexion du client numero:"+this.numeroClient+" et a pour information:"+clientDetails);
					pw.println("Bienvenu vous etes le client numero:"+this.numeroClient);
					// debut de la conversation 
					while(true) {
						String req=br.readLine(); // permet de lire ce que l'utilisateur a entre ou la requete	
						System.out.println(clientDetails+" a envoyer la requete :"+req);
						if (req != null) {
							String rep="size:"+req.length();//preparer la reponse 
							pw.println(rep);//repondre le client 
						}
					}
					
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
	
//------------------methode principale-------------- //
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerAppConv listenAppConv=new ServerAppConv();
		listenAppConv.start();
		

	}

}
