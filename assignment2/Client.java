import java.io.*;
import java.math.*;
import java.net.*;
import java.util.*;

class Client {
	public static void main(String[] args) {
        FactorizerServiceProxy factorService = new FactorizerServiceProxy();
		Scanner scanner = new Scanner(System.in);

		boolean again = true;

		while (again) {
            System.out.println("Select an option:");
			System.out.println("0. Factorize an integer.");
			System.out.println("1. Determine if an integer is prime.");
			System.out.println("2. Quit.");

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
