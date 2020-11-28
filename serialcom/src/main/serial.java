package main;
import com.fazecast.jSerialComm.SerialPort;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.CheckBox;

import javax.swing.JSplitPane;


public class serial extends Application {
		
		private Parent rootWithMenu;
		
		private BorderPane child;
		
		private HBox hb;
		//private GridPane gp;
		private ViewPane vp;
		private SplitPane sp;
		private TextArea inputArea;
		private TextArea outputArea;
		//combobox
		//private ComboBox<String> cboPort;
		//private ComboBox<Integer> cboBaud;
		//private ComboBox<IntegerComboItem> cboParity;
		//private ComboBox<Integer> cboDataBits;
		//private ComboBox<IntegerComboItem> cboStopBits;
		
		private PortSettingsPane psp;
		
		private MenuBar mnu;
		
		private TextField txtSend;
		private Button cmdSend;
		private ComboBox <String> cboTest;
		private CheckBox cr;
		private CheckBox lf;
		
	public serial() {
		
		InitForm();
		
		//mystringfunctions.outputstring("1");
		//sp = new SplitPane();
		//psp = new PortSettingsPane();
		//sp.setPadding(new Insets(10,10,10,10));
		
		//vp = new ViewPane();
		//vp.setPadding(new Insets (20, 20, 20, 20));
		
		//sp.setOrientation(Orientation.HORIZONTAL);
			
		inputArea = new TextArea();
		//inputArea.setPrefRowCount(20);
		//inputArea.setPrefColumnCount(20);
		//inputArea.setWrapText(true); 
		//inputArea.textProperty().addListener(SerialConverterListener());
		
		outputArea = new TextArea();
		//outputArea.setPrefRowCount(20);
		//outputArea.setPrefColumnCount(20);
		//outputArea.setWrapText(true);
		//outputArea.setEditable(false);
		
		//sp.getItems().addAll(inputArea, outputArea);
		
		
		

		 //   HBox hbox = new HBox();
		 //   hbox.setPadding(new Insets(20, 15, 15, 10));
		 //   hbox.setSpacing(10);
		 //   hbox.setStyle("-fx-background-color: #336699;");
		    
		 //   TextField txt = new TextField ();
		    
		 //   Button btn = new Button("Send");
		 //   btn.setPrefSize(100, 20);
		    
		 //   hbox.getChildren().addAll(txt, btn);

		
		//hb = new HBox ();
		//hb.setPadding(new Insets(20,20,20,20));
		//hb.setSpacing(10);
		
		//gp = new GridPane ();
		//gp.setPadding(new Insets(20,20,20,20));
		//spacing
		//gp.setHgap(10);
		
		//mystringfunctions.outputstring("2");
		
		
		//cboPort = new ComboBox<String> ();
		//ObservableList <String> Ports = FXCollections.observableArrayList();
		
		//mystringfunctions.outputstring("3");
		
		//looping over the commports. each name getting added onto the port list.
		//for (SerialPort p: SerialPort.getCommPorts()) {
			//Ports.add(p.getSystemPortName());
		//}
		
		//ports list added onto combobox
		//cboPort.setItems(Ports);
		
		//mystringfunctions.outputstring("4");
		
		//cboBaud = new ComboBox<Integer>();
		//ObservableList <Integer> bauds = FXCollections.observableArrayList(1200, 2400, 4800, 9600, 19200);
		//cboBaud.setItems(bauds);
		//cboBaud.setValue(1200);
		
		//cboParity = new ComboBox<IntegerComboItem> ();
		//ObservableList <IntegerComboItem> Parity = FXCollections.observableArrayList(new IntegerComboItem ("None", 0), new IntegerComboItem("Even", 2), new IntegerComboItem ("Odd", 1));
		//cboParity.setItems(Parity);
		//cboParity.getSelectionModel().select(0); // select first item
	
		//cboDataBits = new ComboBox<Integer>();
		//ObservableList <Integer> DataBits = FXCollections.observableArrayList(5, 6, 7, 8);
		//cboDataBits.setItems(DataBits);
		//cboDataBits.setValue(8);
		
		//mystringfunctions.outputstring("5");
		
		
		//cboStopBits = new ComboBox<IntegerComboItem>();
		//ObservableList <IntegerComboItem> StopBits = FXCollections.observableArrayList(new IntegerComboItem ("1", 1), new IntegerComboItem("1.5", 2), new IntegerComboItem("2", 3));
		//cboStopBits.setItems(StopBits);
		//cboStopBits.getSelectionModel().select(0); // select first item
		
		//Label lblcbo = new Label("Port");
		//gp.add(lblcbo, 0, 0);
 		//gp.add(cboPort, 0,1);
 		
 		// row and column
 		//lblcbo = new Label("Baud");
 		//gp.add(lblcbo, 1, 0);
 		//gp.add(cboBaud, 1,1);
 		
 		
 		//lblcbo = new Label("Parity");
 		//gp.add(lblcbo, 2, 0);
 		//gp.add(cboParity, 2, 1);
 		
 		//lblcbo = new Label("DataBits");
 		//gp.add(lblcbo, 3, 0);
 		//gp.add(cboDataBits, 3,1 );
 		
 		//lblcbo = new Label("StopBits");
 		//gp.add(lblcbo, 4, 0);
 		//gp.add(cboStopBits, 4, 1);
 		
 		//mystringfunctions.outputstring("6");
 		
		//child = new BorderPane(vp, psp, null, null, null);
		//child.setPadding(new Insets(10,10,10,10));

		//mnu = new MenuBar();
		
		//Menu tl;
		//MenuItem itm;
		
		//tl = new Menu("Options");
		//itm = new MenuItem("_About");
		//itm.setAccelerator(KeyCombination.keyCombination("SHORTCUT+B"));
		//itm.setOnAction(new AboutHandler());
		//tl.getItems().add(itm);
		//mnu.getMenus().add(tl);
				
		//itm = new MenuItem("_Exit");
		//itm.setAccelerator(KeyCombination.keyCombination("SHORTCUT+Q"));
		//itm.setOnAction(e -> System.exit(0));
		//tl.getItems().add(itm);
		
		
		//rootWithMenu = new BorderPane(child, mnu, null, null, null);	
		
		//mystringfunctions.outputstring("7");
		
	}	
	
	private HBox CommandPane() {
		HBox hb = new HBox();
		hb.setSpacing(10);
		hb.setPadding(new Insets(8,10,10,10));
		
		txtSend = new TextField();
		txtSend.setEditable(true);
		txtSend.setOnKeyPressed(e -> {
	        if (e.getCode() == KeyCode.ENTER) {
	            
	        	SendEx();
	        }
	    });
				
		cmdSend = new Button("Send");
		cmdSend.setOnAction(this::ButtonClick);
		
		
		//cmdSend.setOnAction(new EventHandler<ActionEvent> () {
	    // public void handle(ActionEvent event) {
	    //	 System.out.println("sent");
        // }
	     
    // });	
		cboTest = new ComboBox <String> ();
		ObservableList <String> Test = FXCollections.observableArrayList("blocking", "nonblocking");
		cboTest.setItems(Test);
		
		
		cr = new CheckBox("CR");
		lf = new CheckBox("LF");
		
		
		hb.getChildren().addAll(txtSend, cboTest, cr, lf, cmdSend);
		
		return hb;
				
	}
	
	private VBox SerialPane() {
		VBox vb = new VBox();
		
		psp = new PortSettingsPane();
		
		vb.getChildren().addAll(psp, CommandPane());
		
		return vb;
	}
	
	private MenuBar FormMenu() {
        mnu = new MenuBar();
		
		Menu tl;
		MenuItem itm;
		
		
		tl = new Menu("Options");
		itm = new MenuItem("_Refresh");
		itm.setAccelerator(KeyCombination.keyCombination("SHORTCUT+R"));
		itm.setOnAction(e -> psp.refreshPorts()); //new RefreshHandler());
		tl.getItems().add(itm);
		mnu.getMenus().add(tl);
		
		
		itm = new MenuItem("_Clear");
		itm.setAccelerator(KeyCombination.keyCombination("SHORTCUT+D"));
		itm.setOnAction(e -> vp.clear());
		tl.getItems().add(itm);
		
		
		itm = new MenuItem("_About");
		itm.setAccelerator(KeyCombination.keyCombination("SHORTCUT+B"));
		itm.setOnAction(new AboutHandler()); // attached event handler
		tl.getItems().add(itm);
		
		
		itm = new MenuItem("_Exit");
		itm.setAccelerator(KeyCombination.keyCombination("SHORTCUT+Q"));
		itm.setOnAction(e -> System.exit(0));
		tl.getItems().add(itm);
		
	
		return mnu;
		
	}
	
	private void InitForm() {
		
		vp = new ViewPane();
		
		child = new BorderPane(vp, SerialPane(), null, null , null);
		child.setPadding(new Insets(10,10,10,10));
		//child.setAlignment(child, value);
		
		rootWithMenu = new BorderPane(child, FormMenu(), null, null, null);	
	}
	//no time block does not limit 
	private String NonBlockingSendAndReceive(String input, String portname, Integer baudrate, Integer parity, Integer databits, Integer stopbits, Integer flowcontrol) throws InterruptedException {
		String reads = "";
		SerialPort port;
		byte[]readBuffer;
		byte mywriteb[];
		int tries = 0;
		int toRead = 0;
		boolean retry = true;
		boolean dataReceived = false; // variable for recording data has been received.
		long startTime;
		long endTime;
		
		port = SerialPort.getCommPort(portname);
		
		port.setComPortParameters(baudrate, databits, stopbits, parity);
		port.setFlowControl(flowcontrol);
		port.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING , 0, 50);
		//port.setComPortParameters(9600, 8, 1, 0);
		
		// record time
		startTime = System.currentTimeMillis();
		port.openPort();
	
		// difference in now and recorded time
		// debug result
		
		mywriteb= input.getBytes();
		
		endTime = System.currentTimeMillis();
		System.out.println("time taken " + (endTime - startTime) + " milliseconds");
	
		//for (int i = 0; i < mywriteb.length; i++) {
		//"Element " + String.valueOf(i) + " is: " + String.valueOf(mywriteb[i]));
		//}
		
		// flush
		Flush (port);
		
		
	    // how long?
		startTime = System.currentTimeMillis();
		
		port.writeBytes(mywriteb, mywriteb.length);
		
		endTime = System.currentTimeMillis();
		System.out.println("time taken " + (endTime - startTime) + " milliseconds");
		
		//do {
		//	Thread.sleep(20);
			
		//	toRead = port.bytesAvailable();
		
		//	if (toRead == 0) {
				
		//		tries += 1;
			
		//		mystringfunctions.outputstring("Tries = " + String.valueOf(tries) + ", 0 Bytes available");
		
		//	}
		//	else {
		//		readBuffer = new byte[toRead];
		//		port.readBytes(readBuffer, toRead);
				
		//		int i = 0;
		//		while (i < readBuffer.length && readBuffer[i] != 0) {
		//			reads += (char) readBuffer[i];
		//			i += 1;
		//		}
		//		tries = 2;
				
		//		mystringfunctions.outputstring("Tries = " + String.valueOf(tries) + ", " + String.valueOf(toRead) + " Bytes available");
		//	}
	//	} while ( tries < 5);
		
		
		// time of whole do loop
		startTime = System.currentTimeMillis();
		do {
			Thread.sleep(20);
					
			toRead = port.bytesAvailable();
				
			if (toRead == 0) {
				tries += 1;
						
						
				if (tries == 10)  {// || dataReceived) {
					retry = false;
				}
				mystringfunctions.outputstring("Tries = " + String.valueOf(tries) + ", 0 Bytes available");
				
				
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
						
				mystringfunctions.outputstring("Tries = " + String.valueOf(tries) + ", " + String.valueOf(toRead) + " Bytes available");
			}
			
		} while ( retry == true);
		
				endTime = System.currentTimeMillis();
				System.out.println("time taken " + (endTime - startTime) + " milliseconds");
				
		port.closePort();
		
		return reads;
		
	}
		
	private void Flush(SerialPort port) {
		byte[]readBuffer;
		mystringfunctions.outputstring("FLUSH: - " + port.bytesAvailable());
		while(port.bytesAvailable() > 0) {
			readBuffer = new byte[port.bytesAvailable()];
			port.readBytes(readBuffer, port.bytesAvailable());
	}
} 
		
	private String SendAndReceive(String input, String portname, Integer baudrate, Integer parity, Integer databits, Integer stopbits, Integer flowcontrol) throws InterruptedException {
		SerialPort myPort;
		String mywrites;
		String myreads;
		byte mywriteb[];
		byte myreadb[];	
		long startTime;
		long endTime;
		
		System.out.println("SendAndReceice - Start");
		
		myreads = "";
		
				
		myPort = SerialPort.getCommPort(portname);
		
		myPort.setComPortParameters(baudrate, databits, stopbits, parity);
		myPort.setFlowControl(flowcontrol);
		myPort.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING | SerialPort.TIMEOUT_READ_BLOCKING, 5, 5);
		
		startTime = System.currentTimeMillis();
		
		myPort.openPort();
		endTime = System.currentTimeMillis();
			System.out.println("time taken " + (endTime - startTime) + " milliseconds");	
		
			
		if (myPort.isOpen()) {
			
			try {
				System.out.println("Port is open. Sending '"+ input + "'...");
			
				mywrites = input;	
	
				mywriteb= mywrites.getBytes();
			
			
				//for (int i = 0; i < mywriteb.length; i++) {
				//"Element " + String.valueOf(i) + " is: " + String.valueOf(mywriteb[i]));
				//}
				startTime = System.currentTimeMillis();
				
				myPort.writeBytes(mywriteb, mywriteb.length);
				
				endTime = System.currentTimeMillis();
				System.out.println("time taken " + (endTime - startTime) + " milliseconds");
				
				//System.out.println(myPort.bytesAvailable());
			
				myreadb = new byte[256];
				
			startTime = System.currentTimeMillis();
				myPort.readBytes(myreadb, myreadb.length);
				endTime = System.currentTimeMillis();
					System.out.println("time taken " + (endTime - startTime) + " milliseconds");
				int i = 0;
				
				while (i < myreadb.length && myreadb[i] != 0) {
					myreads += (char) myreadb[i];
					i += 1;
					
				}
			
				System.out.println(myreads.length());
				// instead of converting the byte array to string, need to loop over byte array and
				// only append character to return string if not chr(0).
				// for i = 0 to (bytearray.length - 1)
				//     if bytearray element[i] != chr(0) then
				//          append char of element[i] to return string
				//     else
				//          quit loop
				// next
				
				System.out.println("Read: '" + myreads + "'");
			}
			catch (Exception ex)
			{
				throw ex;
			}
			finally
			{
				myPort.closePort();
				System.out.println("Closed port.");
			}
		}
		else {
			System.out.println("Port is not open.");
			throw new RuntimeException("Unable to open port '" + portname + "'.");
		}
		
		return myreads;
		
	}
	
	//public String getTextFieldText() {
	//	return txtSend.getText();
	//}

	//public void setTextFieldText(String text) {
	//	txtSend.setText(text);
	//}
	
	//public void setOutputAreaText(String text) {
	//	outputArea.setText(text);
	//}
	
	//public ChangeListener<String> SerialConverterListener() {
	//	return (observable, oldValue, newValue) -> {	
	private void EnterPressed() {
			}
	
	private void ButtonClick(ActionEvent event) {
		SendEx();
	}
	
	private void SendEx() {
	        String cmd;
	        String cmdlist;

			cmd = txtSend.getText(); //mystringfunctions.LastCommand(newValue);
			cmdlist = cmd;
			
			if(cr.isSelected() == true ) {
				cmd = cmd + (char) 13;
				cmdlist = cmdlist + "[CR]";
			}
			
			if(lf.isSelected() == true) {
				cmd = cmd + (char) 10;
				cmdlist = cmdlist + "[LF]";
			}

			if (cmd.length() > 0) {
				
				//if (psp.getPort() == null) {
					
			//		Alert alert = new Alert(AlertType.WARNING);
			//		alert.setTitle("No port selected");
			//		alert.setHeaderText(null);
			//		alert.setContentText("Select a port from the combobox before sending a command.");
			//		alert.showAndWait();
					
			//	}
			//	else
			//	{
				
				try {
					   // Protected code
					String res; //SendAndReceive(cmd.toUpperCase(), psp.getPort(), psp.getBaud(), psp.getParity(), psp.getDataBits(), psp.getStopBits(), psp.getFlowControl());
					if (cboTest.getValue() =="blocking")
						res = SendAndReceive(cmd.toUpperCase(), psp.getPort(), psp.getBaud(), psp.getParity(), psp.getDataBits(), psp.getStopBits(), psp.getFlowControl());
						else {
							res = NonBlockingSendAndReceive(cmd.toUpperCase(), psp.getPort(), psp.getBaud(), psp.getParity(), psp.getDataBits(), psp.getStopBits(), psp.getFlowControl());
						}
						vp.addS(cmdlist.toUpperCase());
					
					if (res.length() == 0) 
						vp.addR("No response");
					else
					{
						byte mywriteb[] = res.getBytes();
						for (int i = 0; i < mywriteb.length; i++) {
							System.out.println("Element " + String.valueOf(i) + " is: " + String.valueOf(mywriteb[i]));
						}
						vp.addR(res);   //appendText(res + "\n");
						}
					
					
					
					} 
				catch (Exception ex) {
					   // Catch block
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("No port selected");
					alert.setHeaderText(null);
					alert.setContentText(ex.getMessage());
					alert.showAndWait();
					}
				
			
				
			//	}
			} 
				
		};
			
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Serial Communication");
		Scene scene = new Scene(rootWithMenu);
		scene.getStylesheets().add(this.getClass().getResource("styling.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	// ChangeListener<String> RaiseEventListener() {
	//	return (observable, oldValue, newValue) -> {
	
	//	};
		
	//}
	//private class AboutHandler implements EventHandler<ActionEvent> {

	//public void handle(ActionEvent e) {
	//Alert alert = new Alert(AlertType.INFORMATION);
	//alert.setTitle("Information Dialog");
	//alert.setHeaderText(null);
	//alert.setContentText("Serial Communication via Internet (IP/TCP)");
	//alert.showAndWait();
	//}
	//}

public static void main(String[] args) {
	launch(args);
	}

private class AboutHandler implements EventHandler<ActionEvent> {

	public void handle(ActionEvent e) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText(null);
		alert.setContentText("Serial Communication via Internet (IP/TCP)");
		alert.showAndWait();
	}
	
}

}
	