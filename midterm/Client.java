import java.io.*;
import java.math.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

class Client {
	public static void main(String[] args) {
        String serverAddress = "127.0.0.1";
        int serverPort = 10000;

        int m = 10;
        int n = 15;
        BigInteger[][] rows = new BigInteger[m][n];
        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < rows[i].length; j++) {
                rows[rows.length-1-i][rows[i].length-1-j] = new BigInteger(String.valueOf((i+1)*(j+1)));
            }
        }

        HashMap<Integer, String> methods = new HashMap<>();
        methods.put(1, "AverageRunnable");
        methods.put(2, "AverageRunnable");
        methods.put(3, "SumRunnable");
        methods.put(4, "MaxRunnable");
        methods.put(5, "SortRunnable");
        methods.put(6, "VarianceRunnable");

        int num_threads = 3;
        Executor exec = Executors.newFixedThreadPool(num_threads);

        BigInteger[][] result = new BigInteger[m][n];

		Scanner scanner = new Scanner(System.in);

		boolean again = true;

        int option;
        String method;

		while (again) {
            option = getOption(scanner);

            if (option == 7) {
                for (BigInteger[] row : rows) {
                    System.out.println(Arrays.toString(row));
                }
            }

            if (option == 8) {
                again = false;
            }

            method = methods.get(option);
            result = getResult(rows, method, serverAddress, serverPort, exec);

            if (option == 1) {
                System.out.println(result[0][0]);

            } else if (option == 2) {
                BigInteger sum = BigInteger.ZERO;
                int count = 0;

                for (BigInteger[] row : result) {
                    for (BigInteger value : row) {
                        sum = sum.add(value);
                        count++;
                    }
                }

                System.out.println(sum.divide(BigInteger.valueOf(count)));

            } else if (option == 3) {
                BigInteger sum = BigInteger.ZERO;
                int count = 0;

                for (BigInteger[] row : result) {
                    for (BigInteger value : row) {
                        sum = sum.add(value);
                        count++;
                    }
                }

                System.out.println(sum.divide(BigInteger.valueOf(count)));

            } else if (option == 4) {
                BigInteger largest = result[0][0];
                int largestI = 0;
                int largestJ = 0;

                for (int i = 0; i < result.length; i++) {
                    for (int j = 0; j < result[i].length; j++) {
                        if (largest.intValue() < result[i][j].intValue()) {
                            largest = result[i][j];
                            largestI = i;
                            largestJ = j;
                        }
                    }
                }

                System.out.println("i coordinate: " + largestI);
                System.out.println("j coordinate: " + largestJ);

            } else if (option == 5) {
                for (BigInteger[] row : result) {
                    System.out.println(Arrays.toString(row));
                }

            } else if (option == 6) {
                BigInteger sum = BigInteger.ZERO;
                int count = 0;

                for (BigInteger[] row : result) {
                    for (BigInteger value : row) {
                        sum = sum.add(value);
                        count++;
                    }
                }

                System.out.println(sum.divide(BigInteger.valueOf(count)));
            }

            System.out.println("");
		}

		scanner.close();
	}

    public static int getOption(Scanner scanner) {
            System.out.println("Select an option:");
			System.out.println("1. 1D array average.");
			System.out.println("2. Average of 1D array averages.");
			System.out.println("3. Calulate overall 2D array average.");
			System.out.println("4. Find overall largest element.");
			System.out.println("5. Sort each 1D array.");
			System.out.println("6. Average of 1D array variances.");
			System.out.println("7. Show Original 2D array.");
			System.out.println("8. Quit.");
            System.out.println("");

            int option = scanner.nextInt();
            scanner.nextLine();

            System.out.println();

            return option;
    }

    public static BigInteger[][] getResult(BigInteger[][] rows,
                                    String method,
                                    String serverAddress,
                                    int serverPort,
                                    Executor exec) {
        BigInteger[][] result = new BigInteger[rows.length][];
        CountDownLatch latch = new CountDownLatch(rows.length);

        for (int i = 0; i < rows.length; i++) {
            Socket socket = new Socket();
            ObjectOutputStream outputStream = null;
            ObjectInputStream inputStream = null;

            try {
                socket.connect(new InetSocketAddress(serverAddress, serverPort));
                outputStream = new ObjectOutputStream(socket.getOutputStream());
                inputStream = new ObjectInputStream(socket.getInputStream());
            } catch (Exception e) {
                System.out.println("In Client.java...");
                System.out.println(e);
            }

            exec.execute(new ClientRunnable(outputStream, inputStream, rows[i], method, result, latch, i));
        }

        try {
            latch.await();
        } catch (Exception e) {
            System.out.println("In Client.java...");
            System.out.println(e);
        }

        return result;
    }
}
