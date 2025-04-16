import java.math.BigInteger;
import java.util.*;
import java.net.*;
import java.io.*;

public abstract class ServerRunnable implements Runnable { 
    protected BigInteger[] array;
    protected ObjectOutputStream outputStream;
    protected ObjectInputStream inputStream;
    
    public ServerRunnable(ObjectOutputStream outputStream, ObjectInputStream inputStream) {
        this.outputStream = outputStream;
        this.inputStream = inputStream;

		try {
            array = (BigInteger[]) inputStream.readObject();
		} catch (Exception e) {
			System.out.println(e);
		}
    }
}
