
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Date;

public class ThreadClient extends Thread {
    Socket socket; 
    File f;
    FileWriter fw=null;
     public ThreadClient(Socket socketClient) 
    		 throws IOException
    {
        
        this.socket = socketClient;
        f=new File("log.txt");
        fw=new FileWriter(f,true);
       
    }
    
    @Override
    public void run()  {
       
            try
            {
            	String messaggio=null;
            	Date d=null;
            	BufferedReader in = new BufferedReader(
        				new InputStreamReader(socket.getInputStream()));
            	PrintStream out = new PrintStream(socket.getOutputStream(), true);
        		// invia al client
                out.println("Sei collegato al server. Attendo i tuoi messaggi. Quando ricevero' \"stop\" chiudero' la connessione");
               
               do {
            	   d=new Date();
            	   messaggio=in.readLine(); 
                   System.out.println("["+d.getDay()+"/"+d.getMonth()+"/"+d.getYear()+"] "+ " client: "+socket.getInetAddress()+" porta: "+socket.getPort()+" : "+messaggio);
                   fw.write("["+d.getDay()+"/"+d.getMonth()+"/"+d.getYear()+"] "+" client: "+socket.getInetAddress()+" porta: "+socket.getPort()+" : "+messaggio+"\n");
                   if(!messaggio.toLowerCase().equals("stop")) {
                	   out.println("OK messaggio ricevuto");
                   }
                   else {
                	   out.println("OK fine connessione");
                   }
               }while(!messaggio.toLowerCase().equals("stop"));
                   
                                         
               		socket.close(); 
               		fw.close();
                   
                } catch (IOException ex) {
                	ex.printStackTrace();
                }   
    }   
}