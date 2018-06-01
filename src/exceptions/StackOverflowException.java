package exceptions;

public class StackOverflowException extends Exception {

	public StackOverflowException() {
		super("The stack is already full.");
	}

}
