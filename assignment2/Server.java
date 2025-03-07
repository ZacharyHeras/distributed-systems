import java.net.*;
import java.math.*;
import java.io.*;

class Server {

	public static void main(String[] args) {
	
		ServerSocket serverSocket = null;
		Socket socket = null;

		try {
			serverSocket = new ServerSocket(10000);
			socket = serverSocket.accept();

			DataInputStream input = new DataInputStream(socket.getInputStream());

			String option = input.readUTF();

			BigInteger bigInt = new BigInteger(input.readUTF());

			DataOutputStream output = new DataOutputStream(socket.getOutputStream());

			switch(option) {
				case "0":
					output.writeUTF(factor(bigInt).toString());
					break;
				case "1":
					factor(bigInt).length() > 2 ? output.writeUTF("Is not prime.") : output.writeUTF("Is prime.");
					break;
				default:
					break;

			}

			serverSocket.close();
			socket.close();

		} catch (IOException e) {
			System.out.println(e);
		}

	}

	public static BigInteger[] factor(BigInteger bigInt) {
		ArrayList<BigInteger> factors = new ArrayList<BigInteger>();
		for(int i = 1; i < bigInt.intValue(); i++) {
			if (bigInt.intValue() % i == 0)
				factors.add(new BigInteger(i.toString())); }

		return factors.toArray();
	}

}
