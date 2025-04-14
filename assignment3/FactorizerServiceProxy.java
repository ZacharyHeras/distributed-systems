import java.io.*;
import java.math.*;
import java.net.*;
import java.util.*;

@SuppressWarnings("unchecked")
public class FactorizerServiceProxy implements FactorizerService {
    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int SERVER_PORT = 10000;
    private Socket socket;
    private ObjectOutputStream output;
    private ObjectInputStream input;

    public FactorizerServiceProxy() {
        try {
            socket = new Socket();
            socket.connect(new InetSocketAddress(SERVER_ADDRESS, SERVER_PORT));
            this.output = new ObjectOutputStream(this.socket.getOutputStream());
            this.input = new ObjectInputStream(this.socket.getInputStream());
        } catch (Exception e) {
            System.out.println("In FactorizerServiceProxy.java...");
            System.out.println(e);
        }
    }

    public int[] getIntArray() {
        int[] intArray = null;

        try {
            this.output.writeObject("getIntArray");
            this.output.flush();

            // simulating contract
            Integer intArraySize = (Integer) this.input.readObject();

            Object object = this.input.readObject();
            intArray = (int[]) object;

            // simulating contract
            if (intArray.length != intArraySize) {
                throw new IllegalStateException("State error.");
            }

        } catch (Exception e) {
            System.out.println("In FactorizerServiceProxy.java...");
            System.out.println(e);
        }

        return intArray;
    }

    public BigInteger getBigInteger() {
        BigInteger bigInteger = null;

        try {
            this.output.writeObject("getBigInteger");
            this.output.flush();

            Object object = this.input.readObject();
            bigInteger = (BigInteger) object;

        } catch (Exception e) {
            System.out.println("In FactorizerServiceProxy.java...");
            System.out.println(e);
        }

            return bigInteger;
    }

    public BigInteger[] factor(BigInteger bigInt) {
        BigInteger[] factors = null;

        try {
            this.output.writeObject("factor");
            this.output.flush();
            this.output.writeObject(bigInt);
            this.output.flush();

            Object object = this.input.readObject();
            factors = (BigInteger[]) object;

        } catch (Exception e) {
            System.out.println("In FactorizerServiceProxy.java...");
            System.out.println(e);
        }

            return factors;
    }

    public ArrayList<BigInteger> factorArrayList(BigInteger bigInt) {
        ArrayList<BigInteger> factors = null;

        try {
            this.output.writeObject("factorArrayList");
            this.output.flush();
            this.output.writeObject(bigInt);
            this.output.flush();

            Object object = this.input.readObject();
            factors = (ArrayList<BigInteger>) object;

        } catch (Exception e) {
            System.out.println("In FactorizerServiceProxy.java...");
            System.out.println(e);
        }

            return factors;
    }

    public void close() {
        try {
            this.socket.close();
            this.output.close();
            this.input.close();
        } catch (Exception e) {
            System.out.println("In FactorizerServiceProxy.java...");
            System.out.println(e);
        }
    }
}
