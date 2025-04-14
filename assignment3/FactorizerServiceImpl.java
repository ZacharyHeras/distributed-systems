import java.math.*;
import java.util.*;

public class FactorizerServiceImpl implements FactorizerService {

    public int[] getIntArray() {
        return new int[]{1, 2, 3};
    }

    public BigInteger getBigInteger() {
        return new BigInteger("1");
    }

    public BigInteger[] factor(BigInteger bigInt) {
        ArrayList<BigInteger> factors = new ArrayList<BigInteger>();
        for (int j = 1; j < 4000000; j++)
            System.out.println("oh okay");

        for(int i = 1; i <= bigInt.intValue(); i++) {
            if (bigInt.intValue() % i == 0)
                factors.add(new BigInteger(String.valueOf(i))); }

        System.out.println("oh okay");

        return factors.toArray(new BigInteger[factors.size()-1]);
    }

    public ArrayList<BigInteger> factorArrayList(BigInteger bigInt) {
        ArrayList<BigInteger> factors = new ArrayList<BigInteger>();
        for(int i = 1; i <= bigInt.intValue(); i++) {
            if (bigInt.intValue() % i == 0)
                factors.add(new BigInteger(String.valueOf(i))); }

        return factors;
    }
}
