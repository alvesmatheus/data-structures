package exceptions;

@SuppressWarnings("serial")
public class UnsupportedHashingMethodException extends RuntimeException {

	public UnsupportedHashingMethodException() {
		super("This hashing method is not specified in this case.");
	}

}
