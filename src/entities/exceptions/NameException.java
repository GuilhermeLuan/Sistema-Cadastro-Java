package entities.exceptions;

public class NameException extends Exception{
    public NameException(String msg){
        super(msg);
    }

    public NameException(String msg, Throwable cause){
        super(msg, cause);
    }
}
