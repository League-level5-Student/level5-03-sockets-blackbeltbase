package _01_Intro_To_Sockets.client;

import java.net.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import _00_Click_Chat.networking.Client;
import _00_Click_Chat.networking.Server;

import java.io.*;

public class ClientGreeter {
	static Server server;
	Client client;
	static String address;
	public void start() {
		 server = new Server(8080);
		  address = server.getIPAddress();
	}
   public static void main(String [] args) {
	  //1. Create a String for the ip address of the server. 
	  // If you don't know how to find a computer's ip address, ask about ifconfig on linux/mac and ipconfig on windows.

      //2. Create an integer for the server's port number
      int portNum = 8080;
      //3. Surround steps 4-9 in a try-catch block that catches any IOExceptions.
    try {
		Socket sock = new Socket(address,portNum);
		DataOutputStream outStream = new DataOutputStream(sock.getOutputStream());
		outStream.writeUTF("hello client");
		DataInputStream inStream = new DataInputStream(sock.getInputStream());
		System.out.println(inStream.readUTF());
		JOptionPane.showMessageDialog(null, "Server started at: " + server.getIPAddress() + "\nPort: " + server.getPort());
		server.start();
		sock.close();
		
	} catch (Exception e) {
		// TODO: handle exception
	}
    	 //4. Create an object of the Socket class. When initializing the object, pass in the ip address and the port number
 
         //5. Create a DataOutputStream object. When initializing it, use the Socket object you created in step 4 to call the getOutputStream() method.
         
         //6. Use the DataOutputStream object to send a message to the server using the writeUTF(String message) method
         
         //7. Create a DataInputStream object. When initializing it, use the Server object you created in step 4 to call the getInputStream() method.
         
         //8. Use the DataInputStream object to print a message from the server using the readUTF() method.
         
         //9. Close the client's server object

   }
}
