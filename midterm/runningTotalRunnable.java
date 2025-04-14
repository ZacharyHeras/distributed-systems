
import java.math.BigInteger;
import java.util.*;

public class runningTotalRunnable implements Runnable {
    private BigInteger[] bigIntArray;
    private BigInteger bigInt;
    
    public runningTotalRunnable(BigInteger[] bigIntArray, BigInteger bigInt) {
        this.bigIntArray = bigIntArray;
        this.bigInt = bigInt;
    }

    public void run() {
        bigInt = Arrays.stream(this.bigIntArray)
                       .reduce(BigInteger.ZERO, BigInteger::add);
    }
}
