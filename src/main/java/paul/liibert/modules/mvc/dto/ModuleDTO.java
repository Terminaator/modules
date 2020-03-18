package paul.liibert.modules.mvc.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModuleDTO {
    private long module;
    private long id;
    private String text;
    private Long root;

    public ModuleDTO(long module) {
        this.module = module;
    }
}
