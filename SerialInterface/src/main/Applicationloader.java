package main;

import com.fazecast.jSerialComm.SerialPort;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Applicationloader extends Application {

	private IOTextPane root;
	private Parent rootWithMenu;
	
	private SplitPane sp;
	private SplitPane sp2;
	private TextArea inputArea;
	private TextArea outputArea;
	
	@Override
	public void init() {
		root = new IOTextPane();
		
		//root.inputArea.textProperty().addListener(hexConverterListener());
		
		rootWithMenu = new BorderPane(root, new IOMenuBar(root), null, null, null);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Serial Communication");
		Scene scene = new Scene(rootWithMenu);
		scene.getStylesheets().add(this.getClass().getResource("styling.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	//a method that returns a ChangeListener, which sets the output area to display hex
		public ChangeListener<String> hexConverterListener() {
			return (observable, oldValue, newValue) -> {
				String cmd;
				
				cmd = mystringfunctions.LastCommand(newValue);
				
				if (cmd.length() > 0) {
					String res = SendAndReceive(cmd.toUpperCase());
					
					if (res.length() == 0) {
						root.setOutputAreaText("No response");
					}
					else
					{
						root.setOutputAreaText(res);
					}
				}
				//setOutputAreaText(toHex(newValue));
				
				//mystringfunctions.outputstringascii(newValue);
				
				//if (newValue.length() > 0) {
					
					//String str = "inputArea";
					//for (int i = 0, n = str.length(); i < n; i++) {
					//    char c = str.charAt(i);
					//    System.out.println(i+ "->" + str + "\t");
		
					//} 
					
							
					//String res = SendAndReceive(newValue.toUpperCase().substring(newValue.length() - 1, newValue.length()));
				//	String res = "";
					
				//	if (res.length() == -1) {
				//		setOutputAreaText("No response");
				//	}
				//	else
				//	{
				//		setOutputAreaText(res);
				//	}
				//}
				//	else
				//{
				//	System.out.println("Empty string from InputArea");
				//}
				//System.out.println("newValue=" + newValue + ", last character=" + newValue.substring(newValue.length() - 1, newValue.length()));
				
				//setOutputAreaText(SendAndReceive(newValue));
				//String res = SendAndReceive(newValue.toUpperCase());
				
				//if (res.length() == 0) {
				//	setOutputAreaText("No response");
				//}
				//else
				//{
				//	setOutputAreaText(res);
				//}
				
			};
		}

		//accepts an input string and returns a string in corresponding hexadecimal form
		//private String toHex(String input) {
		///	StringBuilder sb = new StringBuilder();
			///for (byte b : input.getBytes()) {
				//sb.append(String.format("%02X ", b));
			//}
			//return sb.toString();
		//}
		
		private String SendAndReceive(String input) {
			SerialPort myPort;
			String mywrites;
			String myreads;
			byte mywriteb[];
			byte myreadb[];	
			
			System.out.println("SendAndReceice - Start");
			
			myreads = "";
					
			myPort = SerialPort.getCommPort("tty.usbserial-1420");
			
			myPort.setComPortParameters(1200, 8, 1, 0);
			myPort.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING | SerialPort.TIMEOUT_READ_BLOCKING, 50, 50);
			myPort.openPort();
			
			if (myPort.isOpen()) {
				System.out.println("Port is open. Sending '"+ input + "'...");
				
				mywrites = input;
				
				// convert string mywrites into byte array mywriteb
				
				mywriteb= mywrites.getBytes();
				//System.out.println("String to byte array:" + Arrays.toString(byte////));
				
				for (int i = 0; i < mywriteb.length; i++) {
					System.out.println("Element " + String.valueOf(i) + " is: " + String.valueOf(mywriteb[i]));
				}
				
				myPort.writeBytes(mywriteb, mywriteb.length);
				
				//for(int i = 0; i <= 5; i++) {
				//	System.out.println("Attempt " + String.valueOf(i));
				
				//	if (myPort.bytesAvailable() > 0) {
					
						myreadb = new byte[1024]; //myPort.bytesAvailable()];
					
						myPort.readBytes(myreadb, myreadb.length);
					
						// convert byte array myreadb into string myreads
					
						myreads  = new String(myreadb);
						System.out.println("Read: '" + myreads + "'");
						
				//	}
				//	else
				//	{
				//		System.out.println("Nothing to read.");
				//	}
				//}
				
				myPort.closePort();
				System.out.println("Closed port.");
			}
			else {
				System.out.println("Port is not open.");
			}
			
			return myreads;
		}
}









