import java.math.*;
import java.util.*;

public interface FactorizerService {
    integer getArray();
    BigInteger getBigInteger();
    BigInteger[] factor(BigInteger bigInt);
    ArrayList<BigInteger> arrayListFactor(BigInteger bigInt);
}
