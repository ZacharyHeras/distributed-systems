import java.io.*;
import java.math.BigInteger;
import java.net.*;
import java.util.*;

public class VarianceRunnable extends ServerRunnable implements Runnable {
    public VarianceRunnable(ObjectOutputStream outputStream, ObjectInputStream inputStream) {
        super(outputStream, inputStream);
    }

    public void run() {
        try {
            BigInteger average  = Arrays.stream(this.array)
                                             .reduce(BigInteger.ZERO, BigInteger::add)
                                             .divide(BigInteger.valueOf(this.array.length));

            BigInteger variance = Arrays.stream(this.array)
                                        .map(i -> i.subtract(average))
                                        .map(i -> i.pow(2))
                                        .reduce(BigInteger.ZERO, BigInteger::add)
                                        .divide(BigInteger.valueOf(this.array.length));

            outputStream.writeObject(new BigInteger[]{variance});
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
