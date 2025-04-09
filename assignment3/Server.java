import java.net.*;
import java.math.*;
import java.io.*;
import java.util.*;

class Server {
    public static void main(String[] args) {
        FactorizerServiceImpl factorizerServiceImpl = new FactorizerServiceImpl();

        boolean again = true;

        while (again) {
            try {
                ServerSocket serverSocket = new ServerSocket(10000);
                System.out.println("hello");
                Socket socket = serverSocket.accept();
                System.out.println("here");

                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                String method = input.readUTF();
                
                System.out.println(input);

                ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());

                if (method.equals("getIntArray")) {
                    System.out.println("hello1");
                    int[] factors = factorizerServiceImpl.getIntArray();
                    System.out.println("hello2");
                    output.writeObject(factors);
                } else if (method.equals("getBigInteger")) {
                    BigInteger bigInt = factorizerServiceImpl.getBigInteger();
                    output.writeObject(String.valueOf(bigInt));
                } else if (method.equals("factor")) {
                    BigInteger bigInt = new BigInteger(input.readUTF());
                    BigInteger[] factors = factorizerServiceImpl.factor(bigInt);
                    output.writeObject(String.valueOf(factors));
                } else if (method.equals("factorArrayList")) {
                    BigInteger bigInt = new BigInteger(input.readUTF());
                    ArrayList<BigInteger> factors = factorizerServiceImpl.factorArrayList(bigInt);
                    output.writeObject(String.valueOf(factors));
                }

                System.out.println("satoneuhsn");
                    
                serverSocket.close();
                socket.close();

                } catch (IOException e) {
                    System.out.println(e);
                    System.out.println("e activated");
                }
        }
    }
}
