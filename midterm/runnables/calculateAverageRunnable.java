import java.math.BigInteger;
import java.util.*;
import java.net.*;
import java.io.*;

public class calculateAverageRunnable extends ServerRunnable implements Runnable { 
    public calculateAverageRunnable(Socket socket) {
        super(socket);
    }

    public void run() {
        try {
            output.writeObject(Arrays.stream(this.bigIntArray)
                                     .reduce(BigInteger.ZERO, BigInteger::add)
                                     .divide(BigInteger.valueOf(this.bigIntArray.length)));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
