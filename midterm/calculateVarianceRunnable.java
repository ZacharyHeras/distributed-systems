
import java.math.BigInteger;
import java.util.*;

public class SortRunnable extends ServerRunnable implements Runnable {
    public SortRunnable(Socket socket) {
        super(socket)
    }

    public void run() {
        BigInteger bigIntAverage = Arrays.stream(this.bigIntArray)
                                         .reduce(BigInteger.ZERO, BigInteger::add)
                                         .divide(BigInteger.valueOf(this.bigIntArray.length));

        bigInt = Arrays.stream(this.bigIntArray)
                       .map(i -> i.subtract(bigIntAverage))
                       .map(i -> i.pow(2))
                       .reduce(BigInteger.ZERO, BigInteger::add)
                       .divide(BigInteger.valueOf(this.bigIntArray.length));
    }
}
