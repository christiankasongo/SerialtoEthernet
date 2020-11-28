package Main;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("helloworld");
		
		String message = "Hello";
        byte[] buf = message.getBytes();		
		
		DatagramSocket socket = new DatagramSocket();
        InetAddress address = InetAddress.getByName("localhost");
        
		DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4445);
		System.out.println("client sending 'hello'");
        socket.send(packet);
        
        packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);
        String received = new String(packet.getData(), 0, packet.getLength());
        System.out.println("client received " + received);
	}
}
