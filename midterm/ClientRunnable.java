import java.io.*;
import java.math.*;
import java.net.*;
import java.util.*;

@SuppressWarnings("unchecked")
public class ClientRunnable implements Runnable {
    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int SERVER_PORT = 10000;
    private Socket socket;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private BigInteger[] row;
    private String method;
    private Object result;

    public ClientRunnable(Socket socket, BigInteger[] row, String method, Object result) {
        this.row = row;
        this.method = method;
        this.result = result;
        try {
            socket.connect(new InetSocketAddress(SERVER_ADDRESS, SERVER_PORT));
            this.output = new ObjectOutputStream(this.socket.getOutputStream());
            this.input = new ObjectInputStream(this.socket.getInputStream());
        } catch (Exception e) {
            System.out.println("In FactorizerServiceProxy.java...");
            System.out.println(e);
        }
    }

    public void run() {
        try{
            output.writeObject(row);
            output.writeObject(method);
            result = input.readObject();
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
