import java.math.BigInteger;
import java.util.*;

public class SortRunnable implements Runnable {
    private BigInteger[] bigIntArray;
    private BigInteger bigInt;
    
    public SortRunnable(BigInteger[] bigIntArray, BigInteger bigInt) {
        this.bigIntArray = bigIntArray;
        this.bigInt = bigInt;
    }

    public void run() {
        BigInteger bigIntAverage = Arrays.stream(this.bigIntArray)
                                         .reduce(BigInteger.ZERO, BigInteger::add)
                                         .divide(BigInteger.valueOf(this.bigIntArray.length));

        bigInt = Arrays.stream(this.bigIntArray)
                       .map(i -> i.subtract(bigIntAverage))
                       .map(i.pow(2))
                       .reduce(BigInteger.ZERO, BigInteger::add)
                       .divide(BigInteger.valueOf(this.bigIntArray.length));
    }
}
