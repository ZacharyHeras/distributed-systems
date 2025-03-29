import java.math.*;
import java.util.*;

public class FactorizerServiceImpl implements FactorizerService {

	public BigInteger[] getIntArray(BigInteger bigInt) {
        return new int[]{1, 2, 3}
	}

	public BigInteger[] getBigInt(BigInteger bigInt) {
        return new BigInteger[]{new BigInteger("1"), new BigInteger("2"), new BigInteger("3")}
	}

	public BigInteger[] factor(BigInteger bigInt) {
		ArrayList<BigInteger> factors = new ArrayList<BigInteger>();
		for(int i = 1; i <= bigInt.intValue(); i++) {
			if (bigInt.intValue() % i == 0)
				factors.add(new BigInteger(String.valueOf(i))); }

		return factors.toArray(new BigInteger[factors.size()-1]);
	}

	public BigInteger[] arrayListFactor(BigInteger bigInt) {
		ArrayList<BigInteger> factors = new ArrayList<BigInteger>();
		for(int i = 1; i <= bigInt.intValue(); i++) {
			if (bigInt.intValue() % i == 0)
				factors.add(new BigInteger(String.valueOf(i))); }

		return factors;
	}
}
