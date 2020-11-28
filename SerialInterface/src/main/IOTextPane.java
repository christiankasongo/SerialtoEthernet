package main;

import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;

import com.fazecast.jSerialComm.SerialPort;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.swing.JSplitPane;

public class IOTextPane extends SplitPane {

	private TextArea inputArea, outputArea;
	private SplitPane sp;
	private ComboBox<String> cbo;

	public IOTextPane() {
		this.setPadding(new Insets(10,10,10,10));
		
		this.setOrientation(Orientation.VERTICAL);
		
		sp = new SplitPane();

		inputArea = new TextArea();
		inputArea.setPrefRowCount(20);
		inputArea.setPrefColumnCount(20);
		inputArea.setWrapText(true); 
		
		//attaches the listener created in the method below
		//inputArea.textProperty().addListener(hexConverterListener()); 

		outputArea = new TextArea();
		outputArea.setPrefRowCount(20);
		outputArea.setPrefColumnCount(20);
		outputArea.setWrapText(true);
		outputArea.setEditable(false);
		
		sp.getItems().addAll(inputArea, outputArea);

		this.getItems().addAll(cbo, sp);
		
		//mystringfunctions.outputstring(mystringfunctions.LastCommand("abc"));
		//mystringfunctions.outputstring(mystringfunctions.LastCommand("abc" + (char) 10));
		//mystringfunctions.outputstring(mystringfunctions.LastCommand("abc" + (char) 10 + "def"));
		//mystringfunctions.outputstring(mystringfunctions.LastCommand("abc" + (char) 10 + "def" + (char) 10));

	}

	//get/set methods to be used by other methods of this class and the external menu bar
	public String getInputAreaText() {
		return inputArea.getText();
	}

	public void setInputAreaText(String text) {
		inputArea.setText(text);
	}
	
	public void setOutputAreaText(String text) {
		outputArea.setText(text);
	}
	
	public ChangeListener<String> RaiseEventListener() {
		return (observable, oldValue, newValue) -> {
			// Raise own event
			
		};
		
	}


}
