package paul.liibert.modules.mvc.cache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import paul.liibert.modules.mvc.cache.AbstractService;
import paul.liibert.modules.mvc.cache.dao.ModuleDAO;
import paul.liibert.modules.mvc.dto.ModuleDTO;
import paul.liibert.modules.mvc.error.type.InvalidValueException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@CacheConfig(cacheNames = {"module"})
public class ModuleService extends AbstractService {

    @Autowired
    public ModuleService() {

    }

    public void add(ModuleDTO moduleDTO) {
        Long root = moduleDTO.getRoot();

        if (!find(root, 0)) {
            InvalidValueException invalidValueException = new InvalidValueException("Invalid root value: " + root);
            invalidValueException.setModule(moduleDTO.getModule());
            throw invalidValueException;
        }

        long id = idCounter.getAndIncrement();

        ModuleDAO moduleDAO = new ModuleDAO(id, moduleDTO.getModule(), moduleDTO.getRoot(), moduleDTO.getText());

        save(moduleDAO);

    }

    private boolean find(Long root, int count) {
        if (count == 3) return false;
        if (root == null) return true;

        ModuleDAO moduleDAO = (ModuleDAO) getValues().stream().filter(x -> ((ModuleDAO) x).getId() == root).findFirst().orElse(null);

        if (moduleDAO != null) {
            return find(moduleDAO.getRoot(), ++count);
        } else {
            return false;
        }
    }

    public List<Object> findAll(long module) {
        return all().stream().filter(x -> ((ModuleDAO) x).getModule() == module).collect(Collectors.toList());
    }
}
