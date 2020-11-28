package main;

import com.fazecast.jSerialComm.SerialPort;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class PortSettingsPane  extends GridPane {
	
	private ComboBox<StringComboItem> cboPort;
	private ComboBox<Integer> cboBaud;
	private ComboBox<IntegerComboItem> cboParity;
	private ComboBox<Integer> cboDataBits;
	private ComboBox<IntegerComboItem> cboStopBits;
	private ComboBox <IntegerComboItem> cboFlowControl;
	
	

	public PortSettingsPane () {
		this.setPadding(new Insets(6, 6, 6, 6));
		//spacing
		this.setHgap(10);
		
		cboPort = new ComboBox<StringComboItem> ();
		ObservableList <StringComboItem> Port = FXCollections.observableArrayList();
		refreshPorts();
		
		cboBaud = new ComboBox<Integer>();
		ObservableList <Integer> bauds = FXCollections.observableArrayList(1200, 2400, 4800, 9600, 19200);
		cboBaud.setItems(bauds);
		cboBaud.setValue(1200);
		
		cboParity = new ComboBox<IntegerComboItem> ();
		ObservableList <IntegerComboItem> Parity = FXCollections.observableArrayList(new IntegerComboItem ("None", com.fazecast.jSerialComm.SerialPort.NO_PARITY), new IntegerComboItem("Even", com.fazecast.jSerialComm.SerialPort.EVEN_PARITY), new IntegerComboItem ("Odd", com.fazecast.jSerialComm.SerialPort.ODD_PARITY));
		cboParity.setItems(Parity);
		cboParity.getSelectionModel().select(0); // select first item
	
		cboDataBits = new ComboBox<Integer>();
		ObservableList <Integer> DataBits = FXCollections.observableArrayList(5, 6, 7, 8);
		cboDataBits.setItems(DataBits);
		cboDataBits.setValue(7);
				
		cboStopBits = new ComboBox<IntegerComboItem>();
		ObservableList <IntegerComboItem> StopBits = FXCollections.observableArrayList(new IntegerComboItem ("1", com.fazecast.jSerialComm.SerialPort.ONE_STOP_BIT), new IntegerComboItem("1.5", com.fazecast.jSerialComm.SerialPort.ONE_POINT_FIVE_STOP_BITS), new IntegerComboItem("2", com.fazecast.jSerialComm.SerialPort.TWO_STOP_BITS));
		cboStopBits.setItems(StopBits);
		cboStopBits.getSelectionModel().select(0); // select first item
		
		cboFlowControl = new ComboBox <IntegerComboItem> ();
		ObservableList <IntegerComboItem> FlowControl =  FXCollections.observableArrayList(new IntegerComboItem ("None", com.fazecast.jSerialComm.SerialPort.FLOW_CONTROL_DISABLED), new IntegerComboItem("RTS/CTS", com.fazecast.jSerialComm.SerialPort.FLOW_CONTROL_CTS_ENABLED | com.fazecast.jSerialComm.SerialPort.FLOW_CONTROL_RTS_ENABLED),  new IntegerComboItem("Xon", com.fazecast.jSerialComm.SerialPort.FLOW_CONTROL_XONXOFF_IN_ENABLED), new IntegerComboItem ("Xoff", com.fazecast.jSerialComm.SerialPort.FLOW_CONTROL_XONXOFF_OUT_ENABLED), new IntegerComboItem("Xon/Xoff", com.fazecast.jSerialComm.SerialPort.FLOW_CONTROL_XONXOFF_IN_ENABLED | com.fazecast.jSerialComm.SerialPort.FLOW_CONTROL_XONXOFF_OUT_ENABLED));
		cboFlowControl.setItems(FlowControl);
		cboFlowControl.getSelectionModel().select(0);
		
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
 		
 		lblcbo = new Label ("FlowContol");
 		this.add(lblcbo, 5, 0);
 		this.add(cboFlowControl, 5, 1);
	}
	
	public boolean isPortselected() {
		return cboPort.getValue() != null;
	}
	public String getPort() {
		return cboPort.getValue().value;
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
	public Integer getFlowControl() {
		return cboFlowControl.getValue().value;
	}
	
	
	public void refreshPorts() {
		ObservableList <StringComboItem> Ports = FXCollections.observableArrayList();
		
		cboPort.getItems().clear();
		
		//looping over the commports. each name getting added onto the port list.
		for (SerialPort p: SerialPort.getCommPorts()) {
			Ports.add(new StringComboItem (p.getDescriptivePortName(), p.getSystemPortName()));
		}
						
		//ports list added onto combobox
		cboPort.setItems(Ports);
	}
	
}
