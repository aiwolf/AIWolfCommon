package org.aiwolf.common.bin;
import java.io.IOException;
import java.net.SocketTimeoutException;

import org.aiwolf.common.data.Player;
import org.aiwolf.common.data.Role;
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

		//Add RoleRequest
		Role roleRequest = null;
		
		/**
		 * 
		 */
		String playerName = null;
		
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

					//RoleRequestStarterのｌ56～ｌ72を参考にして以下追加
					i++;
					try{
						if(i > args.length-1  || args[i].startsWith("-")){
							i--;
							roleRequest = null;
							continue;
						}
						roleRequest = Role.valueOf(args[i]);
					}catch(IllegalArgumentException e){
						System.err.println("No such role as "+args[i]);
						return;
					}
					
				}
				else if(args[i].equals("-n")){
					i++;
					playerName = args[i];
				}
			}
		}
		if(port < 0 || host == null || clsName == null){
			System.err.println("Usage:"+ClientStarter.class+" -h host -p port -c clientClass [-n name]");
			return;
		}

		Player player = (Player)Class.forName(clsName).newInstance();
		//引数にRoleRequestを追加
		TcpipClient client = new TcpipClient(host, port, roleRequest);
		if(playerName != null){
			client.setName(playerName);
//			System.out.println("Set name "+client.getName());
		}
		if(client.connect(player)){
//			System.out.println("Player connected to server:"+player);
		}
	}

}
