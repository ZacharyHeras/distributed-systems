import java.math.BigInteger;
import java.util.*;
import java.net.*;
import java.io.*;

public class AverageRunnable extends ServerRunnable implements Runnable { 
    public AverageRunnable(ObjectOutputStream outputStream, ObjectInputStream inputStream) {
        super(outputStream, inputStream);
    }

    public void run() {
        try {
            BigInteger result = Arrays.stream(this.array)
                                          .reduce(BigInteger.ZERO, BigInteger::add)
                                          .divide(BigInteger.valueOf(this.array.length));

            outputStream.writeObject(new BigInteger[]{result});

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
