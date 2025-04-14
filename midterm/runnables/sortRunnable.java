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
        bigInt = Arrays.stream(this.bigIntArray)
                       .sorted();
    }
}
