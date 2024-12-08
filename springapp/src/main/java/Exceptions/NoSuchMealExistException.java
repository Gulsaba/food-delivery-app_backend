package Exceptions;

public class NoSuchMealExistException extends RuntimeException{
	private String msg;
	
	public NoSuchMealExistException(String msg) {
		super();
		this.msg = msg;
	}

}
