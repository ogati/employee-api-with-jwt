package ca.gc.aafc.employee.api.exception;

public class UserNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
    public UserNotFoundException(String error) {
        super(error);
    }
}
