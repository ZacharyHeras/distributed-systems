import java.net.*;
import java.math.*;
import java.io.*;
import java.util.concurrent.*;
import java.util.*;

class Server {
	public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(10000);
        } catch (Exception e) {
            System.out.println("In Server.java...");
            System.out.println(e);
        }

        int num_threads = 3;
        Executor exec = Executors.newFixedThreadPool(num_threads);

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                exec.execute(request(outputStream, inputStream));
            } catch (Exception e) {
                System.out.println("In Server.java...");
                System.out.println(e);
            }
        }
    }

    public static ServerRunnable request(ObjectOutputStream outputStream, ObjectInputStream inputStream) {
        String method = null;
        try {
            method = (String) inputStream.readObject();
        } catch (Exception e) {
            System.out.println("In Server.java...");
            System.out.println(e);
        }

        switch (method) {
            case "AverageRunnable":
                return new AverageRunnable(outputStream, inputStream);
            case "SumRunnable":
                return new SumRunnable(outputStream, inputStream);
            case "MaxRunnable":
                return new MaxRunnable(outputStream, inputStream);
            case "SortRunnable":
                return new SortRunnable(outputStream, inputStream);
            case "VarianceRunnable":
                return new VarianceRunnable(outputStream, inputStream);
            default:
                return null;
        }
    }
}
