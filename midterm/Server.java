import java.net.*;
import java.math.*;
import java.io.*;

class Server {
	public static void main(String[] args) {
        ServiceImpl factorizerServiceImpl = new ServiceImpl();

        boolean again = true;

        while (again) {
            try {
                ServerSocket serverSocket = new ServerSocket(10000);
                Socket socket = serverSocket.accept();

                DataInputStream input = new DataInputStream(socket.getInputStream());
                String method = input.readUTF();
                BigInteger bigInt = new BigInteger(input.readUTF());

                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                if (method.equals("factor")) {
                    BigInteger[] factors = factorizerServiceImpl.factor(bigInt);
                    StringBuilder stringBuilder = new StringBuilder();

                    for (BigInteger factor : factors) {
                        stringBuilder.append(factor.toString());
                        stringBuilder.append(",");
                    }

                    output.writeUTF(stringBuilder.toString());

                } else if (method.equals("isPrime")) {
                    boolean isPrime = factorizerServiceImpl.isPrime(bigInt);
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
