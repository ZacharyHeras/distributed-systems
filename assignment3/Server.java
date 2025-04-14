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
                Socket socket = serverSocket.accept();

                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                String method = (String) input.readObject();
                ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());

                if (method.equals("getIntArray")) {
                    int[] factors = factorizerServiceImpl.getIntArray();
                    output.writeObject(factors);
                } else if (method.equals("getBigInteger")) {
                    BigInteger bigInt = factorizerServiceImpl.getBigInteger();
                    output.writeObject(bigInt);
                } else if (method.equals("factor")) {

                    System.out.println("hello5");
                    BigInteger bigInt = new BigInteger((String) input.readObject());
                    System.out.println("hello6");
                    System.out.println(String.valueOf(bigInt));
                    BigInteger[] factors = factorizerServiceImpl.factor(bigInt);
                    System.out.println("hi5");
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
                } catch (ClassNotFoundException e) {
                    System.out.println(e);
                }
        }
    }
}
