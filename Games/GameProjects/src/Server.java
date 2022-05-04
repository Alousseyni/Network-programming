import java.net.*;
import java.io.*;
import java.math.*;

public class Server extends Thread
{
	@Override
	public void run() {
		try {
			ServerSocket ss = new ServerSocket(234);
			int idPlayer=0;
			int secretNumber = (int)(Math.random()*100);
			while(true){
				System.out.println("Server is listening...");
				Socket socket = ss.accept();
				++idPlayer;
				Game players = new Game(socket, idPlayer, secretNumber);
				players.setPlayers(players);
				players.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//-----------------------
	public static void main(String[] args) {
		Server play = new Server();
		play.start();
		
	}

}
