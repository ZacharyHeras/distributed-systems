import java.math.*;
import java.util.*;

public interface FactorizerService {
    int[] getIntArray();
    BigInteger getBigInteger();
    BigInteger[] factor(BigInteger bigInt);
    ArrayList<BigInteger> factorArrayList(BigInteger bigInt);
}
