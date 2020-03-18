package paul.liibert.modules.mvc.cache;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class AbstractService {

    protected AtomicLong idCounter = new AtomicLong();
    @Getter
    private List<Object> values = new ArrayList<>();

    protected void save(Object object) {
        values.add(object);
    }

    public List<Object> all() {
        return values;
    }
}
