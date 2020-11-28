package Main;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class server {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("server helloworld");
	
		byte[] buf;
		String response; 
		
		DatagramSocket socket = new DatagramSocket(4445);
do {
		buf = new byte[256];
		DatagramPacket packet = new DatagramPacket(buf, buf.length);
	        socket.receive(packet);
        
        
        	InetAddress address = packet.getAddress();
        	int port = packet.getPort();
        	packet = new DatagramPacket(buf, buf.length, address, port);
        	String received = new String(packet.getData(), 0, packet.getLength());

        
		response = SendAndReceive(received, 1200, n, 8, 1);

       	 	System.out.println("server received " + received);
        
        	System.out.println("server sending " + received);
        	socket.send(packet);

	
	} while (true);

	}

}