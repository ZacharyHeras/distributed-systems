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
            System.out.println("3. Receive integer factors in array.");
            System.out.println("4. Receive integer factors in ArrayList.");
            System.out.println("5. Quit.");

            int option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                int[] factors = factorService.getIntArray();

                for (int factor : factors) {
                    System.out.println(factor);
                }

            } else if (option == 2) {
                BigInteger bigInt = factorService.getBigInteger();
                System.out.println(bigInt);

            } else if (option == 3) {
                System.out.println("Enter integer: ");
                String inputInt = scanner.nextLine();

                BigInteger bigInt = new BigInteger(inputInt);

                BigInteger[] factors = factorService.factor(bigInt);

                for (BigInteger factor : factors) {
                    System.out.println(factor);
                }
                System.out.println(bigInt);

            } else if (option == 4) {
                System.out.println("Enter integer: ");
                String inputInt = scanner.nextLine();

                BigInteger bigInt = new BigInteger(inputInt);

                ArrayList<BigInteger> factors = factorService.factorArrayList(bigInt);

                for (BigInteger factor : factors) {
                    System.out.println(factor);
                }

            } else if (option == 5) {
                again = false;
            }
        }

        scanner.close();
    }
}
