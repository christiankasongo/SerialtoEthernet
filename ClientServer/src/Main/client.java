package Main;

import java.io.IOException; 
import java.net.DatagramPacket; 
import java.net.DatagramSocket; 
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.util.Scanner; 

public class client {
	
	public static void main(String args[]) throws IOException 
	{ 
		Scanner sc = new Scanner(System.in);
		InetAddress ip = null;
		String fromuser;
		boolean valid = false;
		DatagramSocket socket = new DatagramSocket(); 
		byte buf[] = null;
		
		
		do {
			System.out.println("Enter IP Address to send to [empty to close]...");
			
			fromuser = sc.nextLine();
			
			if (fromuser.isEmpty()) {
				valid = true;
			}
			else {
		
				try {
					ip =  InetAddress.getByName(fromuser);
			
					valid = true;
					}
				catch (Exception e) {
					System.out.println("invalid IP address");
		
				}
			}
			
		}	while (!valid);
		
		if (ip != null) {
			
			System.out.println("Type command to send ['bye' to close]...");
		
			while (true) {
			
				String inp = sc.nextLine(); 
				
				inp = inp.replace((char)47, (char)10); // LINE FEED = /
				inp = inp.replace((char)36, (char)13); // CARRIAGE RETURN = $
				
				if(inp.isEmpty()); // if inp is empty, error message to user to enter a command
				
				buf = inp.getBytes(); 
				
				
				DatagramPacket packet = new DatagramPacket(buf, buf.length, ip, 4445); 
				socket.send(packet); 
				
				if (inp.equals("quit"))
					break;
				
				else {
					buf = new byte[256]; 
					packet = new DatagramPacket(buf,buf.length);
				
					socket.setSoTimeout(5000);
				
					try {
						socket.receive(packet);
						String received = new String(packet.getData(), 0, packet.getLength());
						System.out.println("[Server echo]..." + received);
					}
					catch (SocketTimeoutException e) {
						System.out.println("Timeout reached!" + e);
					}
						
				}
				
			}
			// close port
			socket.close();
		}
		else {
			System.out.println("Closing.");
		}
	}
	
	} 