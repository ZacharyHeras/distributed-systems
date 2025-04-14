import java.io.*;
import java.math.*;
import java.net.*;

class ServiceProxy implements Service {
    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int SERVER_PORT = 10000;

    public BigInteger (BigInteger[] bigIntArray) {
        // we need executor class here
    }

	public BigInteger[] factor(BigInteger bigInt) {
        Socket socket  = null;
        BigInteger[] factors = null;

		try {
			socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
		} catch (UnknownHostException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);	
		}

		try {
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			output.writeUTF("factor");
			output.writeUTF(bigInt.toString());

			DataInputStream input = new DataInputStream(socket.getInputStream());

            String serializedFactors = input.readUTF();

            String[] factorsArray = serializedFactors.split(",");
            factors = new BigInteger[factorsArray.length];

            for (int i = 0; i < factorsArray.length; i++) {
                factors[i] = new BigInteger(factorsArray[i]);
            }

            socket.close();
			
		} catch (IOException e) {
			System.out.println(e);
		}

        return factors;
	}

	public boolean isPrime(BigInteger bigInt) {
        Socket socket = null;
        boolean isPrime = false;

		try {
			socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
		} catch (UnknownHostException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);	
		}

		try {
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			output.writeUTF("isPrime");
			output.writeUTF(bigInt.toString());

			DataInputStream input = new DataInputStream(socket.getInputStream());
            isPrime = Boolean.parseBoolean(input.readUTF());
            socket.close();

		} catch (IOException e) {
			System.out.println(e);
		}
        
        return isPrime;

    }
}
