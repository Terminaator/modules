package paul.liibert.modules.mvc.error.type;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvalidValueException extends RuntimeException {

    private long module;

    public InvalidValueException(String message) {
        super(message);
    }
}
