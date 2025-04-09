import java.io.*;
import java.math.*;
import java.net.*;
import java.util.*;

class FactorizerServiceProxy implements FactorizerService {
    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int SERVER_PORT = 10000;

    public int[] getIntArray() {
        Socket socket  = null;
        int[] array = null;

        try {
            socket = new Socket();
            socket.connect(new InetSocketAddress(SERVER_ADDRESS, SERVER_PORT));
        } catch (UnknownHostException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("hello3");
            output.writeUTF("getIntArray");
            System.out.println("hello4");

            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

            Object object = input.readObject();

            System.out.println("hi");

            if (object instanceof int[])
                array = (int[])object;

            socket.close();

        } catch (IOException e) {
            System.out.println(e);

        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

            return array;
    }

    public BigInteger getBigInteger() {
        Socket socket  = null;
        BigInteger bigInteger = null;

        try {
            socket = new Socket();
            socket.connect(new InetSocketAddress(SERVER_ADDRESS, SERVER_PORT), 10);
        } catch (UnknownHostException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            output.writeUTF("getBigInteger");

            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

            Object object = input.readObject();

            if (object instanceof BigInteger)
                bigInteger = (BigInteger)object;

            socket.close();

        } catch (IOException e) {
            System.out.println(e);

        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

            return bigInteger;
    }

    public BigInteger[] factor(BigInteger bigInt) {
        Socket socket  = null;
        BigInteger[] factors = null;

        try {
            socket = new Socket();
            socket.connect(new InetSocketAddress(SERVER_ADDRESS, SERVER_PORT), 10);
        } catch (UnknownHostException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            output.writeUTF("factor");

            output.writeObject(bigInt);

            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

            Object object = input.readObject();

            if (object instanceof BigInteger[])
                factors = (BigInteger[])object;

            socket.close();

        } catch (IOException e) {
            System.out.println(e);

        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

            return factors;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<BigInteger> factorArrayList(BigInteger bigInt) {
        Socket socket  = null;
        ArrayList<BigInteger> factors = null;

        try {
            socket = new Socket();
            socket.connect(new InetSocketAddress(SERVER_ADDRESS, SERVER_PORT), 10);
        } catch (UnknownHostException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            output.writeUTF("factorArrayList");

            output.writeObject(bigInt);

            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

            Object object = input.readObject();

            factors = (ArrayList<BigInteger>)object;

            socket.close();

        } catch (IOException e) {
            System.out.println(e);

        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

            return factors;
    }
}
