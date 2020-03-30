import java.io.*;
import java.net.*;
 
public class Client
{
public static void main(String argv[])
{
	BufferedReader in = null;
	PrintStream out = null;
	BufferedReader tastiera=new BufferedReader
			(new InputStreamReader(System.in));
	Socket socket = null;
	String messaggio;
	String messDalServer;
	String ip="localhost";
	int porta=4321;
	try
	{
		// open a socket connection
		socket = new Socket(ip, porta);//creiamo un nuovo socket con il Server
		// Ottiene un flusso di comunicazione in input associato al socket
		in = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		// Ottiene un flusso di comunicazione in output associato al socket
		out = new PrintStream(socket.getOutputStream(), true);
		// Legge dal server
		
		messDalServer = in.readLine();
		System.out.println("Server --> Client : " + messDalServer);
		
		out.println("Ciao server!");
		System.out.println("Client --> Server : Ciao server!");
		
		messDalServer=in.readLine();
		System.out.println("Server --> Client : " + messDalServer);
		do {
			System.out.println("Inserisci il messaggio da inviare al server:");
			messaggio=tastiera.readLine();
			//invia al server
			out.println(messaggio);
			System.out.println("Client --> Server : "+messaggio);
			messDalServer=in.readLine();
			System.out.println("Server --> Client : " + messDalServer);
		}while(!messaggio.toLowerCase().equals("stop"));
		out.close();
		in.close();
		socket.close();
	}
		catch(Exception e) { System.out.println(e.getMessage());}
	}
}
