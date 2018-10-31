package exceptions;

@SuppressWarnings("serial")
public class StackUnderflowException extends Exception {

	public StackUnderflowException() {
		super("The stack is already empty.");
	}
}
