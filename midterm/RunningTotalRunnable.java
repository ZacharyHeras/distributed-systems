
import java.math.BigInteger;
import java.net.*;
import java.util.*;

public class RunningTotalRunnable extends ServerRunnable implements Runnable {
    
    public RunningTotalRunnable(Socket socket) {
        super(socket);
    }

    public void run() {
        try {
            output.writeObject(Arrays.stream(this.bigIntArray)
                                     .reduce(BigInteger.ZERO, BigInteger::add));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
