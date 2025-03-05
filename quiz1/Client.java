import java.net.*;
import java.io.*;

class Client {

	public static void main(String[] args) {
	
		Socket socket = null;

		try {
			socket = new Socket("127.0.0.1", 10000);
		} catch (UnknownHostException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);	
		}

		try {
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			output.writeUTF("Hello World!");
			socket.close();
		} catch (IOException e) {
			System.out.println(e);
		}


	}
}
