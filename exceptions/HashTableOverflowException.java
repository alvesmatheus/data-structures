package exceptions;

@SuppressWarnings("serial")
public class HashTableOverflowException extends RuntimeException {

	public HashTableOverflowException() {
		super("The hash table is already full.");
	}

}
