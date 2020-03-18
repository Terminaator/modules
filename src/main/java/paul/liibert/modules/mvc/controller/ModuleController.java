package paul.liibert.modules.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import paul.liibert.modules.mvc.cache.service.ModuleService;
import paul.liibert.modules.mvc.cache.service.ModulesService;
import paul.liibert.modules.mvc.dto.ModuleDTO;
import paul.liibert.modules.mvc.error.type.NoSuchValueException;

@Controller
public class ModuleController {

    private final ModuleService moduleService;
    private final ModulesService modulesService;

    @Autowired
    public ModuleController(ModuleService moduleService, ModulesService modulesService) {
        this.moduleService = moduleService;
        this.modulesService = modulesService;
    }

    @GetMapping("/module/{module}")
    public String index(Model model, @PathVariable long module) {

        if (!modulesService.find(module)) {
            throw new NoSuchValueException("No such value: " + module );
        }

        model.addAttribute("module", new ModuleDTO(module));
        model.addAttribute("modules", moduleService.findAll(module));
        return "module";
    }

    @PostMapping("/module/save")
    public String save(@ModelAttribute ModuleDTO moduleDTO, Model model) {
        moduleService.add(moduleDTO);
        return "redirect:/module/" + moduleDTO.getModule();
    }
}
