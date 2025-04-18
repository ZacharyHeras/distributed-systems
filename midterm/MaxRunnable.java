import java.io.*;
import java.math.BigInteger;
import java.net.*;
import java.util.*;

public class MaxRunnable extends ServerRunnable implements Runnable {
    public MaxRunnable(ObjectOutputStream outputStream, ObjectInputStream inputStream) {
        super(outputStream, inputStream);
    }

    public void run() {
        try {
            BigInteger result = Arrays.stream(this.array)
                                      .reduce(this.array[0], BigInteger::max);

            outputStream.writeObject(new BigInteger[]{result});
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
