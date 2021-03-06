import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Game extends Thread 
{
  protected	Socket socket;
  protected int idPlayer;
  protected int secretNumber;
  protected String WinnerIP;
  protected int WinnerID;
  protected int numberOfPlayer=0;
  protected static boolean  END_OF_GAME=false;
  protected List<Game> players = new ArrayList<>();

protected void setPlayers(Game play) {
	players.add(play);
}
// constructor
public Game(Socket socket, int idPlayer, int secretNumber) {
	super();
	this.socket = socket;
	this.idPlayer = idPlayer;
	this.secretNumber = secretNumber;
	this.numberOfPlayer++;
}
public String explainGame() {
	String str;
	str="\n-----------------------------------------------------------------------\n"
			+ "The game <GUESS MISTERIOUS NUMBER> is base on guessing in a certain mount of try the misterious number which hidden between [0-100]\n"
			+ "\t\t and of-course you will have a fewer hint whether your number of try is bigger or smaller"
			+ "\n-----------------------------------------------------------------------\n";
	return str;
}
public void broadCast(String msg) throws Exception
{
	int i =0;
	for(Game s: players) {
		PrintWriter pw = new PrintWriter(s.socket.getOutputStream(),true);
		if(s.idPlayer!=WinnerID) {
			pw.println(msg);
		}
		
	}
}
  @Override
	public void run()
  {
	  
	  try {
		  		InputStream is =socket.getInputStream();
		  		OutputStream os =socket.getOutputStream();
		  		
		  		InputStreamReader isr =new InputStreamReader(is);
		  		BufferedReader br= new BufferedReader(isr);
		  		
		  		PrintWriter pw =new PrintWriter(os,true);
		  		String IP;
		  		IP=socket.getRemoteSocketAddress().toString();
		  		pw.println("***************WELCOME TO THE GAME****************");
		  		pw.println("------->You're the player number "+this.idPlayer+"<----------"); 
		  		System.out.println("Connection of the player n°"+this.idPlayer);
		  		pw.println(explainGame());
		  		pw.println("\n\t\t\t Game starting ");
		  		pw.println("->Enter a number :");
		  		//beginning of the game
		  		while(true)
		  		{
		  			String req;
		  			int numberOfTry;
		  			while((req=br.readLine())!=null && END_OF_GAME == false)
		  			{
		  				if(END_OF_GAME==false) 
		  				{
		  					System.out.println(IP+" :player n°:"+this.idPlayer+" a envoyé :"+req);
		  					numberOfTry = Integer.parseInt(req);
		  					if (numberOfTry>this.secretNumber) {
								pw.println("Your try is too big than the misterious number reduce it");
							}
		  					else if(numberOfTry<this.secretNumber){
								pw.println("Your try is too little split it up");
							}
		  					else {
		  						WinnerID=idPlayer;
		  						WinnerIP = IP;
		  						END_OF_GAME=true;
		  						System.out.println("Congrat to player n°"+idPlayer+" :Adress:"+WinnerIP+" He has just discovered the myster ");
		  						String message="===>Game Over the player n°"+this.WinnerID+" has won the part<===";
		  						pw.println("***************************************************************************");
								pw.println("Well donne you have just discovered the myster by guess the secret number");
								pw.println("***************************************************************************");
								broadCast(message);
							}
		  				}
		  				
		  			}
						pw.println("=====> Sorry the game is over <==========");
		  			break;
 		  		}
		  		socket.close();
		//--------------------
	} catch (Exception e) {
		e.printStackTrace();
	}
	  
  }
}
