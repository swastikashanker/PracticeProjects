package example.exception;

public class TutorialFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public TutorialFoundException() {
        super("Tutorial with this id is already present !! try with another id");
    }

    public TutorialFoundException(String msg) {
        super(msg);
    }
}
