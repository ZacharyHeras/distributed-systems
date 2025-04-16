import java.io.*;
import java.math.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class ClientRunnable implements Runnable {
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;
    private BigInteger[] row;
    private String method;
    private BigInteger[][] result;
    private CountDownLatch latch;
    private int index;

    public ClientRunnable(ObjectOutputStream outputStream,
            ObjectInputStream inputStream,
            BigInteger[] row,
            String method,
            BigInteger[][] result,
            CountDownLatch latch,
            int index) {
        this.outputStream = outputStream;
        this.inputStream = inputStream;
        this.row = row;
        this.method = method;
        this.result = result;
        this.latch = latch;
        this.index = index;
    }

    public void run() {
        try{
            outputStream.writeObject(method);
            outputStream.writeObject(row);
            result[index] = (BigInteger[]) inputStream.readObject();
        } catch (Exception e){
            System.out.println("In ClientRunnable.java...");
            System.out.println(e);
        }

        this.latch.countDown();
    }
}
