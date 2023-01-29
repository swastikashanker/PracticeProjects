package mongodbexample.exception;

public class BookFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public BookFoundException() {
        super("Book with this id is already present !! try with another id");
    }

    public BookFoundException(String msg) {
        super(msg);
    }
}
