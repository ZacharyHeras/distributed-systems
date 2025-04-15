import java.net.*;
import java.math.*;
import java.io.*;
import java.util.concurrent.*;
import java.util.*;

class Server {
	public static void main(String[] args) {
        int num_threads = 12;
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(10000);
            socket = serverSocket.accept();
        } catch (Exception e) {
            System.out.println(e);
        }

        Executor exec = Executors.newFixedThreadPool(num_threads);
        while (true) {
            exec.execute(request(socket));
        }
    }

    public static ServerRunnable request(Socket socket) {
        HashMap<String, ServerRunnable> runnables = new HashMap<>();
        runnables.put("CalculateAverage", new CalculateAverageRunnable(socket));
        runnables.put("CalculateVarianceRunnable", new CalculateVarianceRunnable(socket));
        runnables.put("MaxRunnable", new MaxRunnable(socket));
        runnables.put("RunningTotalRunnable", new RunningTotalRunnable(socket));
        runnables.put("SortRunnable", new SortRunnable(socket));

        String method = null;

        try {
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

            BigInteger[] modelRow = (BigInteger[]) input.readObject();
            BigInteger result = BigInteger.ZERO;

            method = (String) input.readObject();

        } catch (Exception e) {
            System.out.println(e);
        }

        return runnables.get(method);
    }
}
