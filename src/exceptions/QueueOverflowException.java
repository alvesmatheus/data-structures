package exceptions;

@SuppressWarnings("serial")
public class QueueOverflowException extends Exception {

	public QueueOverflowException() {
		super("The queue is already full.");
	}

}
