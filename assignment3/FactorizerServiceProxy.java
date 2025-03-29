import java.io.*;
import java.math.*;
import java.net.*;
import java.util.*;

class FactorizerServiceProxy implements FactorizerService {
    private static final String SERVER_ADDRESS = "128.0.0.2";
    private static final int SERVER_PORT = 10000;

    public int[] getArray() {
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
            output.writeUTF("getIntArray");

            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

            Object object = input.readObject();
            int[] array;

            if (object instanceof int[]) {
                array = (int[])object;
            }

            socket.close();

        } catch (IOException e) {
            System.out.println(e);
        }

            return array;

    }

    public int[] getBigInteger() {
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
            output.writeUTF("getBigInteger");

            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

            Object object = input.readObject();
            BigInteger bigInteger;

            if (object instanceof BigInteger) {
                bigInteger = (BigInteger)object;
            }

            socket.close();

        } catch (IOException e) {
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
            BigInteger[] factors;

            if (object instanceof BigInteger[]) {
                factors = (BigInteger[])object;
            }


            socket.close();

        } catch (IOException e) {
            System.out.println(e);
        }

            return factors;
    }

    public ArrayList<BigInteger> arrayListFactor(BigInteger bigInt) {
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
            output.writeUTF("arrayListFactor");

            output.writeObject(bigInt);

            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

            Object object = input.readObject();
            ArrayList<BigInteger> factors;

            if (object instanceof ArrayList<BigInteger>) {
                factors = (ArrayList<BigInteger>)object;
            }


            socket.close();

        } catch (IOException e) {
            System.out.println(e);
        }

            return factors;
    }
}
