package paul.liibert.modules.mvc.cache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import paul.liibert.modules.mvc.cache.AbstractService;
import paul.liibert.modules.mvc.cache.dao.ModulesDAO;
import paul.liibert.modules.mvc.dto.ModulesDTO;

@Service
@CacheConfig(cacheNames = {"modules"})
public class ModulesService extends AbstractService {

    @Autowired
    public ModulesService() {

    }

    public long add(ModulesDTO modulesDTO) {
        long id = idCounter.getAndIncrement();

        ModulesDAO modulesDAO = new ModulesDAO(id, modulesDTO.getName());

        save(modulesDAO);

        return id;
    }

    public boolean find(long module) {
        return all().stream().anyMatch(x -> ((ModulesDAO) x).getId() == module);
    }
}
