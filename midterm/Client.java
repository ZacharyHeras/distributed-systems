
import java.io.*;
import java.math.*;
import java.net.*;
import java.util.*;

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

			if (option == 0) {
                System.out.println("Enter integer: ");
                String inputInt = scanner.nextLine();

                BigInteger bigInt = new BigInteger(inputInt);

				BigInteger[] factors = factorService.factor(bigInt);

                for (BigInteger factor : factors) {
                    System.out.println(factor);
                }

			} else if (option == 1) {
                System.out.println("Enter integer: ");
                String inputInt = scanner.nextLine();

                BigInteger bigInt = new BigInteger(inputInt);

				boolean isPrime = factorService.isPrime(bigInt);

                System.out.println(isPrime);

			} else if (option == 2) {
				again = false;
            }
		}

		scanner.close();
	}
}
