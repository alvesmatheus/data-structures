package exceptions;

public class QueueOverflowException extends Exception {

	public QueueOverflowException() {
		super("The queue is already full.");
	}

}
