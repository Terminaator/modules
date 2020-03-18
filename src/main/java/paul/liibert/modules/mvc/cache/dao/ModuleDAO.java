package paul.liibert.modules.mvc.cache.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ModuleDAO {
    private long id;
    private long module;
    private Long root;
    private String text;

}
