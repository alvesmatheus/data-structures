package exceptions;

public class StackUnderflowException extends Exception {

	public StackUnderflowException() {
		super("The stack is already empty.");
	}
}
