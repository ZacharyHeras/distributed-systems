import java.io.*;
import java.math.BigInteger;
import java.net.*;
import java.util.*;

public class SumRunnable extends ServerRunnable implements Runnable {
    
    public SumRunnable(ObjectOutputStream outputStream, ObjectInputStream inputStream) {
        super(outputStream, inputStream);
    }

    public void run() {
        try {
            BigInteger result = Arrays.stream(this.array)
                                          .reduce(BigInteger.ZERO, BigInteger::add);

            outputStream.writeObject(new BigInteger[]{result});
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
