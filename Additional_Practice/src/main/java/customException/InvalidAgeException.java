package customException;

public class InvalidAgeException extends Exception {
	private static final long serialVersionUID = 1L;

	InvalidAgeException(String S) { // constructor
		super(S);
	}
}