package hashTable;

/**
 * This class contains useful methods for performing calculations needed during
 * hash table operations.
 * 
 * @author Matheus Alves dos Santos
 * 
 */
public class Util {

	/**
	 * Determines if a specified number is a prime number or not.
	 * 
	 * @param number
	 *            the number to be tested.
	 * 
	 * @return true if the number is prime. False, otherwise.
	 * 
	 */
	public static boolean isPrime(long number) {
		boolean answer = true;
		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				answer = false;
				break;
			}
		}

		return answer;
	}

	/**
	 * Finds the first prime number greater or equal than a specified number.
	 * 
	 * @param number
	 *            the number used as start.
	 * 
	 * @return The first prime number greater or equal than the given number.
	 * 
	 */
	public static int getPrimeAbove(int number) {
		int primeNumber = number;

		while (!isPrime(primeNumber)) {
			primeNumber++;
		}

		return primeNumber;
	}

}