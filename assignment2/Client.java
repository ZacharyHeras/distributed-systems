import java.io.*;
import java.net.*;
import java.util.*;

class Client {

	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);

		boolean again = true;

		while (again) {
			System.out.println("Type 0 to factorize an integer, type 1 to determine if an integer is prime, or type 2 to quit.");
			int num = input.nextInt();

			if (num == 2) {
				again = false;
			} else {
				System.out.println("Enter integer.");
				System.out.println(DistributedFactorizer.factor(input.nextLine(), num));
			}

		}

		input.close();

	}
}
