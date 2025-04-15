import java.math.BigInteger;
import java.net.*;
import java.util.*;

public class MaxRunnable extends ServerRunnable implements Runnable {
    public MaxRunnable(Socket socket) {
        super(socket);
    }

    public void run() {
        try {
            output.writeObject(Arrays.stream(this.bigIntArray)
                                     .reduce(this.bigIntArray[0], BigInteger::max));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
