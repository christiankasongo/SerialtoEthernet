package main;

import com.fazecast.jSerialComm.SerialPort;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.IO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;

public class PortSettings {
	
	private String filename;
	private String PortName ="";
	private int Baud;
	private int Parity;
	private int DataBits;
	private int StopBits;
	private int FlowControl;
	
	public PortSettings (String fname) {
		filename = fname;
	}
	
	public String getPortName() {
		return PortName;	
	}
	public void setPortname(String pname) {
		PortName = pname;
	}
	
	
	public int getBaud() {
		return Baud;	
	}
	public void setBaud(int b) {
		Baud = b;
	}
	
	
	public int getParity() {
		return Parity;	
	}
	public void setParity(int p) {
		Parity = p;
	}
	
	
	public int getDataBits() {
		return DataBits;	
	}
	public void setDataBits(int db) {
		DataBits = db;
	}
	
	
	public int getStopBits() {
		return StopBits;	
	}
	public void setStopBits(int sb) {
		StopBits = sb;
	}
	
	
	public int getFlowControl() {
		return FlowControl;	
	}
	public void setFlowControl(int flc) {
		FlowControl= flc;
	}
	
	public boolean Read() {
	List<String> lines;
	
	System.out.println(filename);
	if(Files.exists(Paths.get(filename))) {
		
		try 
		{
			lines = Files.readAllLines(Paths.get(filename), StandardCharsets.UTF_8);
			if(lines.size() > 5) {
				PortName= lines.get(0);
				Baud = Integer.parseInt(lines.get(1));
				Parity = Integer.parseInt(lines.get(2));
				DataBits = Integer.parseInt(lines.get(3));
				StopBits = Integer.parseInt(lines.get(4));
				FlowControl = Integer.parseInt(lines.get(5));
				
			}
			else {
				System.out.println("Read Settings - Fields in file less than 5.");
				return false;
			}
			
		}catch (Exception e) {
			System.out.println("Error reading settings");
			
			e.printStackTrace();
			
			return false;
		}
	}
	else {
		System.out.println("Settings file not found at - " + filename);
		return false;
	}
	
		return true;
	}
	
	public boolean Save() {
		
		try {
			List<String> lines = Arrays.asList(PortName, String.valueOf(Baud), String.valueOf(Parity), String.valueOf(DataBits), String.valueOf(StopBits), String.valueOf(FlowControl));
			Path file = Paths.get(filename);
			Files.write(file, lines, StandardCharsets.UTF_8);
			
		}catch (Exception e) {
			
			return false;
		}
		return true;
	}
}