import java.net.*;
import java.math.*;
import java.io.*;

class Server {
	public static void main(String[] args) {
        FactorizerServiceImpl factorizerServiceImpl = new FactorizerServiceImpl();

        boolean again = true;

        while (again) {
            try {
                ServerSocket serverSocket = new ServerSocket(10000);
                Socket socket = serverSocket.accept();

                DataInputStream input = new DataInputStream(socket.getInputStream());
                String method = input.readUTF();
                BigInteger bigInt = new BigInteger(input.readUTF());

                ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());

                if (method.equals("getIntArray")) {
                    Integer[] factors = factorizerServiceImpl.getArray(bigInt);
                    output.writeUTF(stringBuilder.toString());
                } else if (method.equals("getBigInteger")) {
                    BigInteger bigInt = factorizerServiceImpl.getBigInteger(bigInt);
                    output.writeUTF(String.valueOf(isPrime));
                } else if (method.equals("factor")) {
                    BigIntger[] factors = factorizerServiceImpl.factor(bigInt);
                    output.writeUTF(String.valueOf(isPrime));
                } else if (method.equals("factorArrayList")) {
                    BigInteger[] factors = factorizerServiceImpl.factorArrayList(bigInt);
                    output.writeUTF(String.valueOf(isPrime));
                }

                serverSocket.close();
                socket.close();

            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}
