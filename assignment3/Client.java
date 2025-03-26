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
			System.out.println("1. Receive array.");
			System.out.println("2. Receive big integer.");
			System.out.println("3. Receive big integer array.");
			System.out.println("4. Receive big integer list.");
			System.out.println("5. Quit.");

			int option = scanner.nextInt();
            scanner.nextLine();

			if (option == 1) {
                System.out.println("Enter integer: ");
                String inputInt = scanner.nextLine();

                BigInteger bigInt = new BigInteger(inputInt);

				BigInteger[] factors = factorService.factor(bigInt);

                for (BigInteger factor : factors) {
                    System.out.println(factor);
                }

			} else if (option == 2) {
                System.out.println("Enter integer: ");
                String inputInt = scanner.nextLine();

                BigInteger bigInt = new BigInteger(inputInt);

				boolean isPrime = factorService.isPrime(bigInt);

                System.out.println(isPrime);

			} else if (option == 3) {
				again = false;
            }
		}

		scanner.close();
	}
}
