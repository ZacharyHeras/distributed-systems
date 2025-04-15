import java.math.BigInteger;
import java.net.*;
import java.util.*;

public class CalculateVarianceRunnable extends ServerRunnable implements Runnable {
    public CalculateVarianceRunnable(Socket socket) {
        super(socket);
    }

    public void run() {
        BigInteger bigIntAverage = Arrays.stream(this.bigIntArray)
                                         .reduce(BigInteger.ZERO, BigInteger::add)
                                         .divide(BigInteger.valueOf(this.bigIntArray.length));

        try {
            output.writeObject(Arrays.stream(this.bigIntArray)
                                     .map(i -> i.subtract(bigIntAverage))
                                     .map(i -> i.pow(2))
                                     .reduce(BigInteger.ZERO, BigInteger::add)
                                     .divide(BigInteger.valueOf(this.bigIntArray.length)));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
