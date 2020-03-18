package paul.liibert.modules.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import paul.liibert.modules.mvc.cache.service.ModulesService;
import paul.liibert.modules.mvc.dto.ErrorDTO;
import paul.liibert.modules.mvc.dto.ModulesDTO;

@Controller
public class ModulesController {

    private final String PAGE = "modules";
    private final ModulesService modulesService;

    @Autowired
    public ModulesController(ModulesService modulesService) {
        this.modulesService = modulesService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("module", new ModulesDTO());
        model.addAttribute("modules", modulesService.all());
        return PAGE;
    }

    @PostMapping("/modules/save")
    public String save(@ModelAttribute ModulesDTO modulesDTO, Model model) {
        return "redirect:/module/" + modulesService.add(modulesDTO);
    }
}
