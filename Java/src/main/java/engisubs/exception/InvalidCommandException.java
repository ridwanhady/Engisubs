package engisubs.exception;

import java.lang.Exception;
public class InvalidCommandException extends Exception{
	// Parameterless Constructor
    public InvalidCommandException() {}

    // Constructor that accepts a message
    public InvalidCommandException(String message){
        super(message);
    }
}