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
            System.out.println("");
            System.out.println("Select an option:");
            System.out.println("1. Receive array.");
            System.out.println("2. Receive big integer.");
            System.out.println("3. Receive integer factors in array.");
            System.out.println("4. Receive integer factors in ArrayList.");
            System.out.println("5. Quit.");
            System.out.println("");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1: {
                    System.out.println("");
                    int[] factors = factorService.getIntArray();
                    for (int factor : factors) {
                        System.out.println(factor);
                    }
                    break;
                }
                case 2: {
                    System.out.println("");
                    BigInteger bigInt = factorService.getBigInteger();
                    System.out.println(bigInt);
                    break;
                }
                case 3: {
                    System.out.println("");
                    System.out.println("Enter integer: ");
                    String inputInt = scanner.nextLine();
                    System.out.println("");

                    BigInteger bigInt = new BigInteger(inputInt);

                    BigInteger[] factors = factorService.factor(bigInt);

                    for (BigInteger factor : factors) {
                        System.out.println(factor);
                    }

                    break;
                }
                case 4: {
                    System.out.println("Enter integer: ");
                    String inputInt = scanner.nextLine();
                    System.out.println("");

                    BigInteger bigInt = new BigInteger(inputInt);

                    ArrayList<BigInteger> factors = factorService.factorArrayList(bigInt);

                    for (BigInteger factor : factors) {
                        System.out.println(factor);
                    }
                    break;
                }
                case 5: {
                    again = false;
                    break;
                }
            }
        }

        factorService.close();
        scanner.close();
    }
}
