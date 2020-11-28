package Main;
import com.fazecast.jSerialComm.SerialPort;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

	public class SerialCom extends Application {
		
		private Parent rootWithMenu;
		
		private BorderPane child;
		
		private ViewPane vp;
		private PortSettingsPane psp;
	
		private MenuBar mnu;
	
		private TextField txtSend;
		private Button cmdSend;
		
	public SerialCom() {
		
		InitForm();
	}	
	
	private HBox CommandPane() {
		HBox hb = new HBox();
		hb.setSpacing(10);
		hb.setPadding(new Insets(8,10,10,10));
		
		txtSend = new TextField();
		txtSend.setEditable(true);
		
		cmdSend = new Button("Send");
		cmdSend.setOnAction(this::ButtonClick);
		
		hb.getChildren().addAll(txtSend, cmdSend);
		
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
		
		rootWithMenu = new BorderPane(child, FormMenu(), null, null, null);	
	}
	
	private String SendAndReceive(String input, String portname, Integer baudrate, Integer parity, Integer databits, Integer stopbits) throws InterruptedException {
		SerialPort myPort;
		String mywrites;
		String myreads;
		byte mywriteb[];
		byte myreadb[];	
		
		System.out.println("SendAndReceice - Start");
		
		myreads = "";
		
				
		myPort = SerialPort.getCommPort(portname);
		
		myPort.setComPortParameters(1200, 8, 1, 0);
		myPort.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING | SerialPort.TIMEOUT_READ_BLOCKING, 50, 50);
		myPort.openPort();
		
		if (myPort.isOpen()) {
			
			try {
				System.out.println("Port is open. Sending '"+ input + "'...");
			
				mywrites = input;	
			
				mywriteb= mywrites.getBytes();
			
				myPort.writeBytes(mywriteb, mywriteb.length);
				
			
				myreadb = new byte[256];
			
				myPort.readBytes(myreadb, myreadb.length);
				
				int i = 0;
				
				while (i < myreadb.length && myreadb[i] != 0) {
					myreads += (char) myreadb[i];
					i += 1;
				}
			
				System.out.println(myreads.length());
				
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
	private void ButtonClick(ActionEvent event) {		
	        String cmd;
			
			cmd = txtSend.getText(); 
			
			if (cmd.length() > 0) {
			
				
				try {
					   // Protected code
					String res = SendAndReceive(cmd.toUpperCase(), psp.getPort(), psp.getBaud(), psp.getParity(), psp.getDataBits(), psp.getStopBits());
					vp.addS(cmd.toUpperCase());
					
					if (res.length() == 0) 
						vp.addR("No response");
					else
					{
						vp.addR(res); 
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