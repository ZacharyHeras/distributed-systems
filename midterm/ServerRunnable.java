
import java.math.BigInteger;
import java.util.*;
import java.net.*;
import java.io.*;

public abstract class ServerRunnable implements Runnable { 
    protected BigInteger[] bigIntArray;
    protected ObjectOutputStream output;
    
    public ServerRunnable(Socket socket) {
		try {
            output = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            bigIntArray = (BigInteger[]) input.readObject();
		} catch (Exception e) {
			System.out.println(e);
		}
    }
}
