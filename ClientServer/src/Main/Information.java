package Main;

import com.fazecast.jSerialComm.SerialPort;

public class Information {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Parities...");
		System.out.println("None = " + String.valueOf(com.fazecast.jSerialComm.SerialPort.NO_PARITY));
		System.out.println("Even = " + String.valueOf(com.fazecast.jSerialComm.SerialPort.EVEN_PARITY));
		System.out.println("Odd = " + String.valueOf(com.fazecast.jSerialComm.SerialPort.ODD_PARITY));
		
		System.out.println();
		System.out.println();

		
		System.out.println("Stopbit...");
		System.out.println("1 =" + String.valueOf(com.fazecast.jSerialComm.SerialPort.ONE_STOP_BIT));
		System.out.println("1.5 =" + String.valueOf(com.fazecast.jSerialComm.SerialPort.ONE_POINT_FIVE_STOP_BITS));
		System.out.println("2 =" + String.valueOf(com.fazecast.jSerialComm.SerialPort.TWO_STOP_BITS));
		
		System.out.println();
		System.out.println();
	
		
		
		System.out.println("FlowControl");
		System.out.println("None =" + String.valueOf(com.fazecast.jSerialComm.SerialPort.FLOW_CONTROL_DISABLED));
		System.out.println("RTS/CTS =" + String.valueOf(com.fazecast.jSerialComm.SerialPort.FLOW_CONTROL_CTS_ENABLED ));
		System.out.println("RTS/CTS =" + String.valueOf(com.fazecast.jSerialComm.SerialPort.FLOW_CONTROL_CTS_ENABLED | com.fazecast.jSerialComm.SerialPort.FLOW_CONTROL_RTS_ENABLED));
		System.out.println("Xon =" + String.valueOf(com.fazecast.jSerialComm.SerialPort.FLOW_CONTROL_XONXOFF_IN_ENABLED));
		System.out.println("Xoff =" + String.valueOf(com.fazecast.jSerialComm.SerialPort.FLOW_CONTROL_XONXOFF_OUT_ENABLED));
		System.out.println("Xon/Xoff =" + String.valueOf(com.fazecast.jSerialComm.SerialPort.FLOW_CONTROL_XONXOFF_IN_ENABLED | com.fazecast.jSerialComm.SerialPort.FLOW_CONTROL_XONXOFF_OUT_ENABLED));
		
		System.out.println();
		System.out.println();
		
		
		SerialPort[] ports = SerialPort.getCommPorts();
		for (SerialPort port: ports)
		    System.out.println(port.getSystemPortName() + "-" + port.getDescriptivePortName());

	}

}
