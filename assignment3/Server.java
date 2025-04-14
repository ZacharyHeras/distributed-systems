import java.io.*;
import java.math.*;
import java.net.*;
import java.util.*;

class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        ObjectInputStream input = null;
        ObjectOutputStream output = null;

        try {
            serverSocket = new ServerSocket(10000);
            socket = serverSocket.accept();
            input = new ObjectInputStream(socket.getInputStream());
            output = new ObjectOutputStream(socket.getOutputStream());
        } catch (Exception e) {
            System.out.println("In Server.java...");
            System.out.println(e);
        }

        FactorizerServiceImpl factorizerServiceImpl = new FactorizerServiceImpl();
        boolean again = true;

        while (again) {
            try {

                String method = (String) input.readObject();

                switch (method) {
                    case "getIntArray": {
                       int[] factors = factorizerServiceImpl.getIntArray();
                       output.writeObject(factors.length);
                       output.flush();
                       output.writeObject(factors);
                       output.flush();
                       break;
                    }
                    case "getBigInteger": {
                       BigInteger bigInt = factorizerServiceImpl.getBigInteger();
                       output.writeObject(bigInt);
                       output.flush();
                       break;
                    }
                    case "factor": {
                       BigInteger bigInt = (BigInteger) input.readObject();
                       BigInteger[] factors = factorizerServiceImpl.factor(bigInt);
                       output.writeObject(factors);
                       output.flush();
                       break;
                    }
                    case "factorArrayList": {
                       BigInteger bigInt = (BigInteger) input.readObject();
                       ArrayList<BigInteger> factors = factorizerServiceImpl.factorArrayList(bigInt);
                       output.writeObject(factors);
                       output.flush();
                       break;
                    }
                }
            } catch (Exception e) {
                System.out.println("In Server.java...");
                System.out.println(e);
            }
        }

        try {
            serverSocket.close();
            socket.close();
        } catch (Exception e) {
            System.out.println("In Server.java...");
            System.out.println(e);
        }
    }
}
