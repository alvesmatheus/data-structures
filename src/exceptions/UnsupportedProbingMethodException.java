package exceptions;

@SuppressWarnings("serial")
public class UnsupportedProbingMethodException extends RuntimeException {

	public UnsupportedProbingMethodException() {
		super("This probing method is not specified in this case.");
	}

}
