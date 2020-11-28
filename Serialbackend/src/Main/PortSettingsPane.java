package Main;

import com.fazecast.jSerialComm.SerialPort;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import Main.IntegerComboItem;

public class PortSettingsPane extends GridPane {
	
	private ComboBox<String> cboPort;
	private ComboBox<Integer> cboBaud;
	private ComboBox<IntegerComboItem> cboParity;
	private ComboBox<Integer> cboDataBits;
	private ComboBox<IntegerComboItem> cboStopBits;
	
	public PortSettingsPane () {
		this.setPadding(new Insets(6, 6, 6, 6));
		
		
		this.setHgap(10); //spacing
		
		cboPort = new ComboBox<String> ();
		
		refreshPorts();
		
		cboBaud = new ComboBox<Integer>();
		ObservableList <Integer> bauds = FXCollections.observableArrayList(1200, 2400, 4800, 9600, 19200);
		cboBaud.setItems(bauds);
		cboBaud.setValue(1200);
		
		cboParity = new ComboBox<IntegerComboItem> ();
		ObservableList <IntegerComboItem> Parity = FXCollections.observableArrayList(new IntegerComboItem ("None", 0), new IntegerComboItem("Even", 2), new IntegerComboItem ("Odd", 1));
		cboParity.setItems(Parity);
		cboParity.getSelectionModel().select(0); // select first item
	
		cboDataBits = new ComboBox<Integer>();
		ObservableList <Integer> DataBits = FXCollections.observableArrayList(5, 6, 7, 8);
		cboDataBits.setItems(DataBits);
		cboDataBits.setValue(8);
				
		cboStopBits = new ComboBox<IntegerComboItem>();
		ObservableList <IntegerComboItem> StopBits = FXCollections.observableArrayList(new IntegerComboItem ("1", 1), new IntegerComboItem("1.5", 2), new IntegerComboItem("2", 3));
		cboStopBits.setItems(StopBits);
		cboStopBits.getSelectionModel().select(0); // select first item
		
		Label lblcbo = new Label("Port");
		this.add(lblcbo, 0, 0);
 		this.add(cboPort, 0,1);
 		
 		// row and column
 		lblcbo = new Label("Baud");
 		this.add(lblcbo, 1, 0);
 		this.add(cboBaud, 1,1);
 		
 		
 		lblcbo = new Label("Parity");
 		this.add(lblcbo, 2, 0);
 		this.add(cboParity, 2, 1);
 		
 		lblcbo = new Label("DataBits");
 		this.add(lblcbo, 3, 0);
 		this.add(cboDataBits, 3,1 );
 		
 		lblcbo = new Label("StopBits");
 		this.add(lblcbo, 4, 0);
 		this.add(cboStopBits, 4, 1);	
	}
	public String getPort() {
		return cboPort.getValue();
	}
	public Integer getBaud() {
		return cboBaud.getValue();
	}
	public Integer getParity() {
		return cboParity.getValue().value;
	}
	public Integer getDataBits() {
		return cboDataBits.getValue();
	}
	public Integer getStopBits() {
		return cboStopBits.getValue().value;
	}
	
	public void refreshPorts() {
		ObservableList <String> Ports = FXCollections.observableArrayList();
		
		cboPort.getItems().clear();
		
		//looping over the commports. each name getting added onto the port list.
		for (SerialPort p: SerialPort.getCommPorts()) {
			Ports.add(p.getSystemPortName());
		}
						
		//ports list added onto combobox
		cboPort.setItems(Ports);
	}	
}
