import java.io.IOException;
import java.net.SocketTimeoutException;

import org.aiwolf.common.data.Player;
import org.aiwolf.common.net.TcpipClient;


public class ClientStarter {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws SocketTimeoutException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args) throws SocketTimeoutException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		String host = null;
		int port = -1;
		String clsName = null;
		for(int i = 0; i < args.length; i++){
			if(args[i].startsWith("-")){
				if(args[i].equals("-p")){
					i++;
					port = Integer.parseInt(args[i]);
				}
				else if(args[i].equals("-h")){
					i++;
					host = args[i];
				}
				else if(args[i].equals("-c")){
					i++;
					clsName = args[i];
				}
			}
		}
		if(port < 0 || host == null || clsName == null){
			System.err.println("Usage:"+ClientStarter.class+" -h host -p port -c clientClass");
			return;
		}
		Player player = (Player)Class.forName(clsName).newInstance();
		TcpipClient client = new TcpipClient(host, port);
		if(client.connect(player)){
			System.out.println("Player connected to server:"+player);
		}
	}

}
