# SerialtoEthernet

The purpose of this project is to enhance the capabilities of serial driven automation storage system by allowing it to be controlled via a network. Modern computer retailers do not prioritise serial devices connectivity. Although, serial ports are still in use and more common in many industrial applications. Serial communication typically requires a wire, point to point cable connection, and it is limited by the length of the cable. To access a serial application on multiple devices will require separate RS232 cable and available ports. To overcome these factors a serial via network software will allow serial communication over LAN, this will share com ports over the network and connect to remote serial devices, in simple terms a protocol converter. Protocol Converter is a device used to convert standard or proprietary protocol of one device to the protocol suitable for the other device or tools to achieve the interoperability.


### TECHNICAL SPECIFICATION
In the process of developing a reliable and dynamic software, different technologies are used. These are as follows,

- Languages – Java-FX
- IDE – Eclipse • JSerialComm

The software “Serial via Network” is a desktop application, which is created by using JavaFX which is a software platform for creating and delivering desktop applications. Eclipse is one of the finest backend and front-end builder available in the market with ease of use and make the application to give a look of its profession.

### USE-CASE DIAGRAM
<img align="left" src="https://raw.githubusercontent.com/christiankasongo/SerialtoEthernet/master/Screenshot%202022-04-23%20at%2010.38.46.png" height="350px">

To describe the model of a system’s dynamic behaviour is most important. Use case diagram consists of actors, use cases and relationships. The actors consist of internal and external agents. From the use case diagram, we can gather the system requirements. The factors which effect the internal and external features of the system can be obtained.

<br/>
<br/>
<hr>


### SET UP
<img align="center" src="https://raw.githubusercontent.com/christiankasongo/SerialtoEthernet/master/Screenshot%202022-04-23%20at%2010.43.56.png" height="400px">

Serial via Network software allows you to share COM ports over the network, from then the user can connect to remote serial devices as if it was connected directly to the user local computing or tablet device.
The application is split into 3 separate programs, where two of the programs are already installed onto the raspberry pi. For first time usage, the raspberry pi will need to a keyboard, mouse and a monitor. The Pi will be connected to the network using either Ethernet cable or WIFI connection. From then a USB to serial cable will be used to connect the serial devices to the raspberry pi, lastly the power cable to start up the raspberry pi.
When the Pi is turned on for the first time the server will time out as it will not be able to read any settings file. Therefore, it important to open the settings application and configure the settings to meet the requirements of the serial device you wish to communicate with.
Using any operating system, the user can install the client application, once everything is set the user can then start to remote serial devices from their chosen computing or tablet device.

 
