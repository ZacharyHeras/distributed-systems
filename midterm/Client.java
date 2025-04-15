import java.io.*;
import java.math.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

class Client {
	public static void main(String[] args) {
        ServiceProxy factorService = new ServiceProxy();
		Scanner scanner = new Scanner(System.in);

		boolean again = true;

		while (again) {
            System.out.println("Select an option:");
			System.out.println("0. Calculate 1D array average.");
			System.out.println("1. Calculate average of 1D array averages.");
			System.out.println("2. Calulate overall 2D array average.");
			System.out.println("3. Find overall largest element.");
			System.out.println("5. Sort each 1D array.");
			System.out.println("6. Calculate average of 1D array variances.");

			int option = scanner.nextInt();
            scanner.nextLine();

            // write 2d array for sending
            // public ClientRunnable(Socket socket, BigInteger[] row, String method, Object result) {

            int num_threads = 3;
            Executor exec = Executors.newFixedThreadPool(num_threads);
            while (true) {
                exec.execute(new ClientRunnable());
            }

			if (option == 0) {
                exec.execute(new ClientRunnable());
			} else if (option == 1) {
                Object[] result = new Object()[row.length]; // fix
                for (int i = 0; i < model.length; i++) {
                    exec.execute(new ClientRunnable(socket, model[i], "runnable_name", o));
                }
			} else if (option == 2) {
            }
		}

		scanner.close();
	}
}
