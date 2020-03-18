package paul.liibert.modules.mvc.error.type;

public class NoSuchValueException extends RuntimeException {
    public NoSuchValueException(String error) {
        super(error);
    }
}
