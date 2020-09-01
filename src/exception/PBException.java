package exception;

public class PBException extends Exception {

    private String lMessage;

    public PBException(String message) {
        super(message);
        this.lMessage = message;
    }

    public String getMessage() {
        return lMessage;
    }
}
