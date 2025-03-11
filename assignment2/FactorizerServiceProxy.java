import java.io.*;
import java.math.*;
import java.net.*;

class FactorizerServiceProxy {

    public FactorizerServiceProxy(String address, int port) {
        this.address = address;
        this.port = port;
    }

	public static String factor(String num) {

		try {
			Socket socket = new Socket("127.0.0.1", 10000);
		} catch (UnknownHostException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);	
		}

		try {
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			output.writeUTF(new Integer(option).toString());
			output.writeUTF(num);

			DataInputStream input = new DataInputStream(socket.getInputStream());
			socket.close();

			return input.readUTF();
			
		} catch (IOException e) {
			System.out.println(e);
		}

		return null;

	}

}
