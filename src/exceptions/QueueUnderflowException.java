package exceptions;

@SuppressWarnings("serial")
public class QueueUnderflowException extends Exception {

	public QueueUnderflowException() {
		super("The queue is already empty.");
	}

}
