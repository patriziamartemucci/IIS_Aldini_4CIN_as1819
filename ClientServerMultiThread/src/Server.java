
import java.net.*;
import java.io.*;


public class Server{

   public static void main(String args[]){
	
	   	int porta=4321;
		ServerSocket socketServer = null;
		try {
			socketServer = new ServerSocket(porta);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		while(true){
			Socket socketClient;
			try {
				System.out.println("Server in attesa di connessione in ascolto sulla porta "+porta);
				socketClient = socketServer.accept();
				ThreadClient t = new ThreadClient (socketClient);
                t.start();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	
	}
}