import java.io.FileInputStream;
import java.util.Properties;

import javax.swing.JOptionPane;


public class LeggereFileConfig {
public static void main(String args[]) {
	Properties configFile = new Properties();
	System.out.println("reading configuration file:\n");
	String nomeFileProprieta="./server.properties";
	try {
		configFile.load(new FileInputStream(nomeFileProprieta));
	} catch (Exception e){
		// TODO Auto-generated catch block
		e.printStackTrace();
		 JOptionPane.showMessageDialog(null,"Problemi nel caricamento del file server.properties" +
			 		"\nL'applicazione verra' terminata");
		System.exit(1);
	}
	int porta=Integer.parseInt(configFile.getProperty("PORTA").trim());
	int maxConn = Integer.parseInt(configFile.getProperty("MAX_CONNESSIONI").trim());
	String path=configFile.getProperty("PATH");
	System.out.println("Porta: "+porta+"\nMax connessioni: "+maxConn+"\nPath: "+path);
	
}
}
