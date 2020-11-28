package Main;

import java.io.IOException; 
import java.net.DatagramPacket; 
import java.net.DatagramSocket; 
import java.net.InetAddress; 
import java.net.SocketException;
import com.fazecast.jSerialComm.SerialPort;


public class UDP_server {
	
	static PortSettings MySettings;
	
	public static void main(String[] args) throws Exception 
	{ 
		
		DatagramSocket socket;
		byte[] receive; // = new byte[256]; 
		DatagramPacket packet = null;
		InetAddress ip;
		SerialPort port;
		
		MySettings = new PortSettings(System.getProperty("user.dir") + "/settings.txt");
		
		if (!MySettings.Read())
			return;
		
		// attempt to open port with port with settings.
		// if that fails then quit.
		//try and catch?
		
		try {
			port = SerialPort.getCommPort(MySettings.getPortName());
		
			port.setComPortParameters(MySettings.getBaud(), MySettings.getDataBits(), MySettings.getStopBits(), MySettings.getParity());
			port.setFlowControl(MySettings.getFlowControl());
			port.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING , 0, 50);
	
			port.openPort();
		
		} catch (Exception e) {
			System.out.println("Error occured openning the port");
			e.printStackTrace();
			return;
			
		}
		
		 if (!port.isOpen())
		{
			System.out.println("Port not opened"); 
			return;
		}
		
		try {		
			socket = new DatagramSocket(4445);
			System.out.println("Server listening on Port 4445");
			
		} catch (Exception e) {
			System.out.println("Error occured creating DatagramSocket");
			e.printStackTrace();
			return;
		}
	
		while (true) 
		{ 
			// Clear the buffer before every message.
			receive = new byte[256];
			
			// DatgramPacket to receive the data. 
			packet = new DatagramPacket(receive, receive.length);
			socket.receive(packet);
			System.out.println("Client:-" + data(receive)); 

			// Exit the server if the client sends "quit" 
			if (data(receive).toString().equals("quit")) 
			{ 
				System.out.println("Client sent quit.....EXITING"); 
				break; 
			} 
			else {
				try {
					
					String serialResponse;
					
					
					serialResponse = SendAndReceive(data(receive).toString(), port);
					
					System.out.println("Received from SerialPort: '" + serialResponse + "'");
					
					ip = packet.getAddress();
					int Pport = packet.getPort();
					packet = new DatagramPacket(serialResponse.getBytes(), serialResponse.length(), ip, Pport);
					//String received = new String(packet.getData(),0,packet.getLength());
					
					socket.send(packet);
				} catch (IOException e) {
					
				}
			}
		} 
		
		// close the port(s)
		socket.close();
		// close the serial port.
	} 
	
	private static String SendAndReceive(String input, SerialPort port) throws InterruptedException {
		String reads = "";
//		SerialPort port;
		byte[]readBuffer;
		byte mywriteb[];
		int tries = 0;
		int toRead = 0;
		boolean retry = true;
		boolean dataReceived = false;
		
		mywriteb= input.getBytes();
		
		Flush (port);
		
		port.writeBytes(mywriteb, mywriteb.length);

		do {
			Thread.sleep(40);
					
			toRead = port.bytesAvailable();
				
			if (toRead <= 0) {
				tries += 1;
						
						
				if (tries == 3)  {
					retry = false;
				}
				System.out.println("Tries = " + String.valueOf(tries) + ", 0 Bytes available");
				
				
			}
			else {
				readBuffer = new byte[toRead];
				port.readBytes(readBuffer, toRead);
						
				int i = 0;
				while (i < readBuffer.length && readBuffer[i] != 0) {
					reads += (char) readBuffer[i];
					i += 1;
				}
				dataReceived = true;
				tries = 0;
						
				System.out.println("Tries = " + String.valueOf(tries) + ", " + String.valueOf(toRead) + " Bytes available");
			}
			
		} while ( retry == true);
				
		
		return reads;
		
	}
	
	private static void Flush(SerialPort port) {
		byte[]readBuffer;
		System.out.println("FLUSH: - " + port.bytesAvailable());
		while(port.bytesAvailable() > 0) {
			readBuffer = new byte[port.bytesAvailable()];
			port.readBytes(readBuffer, port.bytesAvailable());
		}
	}

	// A utility method to convert the byte array 
	// data into a string representation. 
	public static StringBuilder data(byte[] a) 
	{ 
		if (a == null) 
			return null; 
		StringBuilder ret = new StringBuilder(); 
		int i = 0; 
		while (a[i] != 0) 
		{ 
			ret.append((char) a[i]); 
			i++; 
		} 
		return ret; 
	} 
	
} 
