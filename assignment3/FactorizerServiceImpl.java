import java.math.*;
import java.util.*;

public class FactorizerServiceImpl implements FactorizerService {

    public int[] getIntArray() {
        return new int[]{1, 2, 3};
    }

    public BigInteger getBigInteger() {
        return BigInteger.ONE;
    }

    public BigInteger[] factor(BigInteger bigInt) {
        ArrayList<BigInteger> factors = new ArrayList<BigInteger>();
        for(int i = 1; i <= bigInt.intValue(); i++) {
            if (bigInt.intValue() % i == 0) {
                System.out.println(i);
                factors.add(new BigInteger(String.valueOf(i)));
            }
        }

        return factors.toArray(new BigInteger[factors.size()-1]);
    }

    public ArrayList<BigInteger> factorArrayList(BigInteger bigInt) {
        ArrayList<BigInteger> factors = new ArrayList<BigInteger>();
        for(int i = 1; i <= bigInt.intValue(); i++) {
            if (bigInt.intValue() % i == 0) {
                factors.add(new BigInteger(String.valueOf(i)));
            }
        }

        return factors;
    }
}
