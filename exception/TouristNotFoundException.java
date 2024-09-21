package in.priyankait.exception;

public class TouristNotFoundException extends RuntimeException{
	public TouristNotFoundException(String message) {
		super(message); 
	}
}
