import java.io.*;
import java.math.BigInteger;
import java.net.*;
import java.util.*;


public class SortRunnable extends ServerRunnable implements Runnable {
    public SortRunnable(ObjectOutputStream outputStream, ObjectInputStream inputStream) {
        super(outputStream, inputStream);
    }

    public void run() {
        try {
            outputStream.writeObject(Arrays.stream(this.array)
                                           .sorted()
                                           .toArray(BigInteger[]::new));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
