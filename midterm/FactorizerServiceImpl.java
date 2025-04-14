
import java.math.*;
import java.util.*;

public class ServiceImpl implements Service {

	public BigInteger[] factor(BigInteger bigInt) {
		ArrayList<BigInteger> factors = new ArrayList<BigInteger>();
		for(int i = 1; i <= bigInt.intValue(); i++) {
			if (bigInt.intValue() % i == 0)
				factors.add(new BigInteger(String.valueOf(i))); }

		return factors.toArray(new BigInteger[factors.size()-1]);
	}

    public boolean isPrime(BigInteger bigInt) {
        return factor(bigInt).length < 3;
    }

}
