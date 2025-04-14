package midterm;

import java.net.*;
import java.math.*;
import java.io.*;
import java.util.*;

class Server {
    private int num_threads = 12;
    private ServerSocket serverSocket;
    private Socket socket;

    public Server() {
        try {
            serverSocket = new ServerSocket(10000);
            socket = serverSocket.accept();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

	public static void main(String[] args) {
        Executor exec = Executors.newFixedThreadPool();
        while (true) {
            exec.execute(request());
        }
    }

    public ServerRunnable request() {
        HashMap<String, Runnable> runnables = new HashMap<>();
        runnables.put("calculateAverage", new calculateAverageRunnable(socket));
        runnables.put("calculateVarianceRunnable", new calculateVarianceRunnable(socket));
        runnables.put("maxRunnable", new maxRunnable(socket));
        runnables.put("runningTotalRunnable", new runningTotalRunnable(socket));
        runnables.put("sortRunnable", new sortRunnable(socket));

        try {
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

            BigInteger[] modelRow = (BigInteger[]) input.readObject();
            BigInteger result = BigInteger.ZERO;

            String method = (String) input.readObject();

        } catch (Exception e) {
            System.out.println(e);
        }

        return runnables.get(method);
    }
}
