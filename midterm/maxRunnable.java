
import java.math.BigInteger;
import java.util.*;

public class maxRunnable implements Runnable {
    private BigInteger[] bigIntArray;
    private BigInteger bigInt;
    
    public maxRunnable(BigInteger[] bigIntArray, BigInteger bigInt) {
        this.bigIntArray = bigIntArray;
        this.bigInt = bigInt;
    }

    public void run() {
        bigInt = Arrays.stream(this.bigIntArray)
                       .reduce(this.bigIntArray[0], BigInteger::max);
    }
}
