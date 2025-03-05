import java.net.*;
import java.io.*;

class Server {

	public static void main(String[] args) {
	
		ServerSocket serverSocket = null;
		Socket socket = null;

		try {
			serverSocket = new ServerSocket(10000);
			socket = serverSocket.accept();

			DataInputStream input = new DataInputStream(socket.getInputStream());

			String string = input.readUTF();

			if(validate(string)) {
				System.out.println(string);
			} 

			serverSocket.close();
			socket.close();
		} catch (IOException e) {
			System.out.println(e);
		}

	}

	private static boolean validate(String string) {
		return string.contains("Hello World!");
	}
}
